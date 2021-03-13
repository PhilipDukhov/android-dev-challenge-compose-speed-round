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
package com.example.androiddevchallenge.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.general.ProjectButton

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
) {
    Box(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Image(
            painterResource(
                if (isSystemInDarkTheme())
                    R.drawable.ic_dark_welcome
                else
                    R.drawable.ic_light_welcome
            ),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painterResource(
                    if (isSystemInDarkTheme())
                        R.drawable.ic_dark_logo
                    else
                        R.drawable.ic_light_logo
                ),
                contentDescription = "",
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Spacer(Modifier.height(32.dp))
            ProjectButton(
                text = "SIGN UP",
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            ProjectButton(
                text = "LOG IN",
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = onLogin,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
