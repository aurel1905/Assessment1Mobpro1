package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var panjang by remember { mutableStateOf("") }
    var panjangError by remember { mutableStateOf(false) }

    var lebar by remember { mutableStateOf("") }
    var lebarError by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Smart Geometry Calculator") }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text("Persegi Panjang", style = MaterialTheme.typography.titleLarge)

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Panjang") },
                isError = panjangError,
                supportingText = {
                    if (panjangError) Text("Input tidak valid")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Lebar") },
                isError = lebarError,
                supportingText = {
                    if (lebarError) Text("Input tidak valid")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    panjangError = panjang.isEmpty() || panjang == "0"
                    lebarError = lebar.isEmpty() || lebar == "0"

                    if (panjangError || lebarError) return@Button

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Hitung")
            }

        }
    }

}