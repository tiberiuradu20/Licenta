package com.example.licenta.responsive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun AppUtils(
    appDimens:Dimens,
    content:@Composable ()->Unit
){
    val appDimens = remember{
        appDimens
    }
    CompositionLocalProvider(LocalAppDimens provides appDimens) {
        content()
    }

}
val LocalAppDimens= compositionLocalOf {///vom folosi composition local
    CompactDimens
}