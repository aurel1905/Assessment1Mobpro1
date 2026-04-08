package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aureliasalma0066.assessment1.R


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
                title = { Text("Kalkulator Bangun Datar") }
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

            Image(
                painter = painterResource(id = R.drawable.persegi),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = panjang,
                onValueChange = { panjang = it },
                label = { Text("Panjang") },
                isError = panjangError,
                trailingIcon = {
                    if (panjangError) Icon(Icons.Filled.Warning, null)
                },
                supportingText = {
                    if (panjangError) Text("Input tidak valid")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lebar,
                onValueChange = { lebar = it },
                label = { Text("Lebar") },
                isError = lebarError,
                trailingIcon = {
                    if (lebarError) Icon(Icons.Filled.Warning, null)
                },
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

                    val p = panjang.toFloat()
                    val l = lebar.toFloat()

                    val luas = p * l
                    val keliling = 2 * (p + l)

                    navController.navigate("result/$luas/$keliling")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Hitung")
            }
        }
    }
}