package com.kmp.dardev.league.app.template.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.kmp.dardev.league.app.template.core.presentation.MokoStringsResources
import dev.icerock.moko.resources.StringResource

@Composable
fun AndroidStringResource(
    id: StringResource,
    vararg args: Any,
): String = MokoStringsResources(LocalContext.current).get(id, args.toList())
