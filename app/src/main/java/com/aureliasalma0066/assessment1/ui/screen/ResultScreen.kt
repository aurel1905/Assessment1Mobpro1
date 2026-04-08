package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
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
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali")
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Filled.Calculate,
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Hasil Perhitungan",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Luas",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "$luas cm²",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Divider()

                    Text(
                        text = "Keliling",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "$keliling cm",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = { navController.popBackStack() }
                ) {
                    Text("Kembali")
                }

                OutlinedButton(
                    onClick = {
                        // nanti bisa buat share / reset dll
                        navController.popBackStack()
                    }
                ) {
                    Text("Hitung Lagi")
                }
            }
        }
    }
}