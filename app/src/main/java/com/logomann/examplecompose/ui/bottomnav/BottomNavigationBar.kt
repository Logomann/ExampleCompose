package com.logomann.examplecompose.ui.bottomnav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {

    val screens = listOf(BottomNavigationItem.AllContent, BottomNavigationItem.FavouriteContent)

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val context = LocalContext.current
        screens.forEach { screen ->
            val selected = currentRoute == screen.route
            NavigationBarItem(
                label = { Text(text = context.getString(screen.titleStringId)) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconId),
                        contentDescription = null
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}