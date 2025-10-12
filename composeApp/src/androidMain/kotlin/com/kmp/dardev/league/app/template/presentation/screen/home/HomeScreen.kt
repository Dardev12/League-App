package com.kmp.dardev.league.app.template.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.presentation.components.navigation.BottomBar
import com.kmp.dardev.league.app.template.presentation.components.navigation.TopBar
import com.kmp.dardev.league.app.template.presentation.components.popup.FeedbackCard
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val context = LocalContext.current

    val userId =
        remember {
            mutableStateOf("")
        }

    val haveNotification =
        remember {
            mutableStateOf(false)
        }

    val showAppIntro =
        remember {
            mutableStateOf(true)
        }

    LaunchedEffect(key1 = true) {
        userId.value = viewModel.getUserID()
        viewModel.analyticsSetUserId(userId.value)
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                userID = userId,
            )
        },
        topBar = {
            TopBar(
                navController = navController,
                haveNotification = haveNotification,
            )
        },
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 100.dp, bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Titre
            Text(
                text = "Welcome to [Name App]",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 16.dp),
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp),
            )

            // Première section : 3 éléments en ligne
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                        .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Start,
            ) {
                repeat(6) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier =
                                Modifier
                                    .size(60.dp)
                                    .background(Color.Gray, CircleShape),
                        )
                        Text(text = "Test", style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp),
            )

            // Deuxième section : Liste d'éléments
            Column(modifier = Modifier.padding(16.dp)) {
                repeat(2) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp),
                    ) {
                        Box(
                            modifier =
                                Modifier
                                    .size(60.dp)
                                    .background(Color.Gray, CircleShape),
                        )
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            Text(
                                text = "Test",
                                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Blue),
                            )
                            Text(
                                text = "Topic : this is the topic",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                }
            }

            FeedbackCard(
                onFeedbackClick = {
                    // Handle feedback button click
                },
            )
        }
    }
}
