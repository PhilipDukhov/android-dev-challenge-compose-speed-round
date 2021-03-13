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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.general.LocalSysUiController
import com.example.androiddevchallenge.ui.general.SystemUiController
import com.example.androiddevchallenge.ui.screens.home.TabScreen
import com.example.androiddevchallenge.ui.screens.login.LoginScreen
import com.example.androiddevchallenge.ui.screens.welcome.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = remember { SystemUiController(window) }
            ProvideWindowInsets {
                CompositionLocalProvider(
                    LocalContentColor provides MaterialTheme.colors.onBackground,
                    LocalSysUiController provides systemUiController,
                ) {
                    MyTheme {
                        MyApp(systemUiController)
                    }
                }
            }
        }
    }
}

object MainDestinations {
    const val Welcome = "welcome"
    const val Login = "login"
    const val Home = "home"
}

// Start building your app here!
@Composable
fun MyApp(systemUiController: SystemUiController) {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = MainDestinations.Welcome) {
            composable(MainDestinations.Welcome) {
                WelcomeScreen {
                    navController.navigate(MainDestinations.Login)
                }
            }
            composable(MainDestinations.Login) {
                LoginScreen {
                    navController.navigate(MainDestinations.Home)
                }
            }
            composable(MainDestinations.Home) {
                TabScreen()
            }
        }
    }
}
