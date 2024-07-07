package com.example.basicui2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen(navController: NavController) {
    val btnCardList = listOf(
        ComposableCardData(
            Desc = stringResource(id = R.string.ButtonDescription),
            ButName = stringResource(id = R.string.Buttons),
            route = Routes.Buttons
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.BottomSheetDescription),
            ButName = stringResource(id = R.string.BottomSheet),
            route = Routes.BottomSheet
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.CardDescription),
            ButName = stringResource(id = R.string.Card),
            route = Routes.Card
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.ChipDescription),
            ButName = stringResource(id = R.string.Chip),
            route = Routes.Chip
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.DialogBoxDescription),
            ButName = stringResource(id = R.string.DialogBox),
            route = Routes.DialogBox
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.DividerDescription),
            ButName = stringResource(id = R.string.Divider),
            route = Routes.Divider
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.LazyColumnListDescription),
            ButName = stringResource(id = R.string.LazyColumnList),
            route = Routes.LazyColumnList
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.LazyVerticalGridDescription),
            ButName = stringResource(id = R.string.LazyVerticalGrid),
            route = Routes.LazyVerticalGrid
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.ProgressIndicatorDescription),
            ButName = stringResource(id = R.string.ProgressIndicator),
            route = Routes.ProgressIndicator
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.ScaffoldDescription),
            ButName = stringResource(id = R.string.Scaffold),
            route = Routes.Scaffold
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.SliderDescription),
            ButName = stringResource(id = R.string.Slider),
            route = Routes.Slider
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.TextFieldDescription),
            ButName = stringResource(id = R.string.TextField),
            route = Routes.TextField
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.SwitchDescription),
            ButName = stringResource(id = R.string.Switch),
            route = Routes.Switch
        ),
        ComposableCardData(
            Desc = stringResource(id = R.string.CustomUiDescription),
            ButName = stringResource(id = R.string.CustomUi),
            route = Routes.CustomUi
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "Home Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            //verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(btnCardList) { cardItem ->
                ComposableCard(Desc = cardItem.Desc, ButName = cardItem.ButName, route = cardItem.route, navController)
            }
        }
    }
}

@Composable
fun ComposableCard(Desc: String, ButName: String, route: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$ButName ",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = Desc,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = { navController.navigate(route) },
                shape = RoundedCornerShape(8.dp))
            {
                Text(text = "Click To Preview $ButName page")
            }
        }
    }
}

data class ComposableCardData(val Desc: String, val ButName: String, val route: String)
