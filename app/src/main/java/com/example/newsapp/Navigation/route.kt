package com.example.newsapp.Navigation
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.ui.screens.details.NewsDetailsScreen
import com.example.newsapp.ui.screens.home.HomeScreen
import com.example.newsapp.viewmodel.newsviewmodel

class AppRoute {

    @Composable
    fun RouteController() {
        val sharedViewModel: newsviewmodel = viewModel()
        val navController = rememberNavController()
        NavHost(navController, startDestination = "Home") {
            composable("Home") { HomeScreen(navController,sharedViewModel) }
            composable(
                "DetailsNewsScreen/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                if (id != null) {
                    NewsDetailsScreen(navController = navController, sharedViewModel,id = id,)
                }
            }
        }
    }
}