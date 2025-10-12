package com.kmp.dardev.league.app.template.presentation.screen.profile

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.presentation.components.popup.FeedbackCard
import com.kmp.dardev.league.app.template.presentation.screen.profile.component.ProfilSlider
import com.kmp.dardev.league.app.template.presentation.screen.profile.component.ProfilTopBar
import com.kmp.dardev.league.app.template.presentation.screen.profile.component.ProfilUserInfo
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    navController: NavController,
    context: Context,
    viewModel: ProfileViewModel = koinViewModel(),
) {
    val uriHandler = LocalUriHandler.current
    val dataUserIdNavigation by viewModel.userId.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    val connectedUserId =
        remember {
            mutableStateOf("")
        }

    val isYourProfil =
        remember {
            mutableStateOf(false)
        }

    val imageUrl =
        remember {
            mutableStateOf("")
        }

    val followingCount =
        remember {
            mutableStateOf<Long>(0)
        }

    val followerCount =
        remember {
            mutableStateOf<Long>(0)
        }

    val isFollow =
        remember {
            mutableStateOf(false)
        }

    val isRequestPending =
        remember {
            mutableStateOf(false)
        }
    val isLoading =
        remember {
            mutableStateOf(false)
        }

    var showFollowDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var showFollowers by rememberSaveable {
        mutableStateOf(false)
    }

    val painter =
        rememberAsyncImagePainter(
            model = imageUrl,
            placeholder = painterResource(id = R.drawable.land_logo_degrade_symbole),
            error = painterResource(id = R.drawable.land_logo_degrade_symbole),
        )

    LaunchedEffect(key1 = true) {
        isLoading.value = true

        isLoading.value = false
    }

    Scaffold(
        topBar = {
            ProfilTopBar(
                navController,
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
                        .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfilUserInfo(
                    painter = painter,
                    isLoading = isLoading,
                )
                ProfilSlider()
                FeedbackCard(
                    onFeedbackClick = {
                        uriHandler
                            .openUri(
                                "https://forms.gle/gPNMZ7NcommuQLT4A",
                            )
                    },
                )
            }
        }
    }
}
