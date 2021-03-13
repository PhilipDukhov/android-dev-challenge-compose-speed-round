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
package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

object Screens {
    const val Home = "HOME"
    const val Profile = "PROFILE"
}

@Composable
fun TabScreen() {
    Column(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        var selectedScreen by remember { mutableStateOf(Screens.Home) }
        if (selectedScreen == Screens.Home) {
            HomeScreen(Modifier.weight(1f))
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }
        Box {
            Surface(
                elevation = 8.dp,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .navigationBarsPadding()
                            .height(64.dp)
                            .fillMaxWidth()
                    ) {
                        Spacer(Modifier.weight(1f))
                        listOf(
                            Screens.Home to R.drawable.ic_baseline_spa_24,
                            Screens.Profile to R.drawable.ic_baseline_account_circle_24,
                        ).forEach {
                            val (screen, image) = it
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .alpha(if (screen == selectedScreen) 1f else 0.5f)
                                    .selectable(screen == selectedScreen) {
                                        selectedScreen = screen
                                    }
                            ) {
                                Image(
                                    painterResource(image),
                                    contentDescription = it.first,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                                )
                                Text(
                                    screen,
                                    style = MaterialTheme.typography.caption
                                )
                            }
                            Spacer(Modifier.weight(if (screen == Screens.Home) 2f else 1f))
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .offset(y = -playSize / 2)
                    .align(Alignment.TopCenter)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.onBackground)
                        .size(playSize)
                ) {
                    Image(
                        painterResource(R.drawable.ic_baseline_play_arrow_24),
                        contentDescription = "play",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.background),
                    )
                }
            }
        }
    }
}

val playSize = 48.dp
