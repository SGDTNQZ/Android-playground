package com.projects.android_playground.navigation

sealed class Screen(val route: String){
    object StartScreen : Screen("start_screen")
    object ButtonScreen  : Screen("button_screen")
    object DigitsInput : Screen("digitsInput_screen")
    object WorkoutArchive : Screen("workoutArchive_screen")
    object WorkoutScreen : Screen("workout_screen")
}