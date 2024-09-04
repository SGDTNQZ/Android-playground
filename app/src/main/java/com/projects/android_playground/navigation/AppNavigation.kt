package com.projects.android_playground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.projects.android_playground.screens.ButtonScreen
import com.projects.android_playground.screens.DigitsInputScreen
import com.projects.android_playground.screens.StartScreen

@Composable
fun AppNavigation() {
    val navController : NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartScreen.route ){
        composable(Screen.StartScreen.route){ StartScreen(navController = navController)}
        composable(Screen.ButtonScreen.route){ ButtonScreen(navController = navController)}
        composable(Screen.DigitsInput.route){DigitsInputScreen (navController = navController)}
    }
}