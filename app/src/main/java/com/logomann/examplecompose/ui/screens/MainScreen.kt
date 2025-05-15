package com.logomann.examplecompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.logomann.examplecompose.ui.bottomnav.BottomNavigationBar

@Composable
fun MainScreen(
    //  viewModel: MainViewModel = getViewModel()
) {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { _ ->
        NavHost(navController, startDestination = Screen.AllContent.route) {
            composable(Screen.AllContent.route) {
                AllContentScreen()
            }
            composable(Screen.FavouriteContent.route) {
                FavouriteContentScreen()
            }
        }


    }
}