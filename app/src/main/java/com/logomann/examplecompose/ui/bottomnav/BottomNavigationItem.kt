package com.logomann.examplecompose.ui.bottomnav

import com.logomann.examplecompose.R
import com.logomann.examplecompose.ui.screens.Screen

sealed class BottomNavigationItem(
    val route: String,
    val iconId: Int,
    val titleStringId: Int
) {
    data object AllContent : BottomNavigationItem(
        route = Screen.AllContent.route,
        iconId = R.drawable.icon_home,
        titleStringId = R.string.all_content
    )

    data object FavouriteContent : BottomNavigationItem(
        route = Screen.FavouriteContent.route,
        iconId = R.drawable.icon_favorite,
        titleStringId = R.string.favourite_content
    )
}