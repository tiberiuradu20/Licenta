package com.example.licenta

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ResponsiveImage() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val imageWidth = when {
        screenWidth < 360.dp -> screenWidth * 0.8f // 80% din lățimea ecranului pentru ecrane mici
        screenWidth < 480.dp -> screenWidth * 0.6f // 60% pentru ecrane medii
        else -> screenWidth * 0.5f // 50% pentru ecrane mari
    }

    Image(
        painter = painterResource(id = R.drawable.imagine1),
        contentDescription = "Imagine adaptabilă",
        modifier = Modifier.width(imageWidth).wrapContentHeight()
    )
}