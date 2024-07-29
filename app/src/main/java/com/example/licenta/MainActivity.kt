package com.example.licenta

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.licenta.dataClasses.training
import com.example.licenta.dateDeTest.Antrenament
import com.example.licenta.dateDeTest.AntrenamentPiept
import com.example.licenta.dateDeTest.AntrenamentSpate
import com.example.licenta.ui.theme.LicentaTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.installations.FirebaseInstallations
import welcomeScreen

class MainActivity : ComponentActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
       /* val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid != null) {
            profileViewModel.userId(uid)
        }*/
       //val sharedPreferences = getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
       // val isDataInitialized = sharedPreferences.getBoolean("isDataInitialized", false)
        //profileViewModel.setamDateleUtilizatorului()
       /* FirebaseInstallations.getInstance().id.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val installationId = task.result
                Log.d("MainActivity", "Installation ID: $installationId")
            } else {
                Log.e("MainActivity", "Unable to get Installation ID", task.exception)
            }
        }*/


        /*if (isDataInitialized) {
            profileViewModel.uid.observe(this) { uid ->
                if (uid != null) {
                    createTrainingNodes(uid)
                    dateUtilizator(uid)
                    for (i: training in Antrenament) {
                        addExerciseToDatabase(i, "Picioare", uid)
                    }
                    for (i: training in AntrenamentPiept) {
                        addExerciseToDatabase(i, "Piept", uid)
                    }
                    for (i: training in AntrenamentSpate) {
                        addExerciseToDatabase(i, "Spate", uid)
                    }

                    sharedPreferences.edit().putBoolean("isDataInitialized", true).apply()
                }
            }
        }*/
        setContent {
            LicentaTheme {
                myFitnessApp()
            }
        }
    }

    fun addExerciseToDatabase(exercise: training, category: String, uid: String) {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val exercisesRef: DatabaseReference = database.getReference("users/$uid/exercises/$category")

        val newExerciseRef = exercisesRef.push() // generate a unique key
        newExerciseRef.setValue(exercise)
            .addOnSuccessListener {
                Log.d("${category}", "Exercitiu adaugat cu succes")
            }
            .addOnFailureListener { exception ->
                Log.d("${category}", "Eroare ${exception.message}")
            }
    }

    fun createTrainingNodes(uid: String) {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val daysOfWeek = listOf("Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata", "Duminica")

        for (day in daysOfWeek) {
            val dayRef: DatabaseReference = database.getReference("users/$uid/antrenamente/$day")
            dayRef.setValue(Antrenament[0])
                .addOnSuccessListener {
                    Log.d("CreateTrainingNodes", "Nodul $day a fost creat cu succes")
                }
                .addOnFailureListener { exception ->
                    Log.d("CreateTrainingNodes", "Eroare la crearea nodului $day: ${exception.message}")
                }
        }
    }
    fun dateUtilizator(uid: String) {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val Datele = listOf("Nume",
            "Greutate_Initiala",
            "Greutate_Tinta",
            "Greutate_Actuala",
            "Inaltime",
            "Email",
            "Data_Nasterii")

        for (data in Datele) {
            val dataRef: DatabaseReference = database.getReference("users/$uid/informatii/$data")
            dataRef.setValue("Completati")
                .addOnSuccessListener {
                  //  Log.d("CreateTrainingNodes", "Nodul $day a fost creat cu succes")
                }
                .addOnFailureListener { exception ->
                   // Log.d("CreateTrainingNodes", "Eroare la crearea nodului $day: ${exception.message}")
                }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LicentaTheme {
        Greeting("Android")
    }
}
