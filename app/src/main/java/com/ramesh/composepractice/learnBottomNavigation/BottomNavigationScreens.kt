package com.ramesh.composepractice.learnBottomNavigation

sealed class BottomNavigationScreens(val scree:String) {
    data object Home:BottomNavigationScreens("Home")
    data object Search:BottomNavigationScreens("Search")
    data object Notification:BottomNavigationScreens("Notification")
    data object Profile:BottomNavigationScreens("Profile")
}