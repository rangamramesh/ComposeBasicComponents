package com.ramesh.composepractice.learnnavigationComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LearnNavigationComponent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is Main Screen")
        Button(onClick = {
            navController.navigate("home") {
                popUpTo(0)
            }
        }) {
            Text(text = "Click to go Home Screen")
        }
    }
}

@Composable
fun NavigationHomeScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is Home Screen")
        Button(onClick = {
            navController.navigate("main") {
                popUpTo(0)
            }
        }) {
            Text(text = "Click to go Main Screen")
        }
    }
}


@Composable
fun DisplayNavComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { LearnNavigationComponent(navController) }
        composable("home") { NavigationHomeScreen(navController) }
    }
}