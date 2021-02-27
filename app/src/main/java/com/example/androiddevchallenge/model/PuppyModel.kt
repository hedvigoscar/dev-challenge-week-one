package com.example.androiddevchallenge.model

import android.net.Uri

data class PuppyModel(
    val name: String,
    val imageUrl: Uri,
    val breed: String,
    val description: String,
)