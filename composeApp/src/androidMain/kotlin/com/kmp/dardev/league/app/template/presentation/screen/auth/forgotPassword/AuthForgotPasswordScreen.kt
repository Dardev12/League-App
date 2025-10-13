package com.kmp.dardev.league.app.template.presentation.screen.auth.forgotPassword

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.navigation.Screen
import com.kmp.dardev.league.app.template.presentation.common.Button
import com.kmp.dardev.league.app.template.presentation.common.CopyrightText
import com.kmp.dardev.league.app.template.presentation.common.LoadingButton
import com.kmp.dardev.league.app.template.presentation.common.OutlinedTextField
import com.kmp.dardev.league.app.template.ui.theme.infoColor
import com.kmp.dardev.league.app.template.ui.theme.textColor
import com.kmp.dardev.league.app.template.util.AndroidStringResource
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetSuccess
import dev.icerock.moko.resources.StringResource
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun AuthForgotPasswordScreen(
    navController: NavController,
    context: Context,
    viewModel: AuthForgotPasswordViewModel = koinViewModel(),
) {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    var email = remember { mutableStateOf("") }

    val textToast = remember { mutableStateOf("") }
    val resourceId = remember { mutableStateOf<StringResource?>(null) }
    val isLoading = remember { mutableStateOf(false) }
    val termsText = AndroidStringResource(id = SharedRes.strings.terms_of_use_text_label)
    val annotatedText =
        buildAnnotatedString {
            pushStyle(SpanStyle(color = MaterialTheme.colorScheme.textColor))
            append(AndroidStringResource(id = SharedRes.strings.accept_forgot_password_use_condition))
            pushStyle(SpanStyle(color = infoColor))
            addStringAnnotation(
                tag = "TermsLink",
                annotation = "TermsLink",
                start = length - termsText.length,
                end = length,
            )
            append(" " + AndroidStringResource(id = SharedRes.strings.terms_of_use_text_label))
            pop()
        }

    fun iconVisibility(visibility: Boolean): Int =
        if (visibility) {
            R.drawable.ic_show_password
        } else {
            R.drawable.ic_unshow_password
        }

    val onClickSendRecoverPasswordEmail: () -> Unit = {
        isLoading.value = true

        if (
            viewModel.verifyEmailField(email.value).successful
        ) {
            coroutineScope.launch {
                resourceId.value = viewModel.SendEmailToUser(email.value)
            }
        } else {
            resourceId.value = SharedRes.strings.enroll_error_validation_message
        }
        isLoading.value = false
    }

    Scaffold {
        Box {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp)
                        .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painterResource(id = R.drawable.land_logo_degrade_symbole),
                    modifier = Modifier.width(100.dp).height(120.dp),
                    alignment = Alignment.TopCenter,
                    contentDescription = "",
                )
                Text(
                    text = AndroidStringResource(id = SharedRes.strings.forgot_password_text_label),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium,
                )
                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier.width(322.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text =
                            AndroidStringResource(
                                id = SharedRes.strings.forgot_password_text_label,
                            ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
                OutlinedTextField(
                    email,
                    AndroidStringResource(id = SharedRes.strings.email_text_label),
                    eventChange = { viewModel.verifyEmailField(email.value) },
                )
                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(20.dp))
                ClickableText(
                    text = annotatedText,
                    onClick = { offset ->
                        annotatedText
                            .getStringAnnotations(
                                tag = "TermsLink",
                                start = offset,
                                end = offset,
                            ).firstOrNull()
                            ?.let {
                                if (it.item == "TermsLink") {
                                    uriHandler
                                        .openUri(
                                            "https://www.termsfeed.com/live/" +
                                                "ff8a726a-3f98-40b1-9987-ce642a96e5c0",
                                        )
                                }
                            }
                    },
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (isLoading.value) {
                    LoadingButton()
                } else {
                    Button(
                        eventClick = onClickSendRecoverPasswordEmail,
                        content =
                            AndroidStringResource(
                                id = SharedRes.strings.forgot_password_text_label,
                            ),
                    )
                }
                if (resourceId.value != null) {
                    textToast.value = AndroidStringResource(id = resourceId.value!!)
                    if (textToast.value ==
                        AndroidStringResource(
                            id = SharedRes.strings.enroll_success_message,
                        )
                    ) {
                        SweetSuccess(
                            message = textToast.value,
                            padding = PaddingValues(bottom = 16.dp),
                        )
                        textToast.value = ""
                        navController.navigate(Screen.HomePage.route)
                    } else {
                        SweetError(
                            message = textToast.value,
                            padding = PaddingValues(bottom = 16.dp),
                        )
                        textToast.value = ""
                    }
                    resourceId.value = null
                }

                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.padding(5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text =
                            AndroidStringResource(
                                id = SharedRes.strings.navigate_to_connexion_text_label,
                            ),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.textColor,
                    )
                    Text(
                        text = AndroidStringResource(id = SharedRes.strings.connexion_text_button),
                        modifier =
                            Modifier
                                .clickable {
                                    navController.navigate(Screen.SignInPage.route)
                                }.padding(start = 5.dp),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelSmall,
                        color = infoColor,
                    )
                }
                CopyrightText()
            }
        }
    }
}
