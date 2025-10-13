package com.kmp.dardev.league.app.template.presentation.screen.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.navigation.Screen
import com.kmp.dardev.league.app.template.presentation.common.IconButton
import com.kmp.dardev.league.app.template.ui.theme.topBarBackground

@Composable
fun ProfilTopBar(navController: NavController) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.topBarBackground,
                ).padding(top = 35.dp, start = 35.dp, end = 35.dp),
    ) {
        IconButton(
            event = { navController.navigate(Screen.HomePage.route) },
            content =
                if (isSystemInDarkTheme()) {
                    com.kmp.dardev.league.app.template.shared.R.drawable.backicondark
                } else {
                    com.kmp.dardev.league.app.template.shared.R.drawable.backiconlight
                },
        )
        Spacer(modifier = Modifier.width(198.dp))
        IconButton(
            event = { navController.navigate(Screen.ParameterPage.route) },
            content =
                if (isSystemInDarkTheme()) {
                    com.kmp.dardev.league.app.template.shared.R.drawable.gearicondark
                } else {
                    com.kmp.dardev.league.app.template.shared.R.drawable.geariconlight
                },
        )
        Spacer(modifier = Modifier.width(13.dp))
        IconButton(
            event = {
                navController.navigate(Screen.MenuAuthPage.route)
            },
            content =
                if (isSystemInDarkTheme()) {
                    com.kmp.dardev.league.app.template.shared.R.drawable.logoutdark
                } else {
                    com.kmp.dardev.league.app.template.shared.R.drawable.logoutlight
                },
        )
    }
}
