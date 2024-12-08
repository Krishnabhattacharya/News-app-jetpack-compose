package com.example.newsapp.ui.screens.home

import coil.compose.AsyncImage
import coil.request.ImageRequest
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.model.NewsModel
import com.example.newsapp.viewmodel.newsviewmodel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: newsviewmodel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchData("pub_61089a3f8256a3bec3ede7199e464f0aa4bbd", "all")
    }
    val newsRes by viewModel.newsList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF3F3F3)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopAppBar(
                colors = topAppBarColors(Color(0xFFF3F3F3)),
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Articles",
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFD8D8D8), shape = CircleShape),
                    shape = CircleShape,
                    value = "",
                    onValueChange = {},
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color(0xFF333333)
                            )
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Search Here..",
                            style = TextStyle(color = Color(0xFF333333))
                        )
                    },
                    colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
            ) {
                when {
                    isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
//                            CircularProgressIndicator(
//                                strokeWidth = 4.dp,
//                                color = Color.Yellow,
//                                trackColor = Color.LightGray
//                            )
                            Text(text = "Fetching")
                        }
                    }
                    newsRes?.results.isNullOrEmpty() -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No news available.",
                                style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                            )
                        }
                    }
                    else -> {
                        // Display the list of news articles
                        LazyColumn {
                            items(newsRes?.results?.size ?: 0) { i ->
                                val news = newsRes?.results?.get(i)

                                Column(modifier = Modifier.clickable {
                                    navController.navigate("DetailsNewsScreen/$i")
                                }) {
                                    NewsCard(news = news)
                                    Divider()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NewsCard(news:NewsModel.NewsResult?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(horizontal = 16.dp) // Inner padding for content
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(modifier = Modifier.background(color = Color(0xFFFF8655))) {
                    Text(
                        text = news?.category?.first()?:"Category",
                        modifier = Modifier.padding(5.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = news?.title?:"No data",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    ),
                    maxLines = 4,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "Read More",
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.SemiBold,
//                        color = Color.Blue
//                    )
                //)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .height(140.dp)
                    .background(color = Color.White)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(news?.image_url?:"https://images.pexels.com/photos/29592694/pexels-photo-29592694/free-photo-of-festive-wreaths-on-classic-white-doors.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load")
                        .crossfade(true)
                        //.transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "Network Image",
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LoadingPreview() {
//    HomeScreen()
//}
