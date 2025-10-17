package com.kmp.dardev.league.app.template.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kmp.dardev.league.app.template.R

val leaguespartan_Black = FontFamily(Font(R.font.leaguespartan_black, FontWeight.Black))
val leaguespartan_Bold = FontFamily(Font(R.font.leaguespartan_bold, FontWeight.Bold))
val leaguespartan_Medium = FontFamily(Font(R.font.leaguespartan_medium, FontWeight.Medium))
val leaguespartan_SemiBold = FontFamily(Font(R.font.leaguespartan_semibold, FontWeight.SemiBold))
val leaguespartan_Regular = FontFamily(Font(R.font.leaguespartan_regular, FontWeight.Normal))
val leaguespartan_Extrabold = FontFamily(Font(R.font.leaguespartan_extrabold, FontWeight.ExtraBold))
val leaguespartan_Thin = FontFamily(Font(R.font.leaguespartan_thin, FontWeight.Thin))
val leaguespartan_Light = FontFamily(Font(R.font.leaguespartan_light, FontWeight.Light))
val leaguespartan_ExtraLight = FontFamily(Font(R.font.leaguespartan_extralight, FontWeight.ExtraLight))

val typography =
    Typography(
        displayLarge =
            TextStyle(
                fontFamily = leaguespartan_Bold,
                fontSize = 25.sp,
            ),
        displayMedium =
            TextStyle(
                fontFamily = leaguespartan_Medium,
                fontSize = 25.sp,
            ),
        displaySmall =
            TextStyle(
                fontFamily = leaguespartan_Regular,
                fontSize = 25.sp,
            ),
        headlineLarge =
            TextStyle(
                fontFamily = leaguespartan_SemiBold,
                fontSize = 20.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = leaguespartan_Medium,
                fontSize = 20.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = leaguespartan_Regular,
                fontSize = 20.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = leaguespartan_Bold,
                fontSize = 20.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = leaguespartan_Regular,
                fontSize = 18.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = leaguespartan_Light,
                fontSize = 16.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = leaguespartan_Medium,
                fontSize = 14.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = leaguespartan_Regular,
                fontSize = 14.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = leaguespartan_Light,
                fontSize = 12.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = leaguespartan_SemiBold,
                fontSize = 16.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = leaguespartan_Regular,
                fontSize = 14.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = leaguespartan_Light,
                fontSize = 12.sp,
            ),
    )
