package com.example.licenta.simple_navigation

import androidx.compose.runtime.MutableState

sealed class Ecrane(val route: String) {
    object Home : Ecrane("home_screen")
    object SignUp : Ecrane("signup_screen")
    object SignIn : Ecrane("signin_screen")

}