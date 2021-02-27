/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
