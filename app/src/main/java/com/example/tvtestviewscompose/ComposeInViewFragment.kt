package com.example.tvtestviewscompose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.tvtestviewscompose.databinding.ComposeInViewFragmentBinding

class ComposeInViewFragment : Fragment() {
    private lateinit var binding: ComposeInViewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ComposeInViewFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}

class ComposeInflationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeInViewApp()
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun ComposeInViewApp() {
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
                +"Button 0"
            }
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
private fun constructFocusLoggingModifier(text: String): Modifier {
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
private operator fun String.unaryPlus() {
    Text(text = this)
}
