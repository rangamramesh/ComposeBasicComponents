package com.ramesh.composepractice.learnNavigationDrawer

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramesh.composepractice.ui.theme.Green
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavigationDrawer() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Box(
                modifier = Modifier
                    .background(Green)
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "")
            }
            Divider()
            NavigationDrawerItem(label = { Text(text = "Home", color = Green) },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    navController.navigate(NavigationDrawerScreens.Home.screen) {
                        popUpTo(0)
                    }
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                })
            NavigationDrawerItem(label = { Text(text = "Profile", color = Green) },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    navController.navigate(NavigationDrawerScreens.Profile.screen) {
                        popUpTo(0)
                    }
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile")
                })
            NavigationDrawerItem(label = { Text(text = "Settings", color = Green) },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    navController.navigate(NavigationDrawerScreens.Settings.screen) {
                        popUpTo(0)
                    }
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
                })
            NavigationDrawerItem(label = { Text(text = "Logout", color = Green) },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                    Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                })

        }
    }, drawerState = drawerState, gesturesEnabled = true) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "Navigation Drawer", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Green),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationDrawerScreens.Home.screen
            ) {
                composable(NavigationDrawerScreens.Home.screen) { HomeScreen() }
                composable(NavigationDrawerScreens.Profile.screen) { ProfileScreen() }
                composable(NavigationDrawerScreens.Settings.screen) { SettingsScreen() }
            }
        }
    }

}