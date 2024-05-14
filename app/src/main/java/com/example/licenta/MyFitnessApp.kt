package com.example.licenta

import android.annotation.SuppressLint
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
import com.example.licenta.screens.SignInScreen
import com.example.licenta.screens.SignUpScreen
import com.example.licenta.screens.chatbotScreen
import com.example.licenta.screens.progressScreen
import com.example.licenta.screens.settingsScreen
import com.example.licenta.screens.trainingScreen
import com.example.licenta.simple_navigation.BottomScreenNavigation
import welcomeScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun myFitnessApp(){
    val navController= rememberNavController()
    val scrollState= rememberScrollState()
    Scaffold(
    ) {

        Navigation(navController = navController, scrollState = scrollState)
    }
}
@Composable
fun Navigation(navController: NavHostController,scrollState:ScrollState){///we get navGraph builder
    NavHost(navController = navController, startDestination = "WelcomeScreen" ){
        composable("WelcomeScreen"){
            welcomeScreen(navController = navController)
        }
        composable("SignUpScreen"){
           SignUpScreen(navController = navController)
        }
        composable("SignInScreen"){
            SignInScreen(navController=navController)
        }
        composable("Training"){
            trainingScreen(navController = navController,scrollState=scrollState)
        }
        composable("Progress"){
            progressScreen(navController = navController,scrollState=scrollState)
        }
        composable("Settings"){
            settingsScreen(navController = navController,scrollState=scrollState)
        }
        composable("Chatbot"){
            chatbotScreen(navController = navController,scrollState=scrollState)
        }

    }

}


