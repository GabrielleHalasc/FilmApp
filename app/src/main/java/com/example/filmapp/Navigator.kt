package com.example.filmapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.FilmPopularViewModel
import presentation.HomeScreen

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")
}
@Composable
fun Navigator(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(Screen.HomeScreen.route){
            val viewmodel: FilmPopularViewModel
            HomeScreen(viewmodel)
        }
    }
}