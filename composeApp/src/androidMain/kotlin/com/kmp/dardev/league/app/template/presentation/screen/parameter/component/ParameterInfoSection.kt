package com.kmp.dardev.league.app.template.presentation.screen.parameter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParameterInfoSection(uriHandler: UriHandler) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier =
                Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFF9C4)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Logo App",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Version 0.0.1",
            fontSize = 16.sp,
        )

        Text(
            text = "Sortie le 2 février 2025",
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "About us",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Lorem ipsum lorem ipsum lorem ipsum",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Contact -> ")
            Text(
                text = "contact@email.com",
                color = MaterialTheme.colorScheme.primary,
                modifier =
                    Modifier.clickable {
                        uriHandler.openUri("mailto:contact@email.com")
                    },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Feedback -> ")
            Text(
                text = "google forms",
                color = MaterialTheme.colorScheme.primary,
                modifier =
                    Modifier.clickable {
                        uriHandler.openUri("https://forms.google.com")
                    },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Privacy -> ")
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "https://my-site.com",
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline,
                    modifier =
                        Modifier.clickable {
                            uriHandler.openUri("https://my-site.com")
                        },
                )
            }
        }
    }
}
