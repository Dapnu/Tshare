package com.DRIF.tshare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.DRIF.tshare.ui.theme.TshareTheme
import NavigationGraph
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import com.DRIF.tshare.presentation.login_screen.OneTapSignInViewModel
import com.DRIF.tshare.ui.theme.TshareTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val oneTapSignInViewModel = viewModels<OneTapSignInViewModel>()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TshareTheme {
                val navController = rememberAnimatedNavController()

                NavigationGraph(
                    navController = navController,
                    oneTapSignInViewModel = oneTapSignInViewModel.value
                )
            }
        }
    }
}