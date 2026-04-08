package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val options = listOf("Persegi Panjang", "Segitiga")
    var selected by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Smart Geometry Calculator",
            style = MaterialTheme.typography.titleLarge)

        Text("Aplikasi untuk menghitung luas dan keliling bangun datar.")

        // pilihan bangun datar
        options.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selected == item,
                        onClick = { selected = item },
                        role = Role.RadioButton
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = selected == item,
                    onClick = null
                )
                Text(text = item, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Button(
            onClick = {
                navController.navigate("main")
            }
        ) {
            Text("Mulai")
        }
    }
}