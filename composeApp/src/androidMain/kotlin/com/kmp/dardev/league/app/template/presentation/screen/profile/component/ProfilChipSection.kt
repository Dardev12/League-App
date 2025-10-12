package com.kmp.dardev.league.app.template.presentation.screen.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfilChipSection(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .width(80.dp)
                .background(
                    color = if (isSelected) Color(0xFF4EA7EE) else Color.White,
                    shape = RoundedCornerShape(20.dp),
                ).clickable {
                    onSelected()
                },
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color(0xFF4EA7EE),
            modifier = Modifier.padding(8.dp).align(Alignment.Center),
        )
    }
}
