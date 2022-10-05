package com.example.randomuserapp.presentation.users.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.randomuserapp.data.remote.dto.Picture
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun LoadImage(
    imageModel: Picture,
    modifier: Modifier = Modifier
) {
    GlideImage(
        imageModel = imageModel,
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LoadImagePreview() {
    LoadImage(
        imageModel = Picture(
            "https://randomuser.me/api/portraits/men/78.jpg",
            "https://randomuser.me/api/portraits/men/78.jpg",
            "https://randomuser.me/api/portraits/men/78.jpg"
        )
    )
}
