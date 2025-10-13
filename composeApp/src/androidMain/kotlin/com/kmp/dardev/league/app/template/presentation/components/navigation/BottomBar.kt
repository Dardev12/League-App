package com.kmp.dardev.league.app.template.presentation.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.navigation.Screen
import com.kmp.dardev.league.app.template.presentation.common.NavigationIconButton
import com.kmp.dardev.league.app.template.ui.theme.bottomBarBackground

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    userID: MutableState<String>,
    reloadPostFunc: (() -> Unit)? = null,
) {
    Column(
        modifier =
            Modifier
                .padding(
                    bottom = 50.dp,
                    start = 36.dp,
                    end = 36.dp,
                ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(81.dp)
                    .shadow(
                        elevation = 4.dp,
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier =
                    modifier
                        .fillMaxWidth()
                        .height(81.dp)
                        .background(
                            color = MaterialTheme.colorScheme.bottomBarBackground,
                        ).padding(start = 30.dp, top = 15.dp, bottom = 15.dp, end = 30.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                NavigationIconButton(
                    event = { navController.navigate(Screen.HomePage.route) },
                    content = com.kmp.dardev.league.app.template.shared.R.drawable.info,
                    isActive = true,
                )
                Spacer(modifier = Modifier.width(15.dp))
                NavigationIconButton(
                    event = { navController.navigate(Screen.HomePage.route) },
                    content = com.kmp.dardev.league.app.template.shared.R.drawable.info,
                    isActive = false,
                )
                Spacer(modifier = Modifier.width(15.dp))
                NavigationIconButton(
                    event = {
                        navController.navigate(
                            Screen.ProfilPage.passDataForProfil(
                                userId = userID.value,
                            ),
                        )
                    },
                    content =
                        if (isSystemInDarkTheme()) {
                            com.kmp.dardev.league.app.template.shared.R.drawable.usericondark
                        } else {
                            com.kmp.dardev.league.app.template.shared.R.drawable.usericonlight
                        },
                    isActive = false,
                )
            }
        }
    }
}
