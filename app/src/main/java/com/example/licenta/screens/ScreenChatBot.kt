import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.SuccessResult



import com.example.licenta.ui.theme.UriCustomSaver
import kotlinx.coroutines.launch

@Composable
fun AppContent(viewModel: HomeViewModel = viewModel(),navController: NavController,scrollState: ScrollState) {
    val appUIState by viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val imageRequestBuilder = ImageRequest.Builder(LocalContext.current)
    val imageLoader = ImageLoader.Builder(LocalContext.current).build()

    screenChatBot(uiState = appUIState,navController,scrollState) { inputText->
        coroutineScope.launch {
            viewModel.questioning(userInput = inputText)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screenChatBot(uiState: HomeUIState, navController: NavController, scrollState: ScrollState, onSendClick: (String) -> Unit) {
    var userQues by rememberSaveable { mutableStateOf("") }

    var Label by remember {
        mutableStateOf("User input")
    }
    var Placeholder by remember {
        mutableStateOf("Ask a question")
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.navigate("Training") }
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(16.dp))
                TopAppBar(
                    title = { Text(text = "FitnessBot") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
        },
        bottomBar = {
            Column {
                Row(modifier = Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = userQues,
                        onValueChange = { userQues = it },
                        label = { Text(text = Label) },
                        placeholder = { Text(text = Placeholder) },
                        modifier = Modifier.fillMaxWidth(0.83f)
                    )
                    IconButton(onClick = {
                        if (userQues.isNotBlank()) {
                            Log.d("HomeScreen", "User question: $userQues")
                            onSendClick(userQues)
                            userQues = ""
                            Label = ""
                            Placeholder = ""
                        }
                    }, modifier = Modifier.padding(4.dp)) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = null)
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                when (uiState) {
                    is HomeUIState.Initial -> {
                        Log.d("HomeScreen", "State: Initial")
                    }
                    is HomeUIState.Loading -> {
                        Log.d("HomeScreen", "State: Loading")
                        CircularProgressIndicator()
                    }
                    is HomeUIState.Success -> {
                        Log.d("HomeScreen", "State: Success: ${uiState.outputText}")
                        Card(
                            modifier = Modifier
                                .padding(top = 22.dp)
                                .fillMaxWidth(),
                            shape = MaterialTheme.shapes.large,
                        ) {
                            Text(text = uiState.outputText, modifier = Modifier.padding(4.dp))
                        }
                    }
                    is HomeUIState.Error -> {
                        Log.d("HomeScreen", "State: Error")
                        Card(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .fillMaxWidth(),
                            shape = MaterialTheme.shapes.large,
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
                        ) {
                            Text(text = uiState.error)
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun preview(){
    AppContent(navController = rememberNavController(), scrollState = rememberScrollState())
}
