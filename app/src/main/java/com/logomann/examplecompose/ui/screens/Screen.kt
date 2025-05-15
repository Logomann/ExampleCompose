package com.logomann.examplecompose.ui.screens

sealed class Screen(val route: String) {
    data object AllContent : Screen(route = "allContent")
    data object FavouriteContent : Screen(route = "favouriteContent")
}