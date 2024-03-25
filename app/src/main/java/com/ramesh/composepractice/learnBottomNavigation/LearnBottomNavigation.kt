package com.ramesh.composepractice.learnBottomNavigation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramesh.composepractice.ui.theme.Green

@Composable
fun LearnBottomNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var selected by remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Green) {
                IconButton(onClick = {
                    if (selected != Icons.Default.Home) {
                        selected = Icons.Default.Home
                        navController.navigate(BottomNavigationScreens.Home.scree) {
                            popUpTo(0)
                        }
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected == Icons.Default.Home) Color.Blue else Color.White
                    )
                }
                IconButton(onClick = {
                    if (selected != Icons.Default.Search) {
                        selected = Icons.Default.Search
                        navController.navigate(BottomNavigationScreens.Search.scree) {
                            popUpTo(0)
                        }
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = "Search",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected == Icons.Default.Search) Color.Blue else Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(onClick = {
                        Toast.makeText(context, "Open Bottom Sheet", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    }

                }
                IconButton(onClick = {
                    if (selected != Icons.Default.Notifications) {
                        selected = Icons.Default.Notifications
                        navController.navigate(BottomNavigationScreens.Notification.scree) {
                            popUpTo(0)
                        }
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected == Icons.Default.Notifications) Color.Blue else Color.White
                    )
                }
                IconButton(onClick = {
                    if (selected != Icons.Default.Person) {
                        selected = Icons.Default.Person
                        navController.navigate(BottomNavigationScreens.Profile.scree) {
                            popUpTo(0)
                        }
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected == Icons.Default.Person) Color.Blue else Color.White
                    )
                }
            }
        }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationScreens.Home.scree,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavigationScreens.Home.scree) { BottomHomeScreen() }
            composable(BottomNavigationScreens.Notification.scree) { BottomNotificationScreen() }
            composable(BottomNavigationScreens.Search.scree) { BottomSearchScreen() }
            composable(BottomNavigationScreens.Profile.scree) { BottomProfileScreen() }
        }
    }

}