package com.example.androiddevchallenge.ui.screens.puppies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Puppies(showDetail: (name: String) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            items(items = puppies, key = { it.name }) {
                Puppy(it, showDetail)
            }
        }
    }
}

@Composable
fun Puppy(model: PuppyModel, onClick: (name: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick(model.name) }
    ) {
        Column {
            CoilImage(
                data = model.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                fadeIn = true,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Text(
                model.name,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
            )
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Puppies {}
    }
}
