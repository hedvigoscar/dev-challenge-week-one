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
package com.example.androiddevchallenge.ui

import android.os.Parcelable
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.screens.detail.Detail
import com.example.androiddevchallenge.ui.screens.puppies.Puppies
import kotlinx.parcelize.Parcelize

sealed class Screen {
    @Parcelize
    object List : Screen(), Parcelable

    @Parcelize
    data class Detail(val name: String) : Screen(), Parcelable
}

@Composable
fun Navigator(screen: Screen, goTo: (Screen) -> Unit) {
    Crossfade(targetState = screen) {
        when (screen) {
            Screen.List -> Puppies(showDetail = { name -> goTo(Screen.Detail(name)) })
            is Screen.Detail -> Detail(model = puppies.first { p -> p.name == screen.name })
        }
    }
}

@Composable
fun BackButton(enable: Boolean = true, onClick: () -> Unit) {
    val current = rememberUpdatedState(onClick)
    val callback = remember {
        object : OnBackPressedCallback(enable) {
            override fun handleOnBackPressed() {
                current.value()
            }
        }
    }
    SideEffect { callback.isEnabled = enable }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current
    DisposableEffect(dispatcher) {
        dispatcher.onBackPressedDispatcher.addCallback(callback)
        onDispose { callback.remove() }
    }
}
