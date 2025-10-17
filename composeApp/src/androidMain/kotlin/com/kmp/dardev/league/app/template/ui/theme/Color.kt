package com.kmp.dardev.league.app.template.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kmp.dardev.league.app.template.core.presentation.ColorsApp

val darkBackground = Color(ColorsApp.DarkBackground)
val darkForeground = Color(ColorsApp.DarkForeground)

val lightBackground = Color(ColorsApp.LightBackground)
val lightForeground = Color(ColorsApp.LightForeground)

val lightBottomTopBarBackground = Color(ColorsApp.LightBottomTopBackground)
val darkBottomTopBarBackground = Color(ColorsApp.DarkBottomTopBackground)

val PrimaryLight = Color(ColorsApp.PrimaryLight)
val PrimaryDark = Color(ColorsApp.PrimaryDark)
val SecondaryLight = Color(ColorsApp.SecondaryLight)
val SecondaryDark = Color(ColorsApp.SecondaryDark)
val TertiaryLight = Color(ColorsApp.TertiaryLight)
val TertiaryDark = Color(ColorsApp.TertiaryDark)
val TextPrimaryLight = Color(ColorsApp.TextPrimaryLight)
val TextPrimaryDark = Color(ColorsApp.TextPrimaryDark)
val TextSecondaryLight = Color(ColorsApp.TextSecondaryLight)
val TextSecondaryDark = Color(ColorsApp.TextSecondaryDark)

val successColor = Color(ColorsApp.SuccessGreen)
val errorColor = Color(ColorsApp.ErrorRed)
val infoColor = Color(ColorsApp.InfoBlue)
val warningColor = Color(ColorsApp.WarningYellow)
val switchTrackUnchecked = Color(ColorsApp.uncheckedSwitch)

val ColorScheme.buttonFeedbackBackground
    @Composable
    get() = infoColor

val ColorScheme.feedbackBoxBackground
    @Composable
    get() = if (isSystemInDarkTheme()) TertiaryDark else TertiaryLight

val ColorScheme.feedbackTextForeground
    @Composable
    get() = if (isSystemInDarkTheme()) TextPrimaryDark else TextPrimaryLight

val ColorScheme.buttonBackground
    @Composable
    get() = if (isSystemInDarkTheme()) PrimaryDark else PrimaryLight

val ColorScheme.buttonContent
    @Composable
    get() = if (isSystemInDarkTheme()) TextPrimaryDark else TextPrimaryLight

val ColorScheme.iconbuttonBackground
    @Composable
    get() = if (isSystemInDarkTheme()) darkBackground else lightBackground

val ColorScheme.iconbuttonContent
    @Composable
    get() = if (isSystemInDarkTheme()) darkForeground else lightForeground

val ColorScheme.clickableIconContent
    @Composable
    get() = if (isSystemInDarkTheme()) darkForeground else lightForeground

val ColorScheme.textColor
    @Composable
    get() = if (isSystemInDarkTheme()) TextPrimaryDark else TextPrimaryLight

val ColorScheme.profilContentTop
    @Composable
    get() = if (isSystemInDarkTheme()) darkBackground else lightBackground

val ColorScheme.profilContent
    @Composable
    get() = if (isSystemInDarkTheme()) darkForeground else lightForeground

val ColorScheme.textFieldBackground
    @Composable
    get() = if (isSystemInDarkTheme()) TextSecondaryDark else TextSecondaryLight

val ColorScheme.textFieldContent
    @Composable
    get() = if (isSystemInDarkTheme()) lightForeground else lightForeground

val ColorScheme.bottomBarBackground
    @Composable
    get() = if (isSystemInDarkTheme()) darkBottomTopBarBackground else lightBottomTopBarBackground

val ColorScheme.topBarBackground
    @Composable
    get() = if (isSystemInDarkTheme()) darkBottomTopBarBackground else lightBottomTopBarBackground

val ColorScheme.popUpBackground
    @Composable
    get() = if (isSystemInDarkTheme()) SecondaryDark else SecondaryLight

val ColorScheme.popUpContent
    @Composable
    get() = if (isSystemInDarkTheme()) darkForeground else lightForeground
