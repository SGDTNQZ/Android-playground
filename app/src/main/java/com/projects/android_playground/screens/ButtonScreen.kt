package com.projects.android_playground.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.projects.android_playground.navigation.Screen

@Composable
fun ButtonScreen(navController: NavController) {
    var sex = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize(),
    ) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(
                text = "Sex",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
                )
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "Male")
                    RadioButton(
                        selected = sex.value == "Male",
                        onClick = { sex.value = "Male" }
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "Female")
                    RadioButton(
                        selected = sex.value == "Female",
                        onClick = { sex.value = "Female" }
                    )
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(
                    text = "Your sex:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = sex.value,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}