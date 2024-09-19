package com.projects.android_playground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.projects.android_playground.screens.ButtonScreen
import com.projects.android_playground.screens.DigitsInputScreen
import com.projects.android_playground.screens.ExerciseScreen
import com.projects.android_playground.screens.MenuScreen
import com.projects.android_playground.screens.StartScreen
import com.projects.android_playground.screens.WorkoutArchiveScreen

@Composable
fun AppNavigation() {
    val navController : NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartScreen.route ){
        composable(Screen.StartScreen.route){ StartScreen(navController = navController)}
        composable(Screen.ButtonScreen.route){ ButtonScreen(navController = navController)}
        composable(Screen.DigitsInput.route){DigitsInputScreen (navController = navController)}
        composable(Screen.WorkoutArchive.route){ WorkoutArchiveScreen(
            navController = navController,
        )}
        composable(Screen.WorkoutScreen.route){ ExerciseScreen(navController = navController) }
        composable(Screen.MenuScreen.route){ MenuScreen(navController = navController)}
    }
}