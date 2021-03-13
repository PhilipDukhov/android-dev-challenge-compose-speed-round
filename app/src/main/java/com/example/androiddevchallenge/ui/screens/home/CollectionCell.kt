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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CollectionCell(
    item: Item,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .size(width = 192.dp, height = 56.dp)
            .clip(MaterialTheme.shapes.small)
            .clipToBounds()
            .background(MaterialTheme.colors.surface)
    ) {
        Image(
            painterResource(item.image),
            contentScale = ContentScale.FillBounds,
            contentDescription = item.name,
            modifier = Modifier
                .size(56.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            item.name,
            style = MaterialTheme.typography.h3,
            color = Color.Black.copy(alpha = 0.8f),
            maxLines = 2,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
        )
    }
}
