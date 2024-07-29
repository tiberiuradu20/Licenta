package com.example.licenta

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.licenta.dataClasses.training
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val _name = MutableLiveData("Tiberiu")
    val name: LiveData<String> = _name

    private var _birthday = MutableLiveData("10 mai 2001")
    val birthday: LiveData<String> = _birthday

    private val _height = MutableLiveData("188 cm")
    val height: LiveData<String> = _height

    private val _initialWeight = MutableLiveData("100 kg")
    val initialWeight: LiveData<String> = _initialWeight

    private val _actualWeight = MutableLiveData("97 kg")
    val actualWeight: LiveData<String> = _actualWeight

    private val _targetWeight = MutableLiveData("80 kg")
    val targetWeight: LiveData<String> = _targetWeight

    private val _LuniOrar = MutableLiveData("Selected")
    val luniOrar: LiveData<String> = _LuniOrar

    private val _MartiOrar = MutableLiveData("Unselected")
    val martiOrar: LiveData<String> = _MartiOrar

    private val _MiercuriOrar = MutableLiveData("Unselected")
    val miercuriOrar: LiveData<String> = _MiercuriOrar

    private val _JoiOrar = MutableLiveData("Unselected")
    val joiOrar: LiveData<String> = _JoiOrar

    private val _VineriOrar = MutableLiveData("Unselected")
    val vineriOrar: LiveData<String> = _VineriOrar

    private val _SambataOrar = MutableLiveData("Unselected")
    val sambataOrar: LiveData<String> = _SambataOrar

    private val _DuminicaOrar = MutableLiveData("Unselected")
    val duminicaOrar: LiveData<String> = _DuminicaOrar

    private val _selectedTrainings = MutableLiveData<List<training>>(listOf())


    var antrenamentulDeLuni: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeMarti: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeMiercuri: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeJoi: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeVineri: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeSambata: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var antrenamentulDeDuminica: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var exercitiuCurent = MutableLiveData<training>()
    var antrenamentulCurent: MutableLiveData<List<training>> = MutableLiveData(listOf())
    var email=MutableLiveData("tibibaesu@gmail.com")
    var currentDay = MutableLiveData("Luni")
    var uid = MutableLiveData("")
    private var zileDeAntrenament: MutableMap<String, Boolean> = hashMapOf(
        "Luni" to false,
        "Marti" to false,
        "Miercuri" to false,
        "Joi" to false,
        "Vineri" to false,
        "Sambata" to false,
        "Duminica" to false
    )
    val selectedTrainings: LiveData<List<training>> = antrenamentulCurent
    private val control = mutableListOf<training>()


    fun userId(da:String){
        uid.value = da
    }

    fun setEmail(newEmail:String){
        email.value=newEmail
    }
    fun getEmail() = email.value!!
    fun setExercitiuCurentStart(training: training){
        exercitiuCurent.value = training
    }

    fun getExercitiuCurentStart() = exercitiuCurent.value!!
    fun gestionareZile(zi: String) {
        zileDeAntrenament[zi] = true
        currentDay.value = zi
        when (currentDay.value){
            "Luni"->antrenamentulCurent = antrenamentulDeLuni
            "Marti"->antrenamentulCurent = antrenamentulDeMarti
            "Miercuri"->antrenamentulCurent = antrenamentulDeMiercuri
            "Joi"->antrenamentulCurent = antrenamentulDeJoi
            "Vineri"->antrenamentulCurent = antrenamentulDeVineri
            "Sambata"->antrenamentulCurent = antrenamentulDeSambata
            "Duminica"->antrenamentulCurent = antrenamentulDeDuminica
        }
    }
    fun iesireAntrenament(){
        zileDeAntrenament[currentDay.value!!]=false
    }

    fun selectTraining(training: training) {

        for((key,value) in zileDeAntrenament ){
            if(value){
                when(key){
                    "Luni"->{
                        val currentList = antrenamentulDeLuni.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Luni",currentList)
                        antrenamentulDeLuni.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeLuni
                    }
                    "Marti"->{
                        val currentList = antrenamentulDeMarti.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Marti",currentList)
                        antrenamentulDeMarti.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeMarti
                    }
                    "Miercuri"->{
                        val currentList = antrenamentulDeMiercuri.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Miercuri",currentList)
                        antrenamentulDeMiercuri.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeMiercuri
                    }
                    "Joi"->{
                        val currentList = antrenamentulDeJoi.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Joi",currentList)
                        antrenamentulDeJoi.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeJoi
                    }
                    "Vineri"->{
                        val currentList = antrenamentulDeVineri.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Vineri",currentList)
                        antrenamentulDeVineri.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeVineri
                    }
                    "Sambata"->{
                        val currentList = antrenamentulDeSambata.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Sambata",currentList)
                        antrenamentulDeSambata.value = currentList
                        currentDay.value = key
                        antrenamentulCurent = antrenamentulDeSambata
                    }
                    "Duminica"->{
                        val currentList = antrenamentulDeDuminica.value?.toMutableList() ?: mutableListOf()
                        if (currentList.contains(training)) {
                            currentList.remove(training)
                        } else {
                            currentList.add(training)
                        }
                        setamAntrenamentelePerZi("Duminica",currentList)
                        antrenamentulDeDuminica.value = currentList
                        currentDay.value = key
                        antrenamentulCurent=antrenamentulDeDuminica}
                }

                ///   zileDeAntrenament[key]=false
                break
            }
        }


    }
    fun setamAntrenamentelePerZi(day: String, trainings: MutableList<training>) {
        val userId = uid.value
        if (userId != null) {
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val dayRef: DatabaseReference = database.getReference("users/$userId/antrenamente/$day")

            // Șterge toate valorile existente pentru ziua respectivă
            dayRef.removeValue().addOnSuccessListener {
                Log.d("setamAntrenamentelePerZi", "Antrenamentele pentru $day au fost șterse cu succes.")

                // Adaugă fiecare antrenament din lista furnizată
                for (training in trainings) {
                    val newExerciseRef = dayRef.push() // Generează un identificator unic pentru fiecare antrenament
                    newExerciseRef.setValue(training)
                        .addOnSuccessListener {
                            Log.d("setamAntrenamentelePerZi", "Exercițiu adăugat cu succes pentru $day.")
                        }
                        .addOnFailureListener { exception ->
                            Log.e("setamAntrenamentelePerZi", "Eroare la adăugarea exercițiului pentru $day: ${exception.message}")
                        }
                }
            }.addOnFailureListener { exception ->
                Log.e("setamAntrenamentelePerZi", "Eroare la ștergerea antrenamentelor pentru $day: ${exception.message}")
            }
        } else {
            Log.e("setamAntrenamentelePerZi", "UID este null")
        }
    }
    fun setamDateleUtilizatorului() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()

        val informatiiFinale = mapOf(
            "Email" to email,
            "Greutate_Actuala" to _actualWeight,
            "Greutate_Initiala" to _initialWeight,
            "Greutate_Tinta" to _targetWeight,
            "Nume" to _name,
            "Data_Nasterii" to _birthday,
            "Inaltime" to _height
        )
        val userId = uid.value
        if (userId != null) {
            for ((key, value) in informatiiFinale) {
                val userRef: DatabaseReference = database.getReference("users/${uid.value}/informatii/$key")
                userRef.get().addOnSuccessListener { dataSnapshot ->
                    if (dataSnapshot.exists()) {
                        val info = dataSnapshot.getValue(String::class.java)
                        if (info != null) {
                            when (key) {
                                "Email" -> {value.value = info
                                Log.d("EMAIL","$info")}
                                "Greutate_Actuala" -> value.value = info
                                "Greutate_Initiala" -> value.value = info
                                "Greutate_Tinta" -> value.value = info
                                "Nume" ->{ value.value = info
                                Log.d("NUME","$info si identificatorul $userId")}
                                "Data_Nasterii" -> value.value = info
                                "Inaltime" -> value.value = info
                            }
                        } else {
                            Log.e("setamDateleUtilizatorului", "Eroare: Valoarea este null pentru cheia $key")
                        }
                    } else {
                        Log.d("setamDateleUtilizatorului", "Nu există date pentru cheia $key")
                    }
                }.addOnFailureListener { exception ->
                    Log.e("setamDateleUtilizatorului", "Eroare la citirea datelor pentru cheia $key: ${exception.message}")
                }
            }
        } else {
            Log.e("setamDateleUtilizatorului", "UID este null")
        }
    }

    

    fun setamAntrenamenteleSalvateDeUser() {
        val userId = uid.value
        if (userId != null) {
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val daysOfWeek = mapOf(
                "Luni" to antrenamentulDeLuni,
                "Marti" to antrenamentulDeMarti,
                "Miercuri" to antrenamentulDeMiercuri,
                "Joi" to antrenamentulDeJoi,
                "Vineri" to antrenamentulDeVineri,
                "Sambata" to antrenamentulDeSambata,
                "Duminica" to antrenamentulDeDuminica
            )

            for ((day, liveData) in daysOfWeek) {
                val dayRef: DatabaseReference = database.getReference("users/$userId/antrenamente/$day")
                dayRef.get().addOnSuccessListener { dataSnapshot ->
                    if (dataSnapshot.exists()) {
                        val trainings = dataSnapshot.children.mapNotNull {
                            try {
                                it.getValue(training::class.java)
                            } catch (e: Exception) {
                                Log.e("setamAntrenamenteleSalvateDeUser", "Eroare la conversie: ${e.message}")
                                null
                            }
                        }
                        liveData.postValue(trainings)
                        Log.d("setamAntrenamenteleSalvateDeUser", "Antrenamentele pentru $day au fost setate cu succes.")
                    } else {
                        Log.d("setamAntrenamenteleSalvateDeUser", "Nu există antrenamente salvate pentru $day.")
                    }
                }.addOnFailureListener { exception ->
                    Log.d("setamAntrenamenteleSalvateDeUser", "Eroare la setarea antrenamentelor pentru $day: ${exception.message}")
                }
            }
        } else {
            Log.e("setamAntrenamenteleSalvateDeUser", "UID este null")
        }
    }

    fun isTrainingSelected(training: training): Boolean {
        for((key,value) in zileDeAntrenament)
            if(key == currentDay.value)
                return antrenamentulCurent.value!!.contains(training)==true
        return antrenamentulCurent.value!!.contains(training)==true
    }

    fun updateZiOrar(ziua: String, newDay: String) {
        when (ziua) {
            "Luni" -> _LuniOrar.value = newDay
            "Marti" -> _MartiOrar.value = newDay
            "Miercuri" -> _MiercuriOrar.value = newDay
            "Joi" -> _JoiOrar.value = newDay
            "Vineri" -> _VineriOrar.value = newDay
            "Sambata" -> _SambataOrar.value = newDay
            "Duminica" -> _DuminicaOrar.value = newDay
        }
    }

    fun getZiuaOrar(ziua: String): String {
        return when (ziua) {
            "Luni" -> _LuniOrar.value.toString()
            "Marti" -> _MartiOrar.value.toString()
            "Miercuri" -> _MiercuriOrar.value.toString()
            "Joi" -> _JoiOrar.value.toString()
            "Vineri" -> _VineriOrar.value.toString()
            "Sambata" -> _SambataOrar.value.toString()
            "Duminica" -> _DuminicaOrar.value.toString()
            else -> "Eroare"
        }
    }

    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateBirthday(newBirthday: String) {
        _birthday.value = newBirthday
    }

    fun updateHeight(newHeight: String) {
        _height.value = newHeight
    }

    fun updateInitialWeight(newInitialWeight: String) {
        _initialWeight.value = newInitialWeight
    }

    fun updateActualWeight(newActualWeight: String) {
        _actualWeight.value = newActualWeight
    }

    fun updateTargetWeight(newTargetWeight: String) {
        _targetWeight.value = newTargetWeight
    }

    fun getInitialWeight(): Int {
        val weightString = _initialWeight.value ?: "0"
        return weightString.filter { it.isDigit() }.toIntOrNull() ?: 0
    }

    fun getActualWeight(): Int {
        val weightString = _actualWeight.value ?: "0"
        return weightString.filter { it.isDigit() }.toIntOrNull() ?: 0
    }

    fun getTargetWeight(): Int {
        val weightString = _targetWeight.value ?: "0"
        return weightString.filter { it.isDigit() }.toIntOrNull() ?: 0
    }
}