package com.mechta.smartphonesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mechta.design_system.components.background.AppGradientBackground
import com.mechta.design_system.theme.AppTheme
import com.mechta.smartphonesapp.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppGradientBackground {
                    AppNavHost()
                }
            }
        }
    }
}