package com.example.licenta

import AppContent
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.licenta.dataClasses.training
import com.example.licenta.screens.SignInScreen
import com.example.licenta.screens.SignUpScreen
import com.example.licenta.screens.actualWeight
import com.example.licenta.screens.antrenamentGestionatPeZile
import com.example.licenta.screens.birthday
import com.example.licenta.screens.chatbotScreen
import com.example.licenta.screens.fitnessAcasa
import com.example.licenta.screens.fitnessAcasaPicioare
import com.example.licenta.screens.fitnessAcasaPiept
import com.example.licenta.screens.fitnessAcasaSpate
import com.example.licenta.screens.inaltime
import com.example.licenta.screens.initialWeight
import com.example.licenta.screens.modificareEmail
import com.example.licenta.screens.nume
import com.example.licenta.screens.profileScreen

import com.example.licenta.screens.progressScreen
import com.example.licenta.screens.reminders


import com.example.licenta.screens.settingsScreen
import com.example.licenta.screens.siToUsc
import com.example.licenta.screens.targetWeight
import com.example.licenta.screens.tipDeExerciti
import com.example.licenta.screens.trainingScreen
import com.example.licenta.screens.tutorial
import com.example.licenta.simple_navigation.BottomScreenNavigation
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import welcomeScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun myFitnessApp(){
    val navController= rememberNavController()
    val scrollState= rememberScrollState()
    var profileViewModel = ProfileViewModel()


    Scaffold(
    ) {
        // profileViewModel.setamDateleUtilizatorului()
       // setamAntrenamenteleSalvateDeUser(profileViewModel)
        Navigation(navController = navController, scrollState = scrollState,profileViewModel)
    }
}

@Composable
fun Navigation(navController: NavHostController,scrollState:ScrollState,profileViewModel:ProfileViewModel){///we get navGraph builder

    NavHost(navController = navController, startDestination = "WelcomeScreen" ){
        composable("WelcomeScreen"){
            welcomeScreen(navController = navController)
        }
        composable("SignUpScreen"){
           SignUpScreen(navController = navController)
        }
        composable("SignInScreen"){
            SignInScreen(navController=navController,profileViewModel)
        }
        composable("Training"){
            trainingScreen(navController = navController,scrollState=scrollState,profileViewModel=profileViewModel)
        }
        composable("Progress"){
            progressScreen(navController = navController,scrollState=scrollState,profileViewModel)
        }
        composable("Settings"){
            settingsScreen(navController = navController,scrollState=scrollState)
        }
        composable("Chatbot"){
            chatbotScreen(navController = navController,scrollState=scrollState)
        }
        composable("ScreenChatBot"){
            AppContent(navController = navController,scrollState=scrollState)
        }
        composable("ProfileScreen"){
            profileScreen(navController = navController, scrollState =scrollState,profileViewModel  )
        }
        composable("Nume"){
            nume(navController = navController, scrollState =scrollState,profileViewModel)
        }
        composable("Birthday") {
            birthday(
                navController = navController,
                scrollState = scrollState,
                profileViewModel = profileViewModel)
        }
        composable("ActualWeight"){
            actualWeight(navController = navController, scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("InitialWeight"){
            initialWeight(navController = navController, scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("TargetWeight"){
            targetWeight(navController = navController, scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("Inaltime"){
            inaltime (navController = navController, scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("TipDeExerciti"){
           tipDeExerciti(navController = navController, scrollState =scrollState , profileViewModel )
        }
        composable("AntrenamentGestionatPeZile"){
            antrenamentGestionatPeZile(navController = navController,
                scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("FitnessAcasa"){
           fitnessAcasa(navController = navController, scrollState =scrollState , profileViewModel = profileViewModel )
        }
        composable("FitnessAcasaPicioare"){
          fitnessAcasaPicioare(navController = navController, scrollState =scrollState,profileViewModel = profileViewModel )
        }
        composable("FitnessAcasaSpate"){
            fitnessAcasaSpate(navController = navController, scrollState = scrollState, profileViewModel = profileViewModel  )
        }
        composable("Tutorial"){
            tutorial(navController = navController, scrollState =scrollState ,
                profileViewModel = profileViewModel)
        }
        composable("FitnessAcasaPiept"){
            fitnessAcasaPiept(navController = navController, scrollState = scrollState, profileViewModel = profileViewModel  )
        }
        composable("SiToUsc"){
            siToUsc(navController = navController, scrollState = scrollState, profileViewModel = profileViewModel)
        }
        composable("ModificareEmail"){
            modificareEmail(navController = navController, scrollState =scrollState , profileViewModel =profileViewModel )
        }
        composable("Reminders"){
            reminders(navController = navController,
                scrollState = scrollState ,
                profileViewModel = profileViewModel )
        }

    }

}


