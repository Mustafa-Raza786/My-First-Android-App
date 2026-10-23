package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstApplicationTheme {
                Surface {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = "home"
                    ) {
                        composable(route = "home") {
                            HomeScreen {
                                navHostController.navigate(route = "second")
                            }
                        }

                        composable(route = "second") {
                            SecondScreen {
                                val intent = Intent(this@MainActivity, NewActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onGoClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            onGoClick()
        }) {
            Text(text = "go")
        }
    }
}

@Composable
fun SecondScreen(onGoClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            onGoClick()
        }) {
            Text(text = "go new activity")
        }
    }
}
