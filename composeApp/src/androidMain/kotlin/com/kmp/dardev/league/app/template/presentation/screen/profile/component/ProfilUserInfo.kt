package com.kmp.dardev.league.app.template.presentation.screen.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import com.kmp.dardev.league.app.template.presentation.common.LoadingIcon
import com.kmp.dardev.league.app.template.ui.theme.profilContent
import com.kmp.dardev.league.app.template.ui.theme.profilContentTop
import com.kmp.dardev.league.app.template.ui.theme.topBarBackground

@Composable
fun ProfilUserInfo(
    painter: AsyncImagePainter,
    isLoading: MutableState<Boolean>,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp,
                    ),
                ).background(
                    MaterialTheme.colorScheme.topBarBackground,
                ).border(
                    width = 0.5.dp,
                    color = Color.Black,
                    shape =
                        RoundedCornerShape(
                            bottomStart = 50.dp,
                            bottomEnd = 50.dp,
                        ),
                ),
        horizontalAlignment = CenterHorizontally,
    ) {
        if (isLoading.value) {
            LoadingIcon()
        } else {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier =
                    Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.profilContentTop,
                            CircleShape,
                        ),
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "[USER NAME]",
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.profilContent,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
