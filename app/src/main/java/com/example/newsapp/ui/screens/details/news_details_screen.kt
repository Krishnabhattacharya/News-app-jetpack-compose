package com.example.newsapp.ui.screens.details

import android.annotation.SuppressLint
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.newsapp.ui.screens.home.HomeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsDetailsScreen() {
    Scaffold(
        containerColor = Color.LightGray
    ) {
        LazyColumn {
            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(color = Color.LightGray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Transparent)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.size(42.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.size(42.dp)

                            )
                        }
                    }
                    Image(
                        painter = rememberAsyncImagePainter(model = "https://images.unsplash.com/photo-1719937206498-b31844530a96?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwxfHx8ZW58MHx8fHx8"),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(y = (-50).dp)
                            .height(80.dp)
                            .width(80.dp)
                            .background(
                                color = Color.Blue,
                                shape = RoundedCornerShape(50.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.height(20.dp))

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
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Robot Attraction in Seoul for Increase Tourist",
                            color = Color.Black,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist v Robot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase Tourist Robot Attraction in Seoul for Increase TouristRobot Attraction in Seoul for Increase Tourist",
                            color = Color.Black,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif

                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    NewsDetailsScreen()
}