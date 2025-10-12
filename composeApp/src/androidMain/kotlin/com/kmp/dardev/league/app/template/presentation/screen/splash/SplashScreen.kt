package com.kmp.dardev.league.app.template.presentation.screen.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = koinViewModel(),
) {
    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec =
                tween(
                    durationMillis = 1000,
                    delayMillis = 200,
                ),
        )
        navController.popBackStack()
        if (viewModel.verifyTokenConnexionExist()) {
            if (viewModel.verifyOnBoardingIsCheck()) {
                navController.navigate(Screen.HomePage.route)
            } else {
                navController.navigate(Screen.OnboardingPage.route)
            }
        } else {
            if (viewModel.verifyOnBoardingIsCheck()) {
                navController.navigate(Screen.MenuAuthPage.route)
            } else {
                navController.navigate(Screen.OnboardingPage.route)
            }
        }
    }

    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {
    Box(
        modifier =
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.rotate(degrees = degrees),
            painter = painterResource(id = R.drawable.land_logo_degrade_symbole),
            contentDescription = "Logo",
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(degrees = 0f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash(degrees = 0f)
}
