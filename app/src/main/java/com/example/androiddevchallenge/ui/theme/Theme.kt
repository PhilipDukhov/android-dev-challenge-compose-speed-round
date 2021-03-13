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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.general.LocalSysUiController

private val DarkColorPalette = darkColors(
    primary = white,
    secondary = rust300,
    background = gray900,
    surface = white150,
    onPrimary = gray900,
    onSecondary = gray900,
    onBackground = taupe100,
    onSurface = white800,
)

private val LightColorPalette = lightColors(
    primary = gray900,
    secondary = rust600,
    background = taupe100,
    surface = white850,
    onPrimary = white,
    onSecondary = white,
    onBackground = taupe800,
    onSurface = gray800,
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val sysUiController = LocalSysUiController.current
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.background
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Composable
fun TextFieldDefaults.customTextFieldColors(textColor: Color) =
    outlinedTextFieldColors(
        textColor = textColor,
        backgroundColor = MaterialTheme.colors.surface,
        cursorColor = MaterialTheme.colors.onSurface,
        errorCursorColor = MaterialTheme.colors.error,
        focusedBorderColor =
        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.high),
        unfocusedBorderColor =
        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
        errorBorderColor = MaterialTheme.colors.error,
        leadingIconColor =
        MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),
        trailingIconColor =
        MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),
        errorTrailingIconColor = MaterialTheme.colors.error,
        focusedLabelColor =
        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.high),
        unfocusedLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
        errorLabelColor = MaterialTheme.colors.error,
        placeholderColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),
    )
