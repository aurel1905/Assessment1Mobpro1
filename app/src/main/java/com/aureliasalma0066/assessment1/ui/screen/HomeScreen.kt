package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val options = listOf(
        "Persegi Panjang",
        "Segitiga",
        "Lingkaran",
        "Persegi"
    )

    var selected by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Smart Geometry Calculator",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text(
                text = "Aplikasi ini digunakan untuk menghitung luas dan keliling berbagai bangun datar seperti persegi panjang, segitiga, lingkaran, dan persegi.",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = "Pilih bangun datar:",
            style = MaterialTheme.typography.titleMedium
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
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
                        Text(
                            text = item,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("main/$selected")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Mulai")
        }
    }
}