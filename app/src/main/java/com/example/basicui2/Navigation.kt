package com.example.basicui2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                title = {
                    Text(
                        text = "Navigation Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )

                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(onClick = { navController.navigate(Routes.ScreenA) }) {
                Text(text = "Go to Screen A")
            }
        }
    }
}

@Composable
fun ScreenA_WithoutData(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "This is Screen A ",
            modifier = Modifier
                .padding(24.dp)
        )
        var data by remember { mutableStateOf("") }
        OutlinedTextField(value = data , onValueChange ={data = it} )
        Button(
            onClick = {
                val navigationData = if (data.isBlank()) "No data" else data
                navController.navigate(Routes.ScreenB + "/$navigationData")
                      },
            ) {
            Text(text = "Go to screen B")
        }
    }
}

@Composable
fun ScreenB_WithData(data: String? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This is Screen B and data is ${data ?: "not provided"}",
            modifier = Modifier
                .padding(24.dp)
        )
    }
}
