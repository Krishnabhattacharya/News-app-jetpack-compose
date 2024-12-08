package com.example.newsapp.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Test(){
    Scaffold {  }
}



@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    Test()
}