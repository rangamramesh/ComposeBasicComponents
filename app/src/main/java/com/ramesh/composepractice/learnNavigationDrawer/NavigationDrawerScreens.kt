package com.ramesh.composepractice.learnNavigationDrawer

sealed class NavigationDrawerScreens(val screen:String) {
    data object Home:NavigationDrawerScreens("Home")
    data object Profile:NavigationDrawerScreens("Profile")
    data object Settings:NavigationDrawerScreens("Settings")
}