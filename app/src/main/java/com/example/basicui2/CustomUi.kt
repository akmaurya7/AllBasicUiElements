package com.example.basicui2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomUiScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Jetpack Compose",
                        fontSize = 28.sp,
                        color = colorResource(id =R.color.purple_700),
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.jetpack),
                        contentDescription = "Jetpack Logo",
                        modifier = Modifier
                            .padding(16.dp)
                            .height(120.dp)
                            .width(120.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Login",
                        fontSize = 28.sp,
                        modifier = Modifier
                            .padding(24.dp, 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )

                    var email by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = email ,
                        label = {Text(text = "Email ID or Mobile Number")},
                        onValueChange = { email = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp, 16.dp)
                    )
                    var pass by remember { mutableStateOf("") }
                    var showPass by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = pass,
                        label = { Text(text = "Password")},
                        onValueChange = {pass = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp, 16.dp,24.dp,8.dp),

                        visualTransformation = if(showPass){
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                        trailingIcon = {
                            if(showPass){
                                IconButton(onClick = {showPass = false}) {
                                    Icon(
                                        imageVector = Icons.Filled.Visibility,
                                        contentDescription = "hide_pass"
                                    )
                                }
                            } else {
                                IconButton(onClick = { showPass = true}) {
                                    Icon (
                                        imageVector = Icons.Filled.VisibilityOff,
                                        contentDescription = "hide_pass"
                                    )
                                }
                            }
                        }
                    )

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Forget Password",
                            modifier = Modifier
                                .padding(0.dp,0.dp,24.dp,0.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(16.dp,0.dp,0.dp,16.dp)
                        ) {
                            Text(text = "Login", modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account?")
                TextButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Register", textAlign = TextAlign.Start)
                }
            }
        }
    }
}
