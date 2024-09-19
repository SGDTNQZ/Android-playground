package com.projects.android_playground.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = { navController.popBackStack() },
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        val options = pastaRecipes.map{it.name}
        var selectedOption by remember {
            mutableStateOf(options[0])
        }
        var expanded by remember {
            mutableStateOf(false)
        }
        var burgerExpanded by remember {
            mutableStateOf(false)
        }
        val selectedRecipeIngredients =
            pastaRecipes.find { it.name == selectedOption }?.ingredients ?: emptyList()

        optionBurgerMenu(
            burgerExpanded, { burgerExpanded = it },
            options, selectedOption, { selectedOption = it }
        )
        Spacer(modifier = Modifier.size(10.dp))

        optionsExposedDropDownMenu(
            expanded, { expanded = it },
            options, selectedOption, { selectedOption = it }
        )
        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = buildAnnotatedString {
                append("Ingredients for ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append(selectedOption)
                }
                append(":")
            },
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column{
            selectedRecipeIngredients.forEach { ingredient ->
                Text(text = "- $ingredient")
                Spacer(modifier = Modifier.size(10.dp))
            }
        }

    }
}

@Composable
fun optionBurgerMenu(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
){
    Box(
        modifier = Modifier.wrapContentSize()
    )
    {
        IconButton(onClick = { onExpandedChange(!expanded) }) {
            Icon(
                Icons.Default.Menu,
                contentDescription = "Burger Menu"
            )
        }
        
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) }
        ) {
            options.forEach {item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onOptionSelected(item)
                        onExpandedChange(false)
                    }
                )
            }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun optionsExposedDropDownMenu(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
){
    ExposedDropdownMenuBox(
        expanded = expanded ,
        onExpandedChange = { onExpandedChange(!expanded) }
    ) {

        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) }
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onOptionSelected(item)
                        onExpandedChange(false)
                    }
                )
            }
        }

    }
}


data class PastaRecipe(
    val name: String,
    val ingredients: List<String>
)
val pastaRecipes = listOf(
    PastaRecipe(
        name = "Spaghetti Carbonara",
        ingredients = listOf(
            "Spaghetti",
            "Eggs",
            "Parmesan cheese",
            "Pancetta",
            "Black pepper",
            "Salt"
        )
    ),
    PastaRecipe(
        name = "Pasta Bolognese",
        ingredients = listOf(
            "Pasta",
            "Ground beef",
            "Tomato sauce",
            "Onion",
            "Garlic",
            "Carrot",
            "Celery",
            "Olive oil",
            "Salt",
            "Black pepper"
        )
    )
)
