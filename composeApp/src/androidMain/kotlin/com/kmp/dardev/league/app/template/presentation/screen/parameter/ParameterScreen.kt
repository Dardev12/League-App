package com.kmp.dardev.league.app.template.presentation.screen.parameter

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.presentation.common.CopyrightText
import com.kmp.dardev.league.app.template.presentation.screen.parameter.component.ParameterExpandableSection
import com.kmp.dardev.league.app.template.presentation.screen.parameter.component.ParameterInfoSection
import com.kmp.dardev.league.app.template.ui.theme.darkBackground
import com.kmp.dardev.league.app.template.ui.theme.topBarBackground
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ParameterScreen(
    navController: NavController,
    context: Context,
    viewModel: ParameterViewModel = koinViewModel(),
) {
    val coroutineScope = rememberCoroutineScope()
    val userId =
        remember {
            mutableStateOf("")
        }
    val removeAccountSuccess =
        remember {
            mutableStateOf(false)
        }
    val uriHandler = LocalUriHandler.current

    var emailPasswordExpanded by remember { mutableStateOf(false) }
    var themeColorExpanded by remember { mutableStateOf(false) }
    var accountManagementExpanded by remember { mutableStateOf(false) }

    var darkThemeEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = userId) {
        userId.value = viewModel.getUserID()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parameter") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.topBarBackground,
                        titleContentColor = darkBackground,
                        navigationIconContentColor = darkBackground,
                    ),
            )
        },
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(top = 70.dp, bottom = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ParameterInfoSection(
                    uriHandler = uriHandler,
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Section Email & Password
                ParameterExpandableSection(
                    title = "Section Email & Password",
                    expanded = emailPasswordExpanded,
                    onToggle = { emailPasswordExpanded = !emailPasswordExpanded },
                ) {
                    // Contenu de la section Email & Password
                    Column(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                    ) {
                        Text("Contenu de la section Email & Password")
                        // Ajoutez ici les champs pour modifier email et mot de passe
                    }
                }

                // Section Theme Color
                ParameterExpandableSection(
                    title = "Theme Color",
                    expanded = themeColorExpanded,
                    onToggle = { themeColorExpanded = !themeColorExpanded },
                ) {
                    // Contenu de la section Theme Color
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Switch(
                            checked = darkThemeEnabled,
                            onCheckedChange = { darkThemeEnabled = it },
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Dark theme - ",
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Text(
                            text = "activate",
                            color = Color.Green,
                        )
                    }
                }

                // Section Gestion Compte
                ParameterExpandableSection(
                    title = "Section Gestion Compte",
                    expanded = accountManagementExpanded,
                    onToggle = { accountManagementExpanded = !accountManagementExpanded },
                ) {
                    // Contenu de la section Gestion Compte
                    Column(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                    ) {
                        Text(
                            text = "Suppression du Compte",
                            modifier = Modifier.padding(bottom = 16.dp),
                        )

                        Button(
                            onClick = { /* Action de suppression du compte */ },
                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                ),
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                        ) {
                            Text(
                                text = "Supprimer Compte",
                                color = Color.White,
                                fontSize = 16.sp,
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                CopyrightText()
            }
        }
    }
}
