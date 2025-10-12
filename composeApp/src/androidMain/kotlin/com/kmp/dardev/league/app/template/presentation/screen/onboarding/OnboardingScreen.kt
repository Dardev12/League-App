package com.kmp.dardev.league.app.template.presentation.screen.onboarding

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.navigation.Screen
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.components.PageFiveCommunity
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.components.PageOneIntroduction
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.components.PageSwipy
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.components.PageThreeMap
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.components.PageTwoUseCase
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun OnboardingScreen(
    navController: NavController,
    context: Context,
    viewModel: OnboardingViewModel = koinViewModel(),
) {
    val currentScreen =
        remember {
            mutableStateOf(1)
        }

    LaunchedEffect(key1 = true) {
        viewModel.analyticsEvent("Start_Process_Onboarding_Page_1")
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        when (currentScreen.value) {
            1 -> {
                PageOneIntroduction(
                    {
                        currentScreen.value = 2
                        viewModel.analyticsEvent("Navigate_To_Onboard_Page_2")
                    },
                    context = context,
                )
            }
            2 -> {
                PageTwoUseCase(
                    {
                        currentScreen.value = 3
                        viewModel.analyticsEvent("Navigate_To_Onboard_Page_3")
                    },
                    context = context,
                )
            }
            3 -> {
                PageSwipy(
                    {
                        currentScreen.value = 4
                        viewModel.analyticsEvent("Navigate_To_Onboard_Page_4")
                    },
                    context = context,
                )
            }
            4 -> {
                PageThreeMap(
                    {
                        currentScreen.value = 5
                        viewModel.analyticsEvent("Navigate_To_Onboard_Page_5")
                    },
                    context = context,
                )
            }
            5 -> {
                PageFiveCommunity(
                    {
                        viewModel.onBoardingNavigationValidate()
                        navController.navigate(Screen.MenuAuthPage.route)
                        viewModel.analyticsEvent("Completed_the_Onboarding_Process")
                    },
                    context = context,
                )
            }
        }
    }
}
