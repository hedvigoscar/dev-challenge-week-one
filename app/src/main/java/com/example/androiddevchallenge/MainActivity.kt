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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.screens.detail.Detail
import com.example.androiddevchallenge.ui.screens.puppies.Puppies
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row { Text("Adopt a puppy") } })
        },
    ) {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "puppies") {
                composable("puppies") {
                    Puppies { name ->
                        navController.navigate("detail/${name}")
                    }
                }
                composable(
                    "detail/{name}", arguments = listOf(
                        navArgument("name") {
                            type =
                                NavType.StringType
                        }
                    )
                ) {
                    it.arguments?.getString("name")
                        ?.let { name -> puppies.first { p -> p.name == name } }
                        ?.let { puppy -> Detail(puppy) }
                }
            }
        }
    }
}
