package com.example.basicui2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "Button Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                androidx.compose.material3.Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Normal Button")
                }

                Spacer(modifier = Modifier.padding(8.dp))

                FilledTonalButton(onClick = { /*TODO*/ }) {
                    Text(text = "Filled Tonal Button")

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Outlined Button")

                }

                Spacer(modifier = Modifier.padding(8.dp))

                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Elevated Button")

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Text(text = "FAB Button")
                }

                Spacer(modifier = Modifier.padding(8.dp))

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "TextField Button")
                }
            }
        }
    }
}