package com.aureliasalma0066.assessment1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aureliasalma0066.assessment1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, shape: String) {

    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }

    var error1 by remember { mutableStateOf(false) }
    var error2 by remember { mutableStateOf(false) }

    val label1 = when (shape) {
        "Persegi Panjang" -> "Panjang"
        "Segitiga" -> "Alas"
        "Lingkaran" -> "Jari-jari"
        "Persegi" -> "Sisi"
        else -> "Input 1"
    }

    val label2 = when (shape) {
        "Persegi Panjang" -> "Lebar"
        "Segitiga" -> "Tinggi"
        else -> ""
    }

    val imageRes = when (shape) {
        "Segitiga" -> R.drawable.segitiga
        "Lingkaran" -> R.drawable.lingkaran
        "Persegi" -> R.drawable.persegi
        else -> R.drawable.persegipanjang
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(shape) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
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

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = input1,
                onValueChange = { input1 = it },
                label = { Text(label1) },
                placeholder = { Text("Masukkan $label1") },
                isError = error1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = { if (error1) Icon(Icons.Filled.Warning, null) },
                modifier = Modifier.fillMaxWidth()
            )
            if (shape == "Persegi Panjang" || shape == "Segitiga") {
                OutlinedTextField(
                    value = input2,
                    onValueChange = { input2 = it },
                    label = { Text(label2) },
                    placeholder = { Text("Masukkan $label2") },
                    isError = error2,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    trailingIcon = { if (error2) Icon(Icons.Filled.Warning, null) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = {

                    val a = input1.toFloatOrNull()
                    val b = input2.toFloatOrNull()

                    error1 = a == null
                    error2 = if (shape == "Persegi Panjang" || shape == "Segitiga") {
                        b == null
                    } else false

                    if (error1 || error2) return@Button

                    val luas: Float
                    val keliling: Float

                    when (shape) {
                        "Segitiga" -> {
                            luas = 0.5f * a!! * b!!
                            keliling = a + b + b // asumsi segitiga sama kaki
                        }
                        "Lingkaran" -> {
                            luas = 3.14f * a!! * a
                            keliling = 2 * 3.14f * a
                        }
                        "Persegi" -> {
                            luas = a!! * a
                            keliling = 4 * a
                        }
                        else -> {
                            luas = a!! * b!!
                            keliling = 2 * (a + b)
                        }
                    }

                    navController.navigate("result/$luas/$keliling")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Hitung")
            }
        }
    }
}