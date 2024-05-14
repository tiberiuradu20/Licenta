package com.example.licenta.simple_navigation

import com.example.licenta.R

sealed class BottomScreenNavigation(val route: String, val title: String, val icon: Int){

    object Training : BottomScreenNavigation("training", "Training", R.drawable.ic_training)
    object Progress : BottomScreenNavigation("progress", "Progress", R.drawable.ic_progress)
    object Settings : BottomScreenNavigation("settings", "Settings", R.drawable.ic_settings)
    object ChatBot : BottomScreenNavigation("chatbot", "ChatBot", R.drawable.ic_chat)

}