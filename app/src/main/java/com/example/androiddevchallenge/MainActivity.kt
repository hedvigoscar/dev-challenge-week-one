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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.ui.BackButton
import com.example.androiddevchallenge.ui.Navigator
import com.example.androiddevchallenge.ui.Screen
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Stack

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
    val backstack = rememberSaveable { Stack<Screen>() }
    val (screen, setScreen) = rememberSaveable { mutableStateOf<Screen>(Screen.List) }

    fun goBack() {
        if (backstack.isNotEmpty()) {
            setScreen(backstack.pop())
        }
    }

    BackButton(backstack.isNotEmpty()) {
        goBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            when (screen) {
                                is Screen.Detail -> screen.name
                                Screen.List -> "Adopt a puppy"
                            }
                        )
                    }
                },
                navigationIcon = if (screen is Screen.Detail) {
                    {
                        IconButton(onClick = { goBack() }) {
                            Image(
                                painterResource(R.drawable.ic_back),
                                contentDescription = "Go back"
                            )
                        }
                    }
                } else null
            )
        },
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Navigator(screen) { newScreen ->
                backstack.push(screen)
                setScreen(newScreen)
            }
        }
    }
}
