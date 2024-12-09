package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.Navigation.AppRoute
import com.example.newsapp.ui.screens.details.NewsDetailsScreen
import com.example.newsapp.ui.screens.home.HomeScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppRoute().RouteController()
    }
}

}
//@Composable
//fun Loading() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize(), // Ensures it takes up the full available space
//        contentAlignment = Alignment.Center // Centers the indicator in the container
//    ) {
//        CircularProgressIndicator(
//            strokeWidth = 8.dp,
//            color = Color.Yellow,
//            trackColor = Color.LightGray,
//strokeCap = StrokeCap.Round,
//            modifier = Modifier
//                .size(100.dp)
//                .padding(16.dp) // Sets a visible size for the indicator
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun LoadingPreview() {
//    Loading()
//}
