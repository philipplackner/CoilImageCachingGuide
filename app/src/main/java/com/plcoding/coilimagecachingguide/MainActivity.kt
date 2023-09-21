package com.plcoding.coilimagecachingguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import coil.memory.MemoryCache
import com.plcoding.coilimagecachingguide.ui.theme.CoilImageCachingGuideTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = "https://cdn.pixabay.com/photo/2016/09/07/10/37/kermit-1651325_1280.jpg"
        val imageUrl2 = "https://cdn.pixabay.com/photo/2017/01/29/14/19/kermit-2018085_1280.jpg"
        setContent {
            CoilImageCachingGuideTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    SubcomposeAsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1280f/847f)
                    )
                    AsyncImage(
                        model = imageUrl2,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1280f/692f)
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = {
                            imageLoader.diskCache?.remove(imageUrl)
                            imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))
                        }
                    ) {
                        Text("Clear cache")
                    }
                }
            }
        }
    }
}