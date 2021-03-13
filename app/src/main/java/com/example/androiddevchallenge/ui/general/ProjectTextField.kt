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
package com.example.androiddevchallenge.ui.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.customTextFieldColors

@Composable
fun ProjectTextField(
    placeholder: String,
    textColor: Color,
    leadingIcon: Int? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    validator: (String, FocusState) -> Boolean = { _, _ -> true },
    modifier: Modifier,
) {
    var textState by remember { mutableStateOf("") }
    var focusState by remember { mutableStateOf(FocusState.Inactive) }
    Box(
        modifier = modifier
            .height(56.dp)
    ) {
        TextField(
            value = textState,
            onValueChange = {
                textState = it
            },
            shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
            singleLine = true,
            label = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.body1
                )
            },
            isError = !validator(textState, focusState),
            visualTransformation = visualTransformation,
            leadingIcon = leadingIcon?.let {
                {
                    Image(
                        painterResource(it),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(textColor)
                    )
                }
            },
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.customTextFieldColors(textColor),
            modifier = Modifier
                .onFocusChanged {
                    focusState = it
                }
                .fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .align(Alignment.BottomCenter)
        )
    }
}
