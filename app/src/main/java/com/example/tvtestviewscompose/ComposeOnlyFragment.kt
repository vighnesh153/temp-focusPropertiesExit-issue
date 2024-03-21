package com.example.tvtestviewscompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import androidx.tv.material3.darkColorScheme

class ComposeOnlyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeOnlyApp()
            }
        }
    }
}

val commonColumnModifier = Modifier.fillMaxSize()
val commonRowModifier = Modifier.fillMaxWidth()
val commonItemModifier = Modifier
    .width(164.dp)
    .aspectRatio(16f / 9)

val columnPaddingValues = PaddingValues(vertical = 20.dp)
val rowPaddingValues = PaddingValues(horizontal = 20.dp)

val arrangement = Arrangement.spacedBy(20.dp)


@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun ComposeOnlyApp() {
    MaterialTheme(darkColorScheme()) {
        Surface(modifier = Modifier.fillMaxSize(), shape = RectangleShape) {

            TvLazyColumn(
                modifier = commonColumnModifier,
                contentPadding = columnPaddingValues,
                verticalArrangement = arrangement,
            ) {
                items(20) {
                    val focusRequester = remember { FocusRequester() }

                    TvLazyRow(
                        modifier = commonRowModifier.then(Modifier
//                            .focusRequester(focusRequester)
                            .focusRestorer { focusRequester }
                        ),
                        contentPadding = rowPaddingValues,
                        horizontalArrangement = arrangement,
                    ) {
                        items(20) {
                            val itemModifier = if (it == 0) {
                                commonItemModifier
                                    .then(Modifier.focusRequester(focusRequester))
                            } else {
                                commonItemModifier
                            }

                            Surface(
                                onClick = { },
                                modifier = itemModifier,
                                colors = ClickableSurfaceDefaults.colors(
                                    containerColor = Color.DarkGray,
                                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                                ),
                            ) {
                                Text(
                                    text = "$it",
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
