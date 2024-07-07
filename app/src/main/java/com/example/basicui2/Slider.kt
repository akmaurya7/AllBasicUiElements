package com.example.basicui2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "Slider Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
            )
        }
    )
    { innerPadding ->
        var sliderPosition by remember { mutableFloatStateOf(1f) }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Slide to change the opacity of the image")
            Image(
                painter = painterResource(id = R.drawable.dogimage),
                contentDescription ="",
                modifier = Modifier.alpha(sliderPosition))
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it }
            )
            Text(text = sliderPosition.toString())
        }
    }
}