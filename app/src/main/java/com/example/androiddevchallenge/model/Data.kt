package com.example.androiddevchallenge.model

import android.net.Uri

val puppies = listOf(
    PuppyModel(
        "Bella",
        Uri.parse("file:///android_asset/bella.webp"),
        "Golden Retriever",
        "A beautiful puppy looking for a happy home!"
    ),
    PuppyModel(
        "Luna",
        Uri.parse("file:///android_asset/luna.webp"),
        "Beaglier",
        "A beautiful puppy looking for a happy home!"
    ),
    PuppyModel(
        "Charlie",
        Uri.parse("file:///android_asset/charlie.webp"),
        "Chihuahua/Alaskan Malamute",
        "A beautiful puppy looking for a happy home!"
    ),
    PuppyModel(
        "Lucy",
        Uri.parse("file:///android_asset/lucy.webp"),
        "Australian Terrier",
        "A beautiful puppy looking for a happy home!"
    ),
    PuppyModel(
        "Cooper",
        Uri.parse("file:///android_asset/cooper.webp"),
        "Australian Shepherd",
        "A beautiful puppy looking for a happy home!"
    ),
    PuppyModel(
        "Max",
        Uri.parse("file:///android_asset/max.webp"),
        "Cavalier King Charles Spaniel",
        "A beautiful puppy looking for a happy home!"
    ),
)
