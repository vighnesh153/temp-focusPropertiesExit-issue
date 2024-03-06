package com.example.tvtestviewscompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.nativeKeyCode
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun App() {
    val hasFocus = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {}, modifier = constructFocusLoggingModifier("Button 1")) {
                +"Button 1"
            }
            Button(onClick = {}, modifier = constructFocusLoggingModifier("Button 2")) {
                +"Button 2"
            }
        }
    }
}

const val TAG = "Pikachu"

@OptIn(ExperimentalComposeUiApi::class)
fun constructFocusLoggingModifier(text: String): Modifier {
    return Modifier
        .focusProperties {
            enter = {
                Log.d(TAG, "$text: Entering focus, direction=${it}")
                FocusRequester.Default
            }
            exit = {
                Log.d(TAG, "$text: Exiting focus, direction=${it}")
                FocusRequester.Default
            }
        }
        .focusGroup()
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
operator fun String.unaryPlus() {
    Text(text = this)
}
