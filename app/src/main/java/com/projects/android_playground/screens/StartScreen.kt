package com.projects.android_playground.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
    ) {
        Row ( modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Button playground")
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { navController.navigate("button_screen") })
            {
                Text(text = "Open Button Screen")
            }
        }
        Row ( modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Button playground")
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { navController.navigate("digitsInput_screen") }) 
            {
                Text(text = "Open Digits Input Screen")
            }
        }
        
        Row (modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
           Text(text = "Room stuff")
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = {navController.navigate("workoutArchive_screen")})
            {
             Text(text = "Open room stuff")   
            }
        }


    }
}