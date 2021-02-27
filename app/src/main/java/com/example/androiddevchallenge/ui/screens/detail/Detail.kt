package com.example.androiddevchallenge.ui.screens.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.model.puppies
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@OptIn(ExperimentalAnimationApi::class, ExperimentalTime::class)
@Composable
fun Detail(model: PuppyModel) {
    val coroutineScope = rememberCoroutineScope()
    val (snackbarVisible, setSnackbarVisible) = rememberSaveable { mutableStateOf(false) }
    if (snackbarVisible) {
        coroutineScope.launch {
            delay(5.seconds)
            setSnackbarVisible(false)
        }
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .requiredHeightIn(min = 225.dp)
                .fillMaxWidth()
        ) {
            CoilImage(
                data = model.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                fadeIn = true,
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text("Breed", style = MaterialTheme.typography.h6)
            Text(model.breed, style = MaterialTheme.typography.body1)
        }
        Text(
            model.description,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        ExtendedFloatingActionButton(
            text = { Text("Adopt this puppy") },
            onClick = { setSnackbarVisible(true) },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        AnimatedVisibility(visible = snackbarVisible, enter = fadeIn(), exit = fadeOut()) {
            Snackbar(modifier = Modifier.padding(bottom = 72.dp)) {
                Text("Sorry, I'm not really adoptable :(")
            }
        }
    }
}

@Preview
@Composable
fun DetailPreview() {
    Surface(color = MaterialTheme.colors.background) {
        Detail(puppies[0])
    }
}