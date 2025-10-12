package com.kmp.dardev.league.app.template.presentation.screen.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfilSlider() {
    Row(
        modifier =
            Modifier
                .padding(10.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp),
                ).border(
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(20.dp),
                ),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        // All
        ProfilChipSection(text = "*", isSelected = true) {
        }
        // Post
        ProfilChipSection(text = "Post", isSelected = false) {
        }
        // Event
        ProfilChipSection(text = "Event", isSelected = false) {
        }
        // Circuit
        ProfilChipSection(text = "Circuit", isSelected = false) {
        }
    }
}
