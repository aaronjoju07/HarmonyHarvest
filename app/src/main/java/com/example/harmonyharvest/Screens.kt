package com.example.harmonyharvest

sealed class Screens (val screen : String) {
data object Home : Screens("home")
    data object Profile : Screens("profile")
    data object Notification : Screens("notification")
    data object Search : Screens("search")
}