package com.aureliasalma0066.assessment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.aureliasalma0066.assessment1.ui.screen.*
import com.aureliasalma0066.assessment1.ui.theme.Assessment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Assessment1Theme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {

                    composable("home") {
                        HomeScreen(navController)
                    }

                    composable("main/{shape}") { backStackEntry ->
                        val shape = backStackEntry.arguments?.getString("shape") ?: "Persegi Panjang"
                        MainScreen(navController, shape)
                    }

                    composable("result/{luas}/{keliling}") { backStackEntry ->
                        val luas = backStackEntry.arguments?.getString("luas")?.toFloat() ?: 0f
                        val keliling = backStackEntry.arguments?.getString("keliling")?.toFloat() ?: 0f

                        ResultScreen(navController, luas, keliling)
                    }
                }
            }
        }
    }
}