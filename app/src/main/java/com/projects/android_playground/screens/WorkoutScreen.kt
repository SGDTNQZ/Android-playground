package com.projects.android_playground.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun WorkoutScreen(navController: NavController){

    var exerciseName by remember {
        mutableStateOf("")
    }
    var weight by remember {
        mutableFloatStateOf(0f)
    }
    var reps by remember {
        mutableIntStateOf(0)
    }
    var set by remember {
        mutableIntStateOf(0)
    }
    Column (modifier = Modifier.fillMaxSize()
    ){
        FloatingActionButton(
        onClick = { navController.popBackStack()},
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(16.dp),
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Back"
        )
    }
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(text = "Body part")
        }
        ExerciseHeader()
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = exerciseName,
                onValueChange = {exerciseName = it },
                label = { Text(text = "Name")},
            )
            OutlinedTextField(
                modifier = Modifier.weight(0.5f),
                value = if(weight == 0f)"" else weight.toString(),
                onValueChange = {weight = it.toFloatOrNull() ?: 0f},
                label = { Text(text = "Weight")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            OutlinedTextField(
                modifier = Modifier.weight(0.4f),
                value = if(reps == 0)"" else reps.toString(),
                onValueChange = {reps = it.toIntOrNull() ?: 0},
                label = { Text(text = "Reps")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(0.2f)
                    .height(IntrinsicSize.Min),
                ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add exercise"
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .border(1.dp, Color.Black, RectangleShape),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}
@Composable
fun ExerciseHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,

    ) {
        Text(
            text = "Exercise name",
            fontSize = 20.sp,
            color = Color.White,

            )
        Divider(
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Weight",
            fontSize = 20.sp,
            color = Color.White
        )
        Divider(
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Reps",
            fontSize = 20.sp,
            color = Color.White,
            )
        Divider(
            color = Color.White,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Set",
            fontSize = 20.sp,
            color = Color.White,
            )
    }
}