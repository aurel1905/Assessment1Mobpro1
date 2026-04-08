package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(navController: NavController, luas: Float, keliling: Float) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hasil Perhitungan") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("<")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text("Luas: $luas", style = MaterialTheme.typography.headlineMedium)
            Text("Keliling: $keliling", style = MaterialTheme.typography.headlineMedium)

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Kembali")
            }
        }
    }
}
