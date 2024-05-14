package com.example.licenta.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.licenta.R

sealed class BottomNavScreen(val route: String, val title: String, val icon: Int) {
    object Training : BottomNavScreen("training", "Training", R.drawable.ic_training)
    object Progress : BottomNavScreen("progress", "Progress", R.drawable.ic_progress)
    object Settings : BottomNavScreen("settings", "Settings", R.drawable.ic_settings)
    object ChatBot : BottomNavScreen("chatbot", "ChatBot", R.drawable.ic_chat)
}

object BottomMenu {
    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            BottomNavScreen.Training,
            BottomNavScreen.Progress,
            BottomNavScreen.Settings,
            BottomNavScreen.ChatBot
        )
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ) {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.title) },
                    label = { Text(text = screen.title) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
