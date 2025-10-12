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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.ui.theme.buttonBackground
import com.kmp.dardev.league.app.template.ui.theme.buttonContent
import com.kmp.dardev.league.app.template.util.AndroidStringResource

@Composable
fun ButtonNext(eventClick: () -> Unit) {
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
                        color = MaterialTheme.colorScheme.buttonBackground,
                        shape = RoundedCornerShape(size = 50.dp),
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = AndroidStringResource(id = SharedRes.strings.next_page_button),
                color = MaterialTheme.colorScheme.buttonContent,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}
