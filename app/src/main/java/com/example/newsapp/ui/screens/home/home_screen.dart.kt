package com.example.newsapp.ui.screens.home

import coil.compose.AsyncImage
import coil.request.ImageRequest
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), containerColor = Color(0xFFF3F3F3)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Apply padding values here
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopAppBar(
                colors = topAppBarColors(
                    Color(0xFFF3F3F3)
                ),
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
                        unfocusedBorderColor = Color.Transparent, // Remove border for unfocused state
                        focusedBorderColor = Color.Transparent,   // Remove border for focused state
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
                LazyColumn {
                   item{
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(horizontal = 15.dp, vertical = 10.dp),
                           horizontalArrangement = Arrangement.SpaceBetween
                       ) {
                           Text(
                               text = "For You", style = TextStyle(
                                   fontSize = 25.sp, fontWeight = FontWeight.W500, color = Color(
                                       0xFF4B4B4B
                                   )
                               )
                           )
                           Icon(
                               imageVector = Icons.Default.List,
                               contentDescription = "ist",
                               modifier = Modifier.size(35.dp),
                               tint = Color(
                                   0xFF4B4B4B
                               )
                           )

                       }
                   }
                   items(count = 5){i->
                       Column {
                           NewsCard()
                           Divider()
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun NewsCard() {
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
                        text = "Entertainment",
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
                    text = "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    ),
                    maxLines = 4,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Read More",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue
                    )
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .height(160.dp)
                    .background(color = Color.Blue,)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.pexels.com/photos/19457056/pexels-photo-19457056/free-photo-of-tables-and-chairs-standing-outside-of-a-restaurant.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load")
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


@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    HomeScreen()
}
