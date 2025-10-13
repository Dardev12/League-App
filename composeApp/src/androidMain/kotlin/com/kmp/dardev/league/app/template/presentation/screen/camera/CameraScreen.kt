package com.kmp.dardev.league.app.template.presentation.screen.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.kmp.dardev.league.app.template.R
import com.kmp.dardev.league.app.template.SharedRes
import com.kmp.dardev.league.app.template.navigation.Screen
import com.kmp.dardev.league.app.template.presentation.common.LoadingIcon
import com.kmp.dardev.league.app.template.presentation.screen.camera.CameraViewModel
import com.kmp.dardev.league.app.template.ui.theme.infoColor
import com.kmp.dardev.league.app.template.ui.theme.textColor
import com.kmp.dardev.league.app.template.util.AndroidStringResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.io.File
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun CameraScreen(
    navController: NavController,
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit,
    viewModel: CameraViewModel = koinViewModel(),
) {
    val coroutineScope = rememberCoroutineScope()
    val descriptionNavigation by viewModel.descriptionData.collectAsState()
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = Preview.Builder().build()
    val previewView = remember { PreviewView(context) }
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
    val photoUrl =
        remember {
            mutableStateOf("")
        }
    var latitude = remember { mutableStateOf(0.0) }
    var longitude = remember { mutableStateOf(0.0) }
    var title = remember { mutableStateOf(" ") }
    var description = remember { mutableStateOf(" ") }
    var isBackCamera = remember { mutableStateOf(true) }
    var isLoading = remember { mutableStateOf(false) }
    val cameraSelector =
        CameraSelector
            .Builder()
            .requireLensFacing(lensFacing)
            .build()

    // État pour la permission de la caméra
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val permissionsGranted = cameraPermissionState.status

    LaunchedEffect(key1 = cameraPermissionState) {
        when (cameraPermissionState.status) {
            is PermissionStatus.Denied -> {
                cameraPermissionState.launchPermissionRequest()
            }
            else -> Unit
        }
    }

    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture,
        )

        preview.setSurfaceProvider(previewView.surfaceProvider)
        descriptionNavigation?.let {
            if (it != " ") {
                description.value = it
            }
        }
    }

    Scaffold(
        topBar = {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                if (permissionsGranted.isGranted) {
                    IconButton(onClick = { navController.navigate(Screen.HomePage.route) }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.textColor,
                            modifier =
                                Modifier
                                    .size(50.dp),
                        )
                    }
                } else {
                    IconButton(onClick = { navController.navigate(Screen.HomePage.route) }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.textColor,
                            modifier =
                                Modifier
                                    .size(50.dp),
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (permissionsGranted.isGranted) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Spacer(modifier = Modifier.width(80.dp))
                    if (isLoading.value) {
                        LoadingIcon()
                    } else {
                        IconButton(onClick = {
                            if (isLoading.value) return@IconButton

                            isLoading.value = true
                            coroutineScope.launch {
                                try {
                                    takePhoto(
                                        filenameFormat = "yyyy-MM-dd-HH-mm-ss-SSS",
                                        imageCapture = imageCapture,
                                        outputDirectory = outputDirectory,
                                        executor = executor,
                                        onImageCaptured = onImageCaptured,
                                        onError = onError,
                                        onNavigate = {
                                            if (it != "") {
                                                navController.navigate(
                                                    Screen.HomePage.route,
                                                )
                                            }
                                        },
                                        photoUrl = photoUrl,
                                        longitudeData = longitude,
                                        latitudeData = latitude,
                                        context,
                                    )
                                } catch (e: Exception) {
                                    navController.navigate(Screen.HomePage.route)
                                } finally {
                                    isLoading.value = false
                                }
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_camera_button),
                                contentDescription =
                                    AndroidStringResource(
                                        id = SharedRes.strings.take_picture_text,
                                    ),
                                tint = infoColor,
                                modifier =
                                    Modifier
                                        .size(60.dp),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    IconButton(onClick = {
                        val cameraId =
                            if (isBackCamera.value) {
                                CameraSelector
                                    .Builder()
                                    .requireLensFacing(CameraSelector.LENS_FACING_FRONT)
                                    .build()
                            } else {
                                CameraSelector
                                    .Builder()
                                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                                    .build()
                            }

                        coroutineScope.launch {
                            val cameraProvider = context.getCameraProvider()
                            cameraProvider.unbindAll()
                            cameraProvider.bindToLifecycle(
                                lifecycleOwner,
                                cameraId,
                                preview,
                                imageCapture,
                            )
                        }

                        preview.setSurfaceProvider(previewView.surfaceProvider)

                        isBackCamera.value = !isBackCamera.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cameraswitch),
                            contentDescription =
                                AndroidStringResource(
                                    id = SharedRes.strings.switch_side_camera_text,
                                ),
                            tint = MaterialTheme.colorScheme.textColor,
                            modifier =
                                Modifier
                                    .size(50.dp),
                        )
                    }
                }
            }
        },
    ) {
        if (permissionsGranted.isGranted) {
            AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().padding(20.dp),
            ) {
                Text(
                    AndroidStringResource(
                        id = SharedRes.strings.camera_permission_request,
                    ),
                )
            }
        }
    }
}

private suspend fun takePhoto(
    filenameFormat: String,
    imageCapture: ImageCapture,
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit,
    onNavigate: (String) -> Unit,
    photoUrl: MutableState<String>,
    longitudeData: MutableState<Double>,
    latitudeData: MutableState<Double>,
    context: Context,
) {
    val photoFile =
        File(
            outputDirectory,
            SimpleDateFormat(filenameFormat, Locale.US).format(System.currentTimeMillis()) + ".jpg",
        )

    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    imageCapture.takePicture(
        outputOptions,
        executor,
        object : ImageCapture.OnImageSavedCallback {
            override fun onError(exception: ImageCaptureException) {
                Log.e("CAM", "Take photo error:", exception)
                onError(exception)
            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                val savedUri = Uri.fromFile(photoFile)
                onImageCaptured(savedUri)

                photoUrl.value =
                    URLEncoder.encode(
                        savedUri.toString(),
                        StandardCharsets.UTF_8.toString(),
                    )

                val hasPermission =
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                    ) == PackageManager.PERMISSION_GRANTED

                CoroutineScope(Dispatchers.Main).launch {
                    onNavigate(photoUrl.value)
                }
            }
        },
    )
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }
