package com.example.basicui2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomePage) {
        composable(Routes.HomePage) {
            HomePageScreen(navController)
        }
        composable(Routes.Scaffold) {
            ScaffoldScreen(navController)
        }
        composable(Routes.BottomSheet) {
            BottomSheetScreen()
        }
        composable(Routes.CustomUi) {
            CustomUiScreen()
        }
        composable(Routes.DialogBox) {
            DialogBoxScreen()
        }
        composable(Routes.LazyColumnList) {
            LazyColumnListScreen()
        }
        composable(Routes.LazyVerticalGrid) {
            LazyVerticalGridScreen()
        }
        composable(Routes.TextField) {
            TextFieldScreen()
        }
        composable(Routes.Card) {
            CardScreen()
        }
        composable(Routes.Chip) {
            ChipScreen()
        }
        composable(Routes.Buttons) {
            ButtonScreen()
        }
        composable(Routes.Divider) {
            DividerScreen()
        }
        composable(Routes.ProgressIndicator) {
            ProgressIndicatorScreen()
        }
        composable(Routes.Slider) {
            SliderScreen()
        }
        composable(Routes.Switch) {
            SwitchScreen()
        }
    }
}