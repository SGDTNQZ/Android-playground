package com.projects.android_playground.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.projects.android_playground.ui.theme.Yellow
import kotlin.math.pow
import kotlin.reflect.typeOf

@Composable
fun DigitsInputScreen (navController: NavController){
    var weightAsString by remember {
        mutableStateOf("")
    }
    var heightAsString by remember {
        mutableStateOf("")
    }
    var height : Float? = heightAsString.toFloatOrNull()
    var weight : Float? = weightAsString.toFloatOrNull()

    val pattern = Regex("^\\d*\\.?\\d*\$")
    val bmi = bmiCalc(weight, height)
    val (status, color) = getBMIStatus(bmi)

    Column(
        modifier = Modifier.fillMaxSize()
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
                .padding(16.dp)
        ) {
//            Weight field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){

                Text(
                    text = "Weight",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                OutlinedTextField(
                    value = weightAsString,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            weightAsString = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
            }

//            Height field
            Spacer(modifier = Modifier.size(10.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){

                Text(
                    text = "Height",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                OutlinedTextField(
                    value = heightAsString,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            heightAsString = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.size(10.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text ="Weight:  ${weight?.takeIf { it != 0.toFloat() } ?: 0} kg",
                    fontSize = 16.sp
                )

            }

            Spacer(modifier = Modifier.size(5.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text ="Height:  ${height?.takeIf { it != 0.toFloat() } ?: 0} cm",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.size(5.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "Your BMI: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                    )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "${"%.2f".format(bmi)} ($status)",
                    color =  color,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(DarkGray)
                        .padding(5.dp)
                )
            }
        }
    }
}

fun bmiCalc(weight : Float?, height : Float? ): Float {
    var bmi = 0f
    if( height != 0.0f || weight != 0.0f){
        if (weight != null && height != null) {
            bmi = weight / (height/100).pow(2)
        }
    }
    else{
        return 0.0f
    }
    return bmi
}

fun getBMIStatus(bmi: Float): Pair<String, androidx.compose.ui.graphics.Color> {
    return when {
        bmi < 18.5 -> "Underweight" to Yellow
        bmi in 18.5..24.9 -> "Healthy Weight" to Green
        bmi in 25.0..29.9 -> "Overweight" to Yellow
        else -> "Obesity" to Red
    }
}