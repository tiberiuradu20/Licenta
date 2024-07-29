import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUIState> = MutableStateFlow(HomeUIState.Initial)
    val uiState = _uiState.asStateFlow()
    private lateinit var generativeModel: GenerativeModel

    init {
        val config = generationConfig {
            temperature = 0.70f
        }
        generativeModel = GenerativeModel(
            modelName = "gemini-1.5-flash-latest",
            apiKey = "AIzaSyBxiJF4cZZLiCRwtxjuz2A_byfoIsejYS8",
            generationConfig = config
        )
    }

    fun questioning(userInput: String) {
        _uiState.value = HomeUIState.Loading
        val prompt = "Esti un chatBot dintr-o aplicatie de fitness, care oferi" +
                "raspunsuri scurte si precise anumitor intrebari legate de fitness. De" +
                "asemenea, nu esti proiectat sa dai raspunsuri prea complexe" +
                "Acum, raspunde la intrebarea user-ului: $userInput"
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val content = content {
                    text(prompt)
                }
                var output = ""
                Log.d("HomeViewModel", "Starting content generation")

                generativeModel.generateContentStream(content).collect {
                    Log.d("HomeViewModel", "Received chunk: ${it.text}")
                    output += it.text
                }

                Log.d("HomeViewModel", "Final output: $output")

                if (output.isNotBlank()) {
                    _uiState.value = HomeUIState.Success(output)
                    Log.d("HomeViewModel", "State updated to Success")
                } else {
                    throw Exception("Empty output from API")
                }
            } catch (e: Exception) {
                _uiState.value =
                    HomeUIState.Error(e.localizedMessage ?: "Error in generating content")
                Log.e("API Error", "Error generating content: ${e.localizedMessage}", e)
            }
        }
    }
}

sealed interface HomeUIState {
    object Initial : HomeUIState
    object Loading : HomeUIState
    data class Success(val outputText: String) : HomeUIState
    data class Error(val error: String) : HomeUIState
}
