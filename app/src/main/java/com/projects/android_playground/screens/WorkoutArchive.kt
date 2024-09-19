package com.projects.android_playground.screens

import WorkoutViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun WorkoutArchiveScreen(navController: NavController, workoutViewModel: WorkoutViewModel = viewModel()) {
    var showBodyPartDialog by remember { mutableStateOf(false) }
    var bodyPart by remember { mutableStateOf("") }

    // Observe the workout list from the ViewModel
    val workoutList by workoutViewModel.workoutList.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = { navController.popBackStack() },
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the workout list
            workoutList.forEach { workout ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable { navController.navigate("exercise_screen") }
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = workout.bodyPart,
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = SimpleDateFormat("yyyy-MM-dd",
                        Locale.getDefault()).format(workout.createdAt)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    IconButton(
                        onClick = { workoutViewModel.deleteWorkout(workout.id) }
                    )
                    {
                        Icon(Icons.Default.Delete, contentDescription = "Delete workout")
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))

            }

            Spacer(modifier = Modifier.weight(1f))

            FloatingActionButton(
                onClick = { showBodyPartDialog = true }, // Trigger dialog
                modifier = Modifier.size(64.dp)
            ) {
                Icon(
                    Icons.Default.AddCircle,
                    contentDescription = "Start workout",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Black
                )
            }
        }

        // Show dialog if required
        if (showBodyPartDialog) {
            AlertDialog(
                onDismissRequest = { showBodyPartDialog = false },
                title = { Text(text = "Enter Body Part") },
                text = {
                    OutlinedTextField(
                        value = bodyPart,
                        onValueChange = { bodyPart = it },
                        label = { Text(text = "Body Part") },
                        singleLine = true
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (bodyPart.isNotBlank()) {
                                workoutViewModel.addWorkout(bodyPart)
                                showBodyPartDialog = false
                                navController.navigate("exercise_screen")
                            }
                        }
                    ) {
                        Text("Start Workout")
                    }
                },
                dismissButton = {
                    Button(onClick = { showBodyPartDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}