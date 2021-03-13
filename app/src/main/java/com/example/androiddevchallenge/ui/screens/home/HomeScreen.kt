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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.general.ProjectTextField
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun HomeScreen(
    modifier: Modifier,
) {
    val contentPadding = PaddingValues(
        start = 16.dp,
    )
    LazyColumn(
        contentPadding = PaddingValues(
            top = LocalWindowInsets.current.statusBars.toPaddingValues().calculateTopPadding() + 32.dp,
            bottom = playSize / 2 + 8.dp,
        ),
        modifier = modifier
    ) {
        item {
            ProjectTextField(
                placeholder = "Search",
                textColor = Color.Black.copy(alpha = 0.8f),
                leadingIcon = R.drawable.ic_baseline_search_24,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        item {
            Text(
                "FAVORITE COLLECTIONS",
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp)
                    .padding(horizontal = 16.dp)
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item {
            LazyRow(contentPadding = contentPadding) {
                items(collections.count() / 2) {
                    Column(
                        modifier = Modifier
                            .padding(end = 8.dp)
                    ) {
                        CollectionCell(
                            collections[it * 2],
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                        val bottomIndex = it * 2 + 1
                        if (collections.indices.contains(bottomIndex)) {
                            CollectionCell(
                                collections[bottomIndex],
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }
        }
        item {
            Text(
                "ALIGN YOUR BODY",
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp)
                    .padding(horizontal = 16.dp)
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item {
            LazyRow(contentPadding = contentPadding) {
                items(body) {
                    ActivityCell(
                        it, modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
        item {
            Text(
                "ALIGN YOUR MIND",
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp)
                    .padding(horizontal = 16.dp)
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item {
            LazyRow(contentPadding = contentPadding) {
                items(mind) {
                    ActivityCell(
                        it, modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
    }
}

val images = listOf(
    R.drawable.ic_1,
    R.drawable.ic_2,
    R.drawable.ic_3,
    R.drawable.ic_4,
    R.drawable.ic_5,
)
val names = listOf(
    "Monstera",
    "Aglaonema",
    "Peace lily",
    "Fidle leaf tree",
    "Snake plant",
    "Pothos",
)

fun generateItems() = List(10) {
    Item(
        image = images.random(),
        name = names.random(),
    )
}

private val collections = generateItems()

private val body = generateItems()

private val mind = generateItems()
