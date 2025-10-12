package com.kmp.dardev.league.app.template.presentation.screen.onboarding.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.ui.theme.infoColor
import com.kmp.dardev.league.app.template.ui.theme.lightForeground
import com.kmp.dardev.league.app.template.util.AndroidStringResource

@Composable
fun ButtonExplore(eventClick: () -> Unit) {
    val gradientColor = listOf(infoColor, Color.Gray)

    Button(
        onClick = eventClick,
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
    ) {
        Box(
            modifier =
                Modifier
                    .width(350.dp)
                    .height(80.dp)
                    .fillMaxWidth()
                    .shadow(3.dp, RoundedCornerShape(50.dp))
                    .background(
                        brush = Brush.horizontalGradient(colors = gradientColor),
                        shape = RoundedCornerShape(50.dp),
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = AndroidStringResource(id = SharedRes.strings.validate_onboarding_button),
                color = lightForeground,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}
