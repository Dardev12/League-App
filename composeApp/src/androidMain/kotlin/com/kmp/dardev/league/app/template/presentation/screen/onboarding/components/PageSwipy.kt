package com.kmp.dardev.league.app.template.presentation.screen.onboarding.components

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.presentation.screen.onboarding.common.ButtonNext
import com.kmp.dardev.league.app.template.ui.theme.AppTheme
import com.kmp.dardev.league.app.template.util.AndroidStringResource

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageSwipy(
    onboardClick: () -> Unit,
    context: Context,
) {
    Scaffold {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                // Image
                Image(
                    painterResource(id = com.kmp.dardev.league.app.template.shared.R.drawable.info),
                    modifier = Modifier.width(250.dp).height(315.dp),
                    alignment = Alignment.TopCenter,
                    contentDescription = AndroidStringResource(id = SharedRes.strings.logo_land),
                )
                Spacer(modifier = Modifier.height(25.dp))
                // Titre
                Text(
                    text = AndroidStringResource(id = SharedRes.strings.page_three_title),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                )
                Spacer(modifier = Modifier.height(25.dp))
                // Description
                Text(
                    text = AndroidStringResource(id = SharedRes.strings.page_three_topic),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                )
                Spacer(modifier = Modifier.height(30.dp))
                // Button
                ButtonNext {
                    onboardClick()
                }
                Spacer(modifier = Modifier.height(21.dp))
            }
        }
    }
}

@Preview(locale = "fr")
@Composable
fun PageSwipyPreview() {
    val context = LocalContext.current
    AppTheme {
        PageThreeMap({}, context)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PageSwipyDarkModePreview() {
    val context = LocalContext.current
    AppTheme {
        PageThreeMap({}, context)
    }
}
