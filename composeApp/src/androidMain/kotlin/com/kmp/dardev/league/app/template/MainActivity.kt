package com.kmp.dardev.league.app.template

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kmp.dardev.league.app.template.navigation.NavModel
import com.kmp.dardev.league.app.template.ui.theme.AppTheme
import com.kmp.dardev.league.app.template.util.AndroidStringResource
import com.kmp.dardev.league.app.template.util.ReviewManager
import com.vanniktech.rxpermission.Permission
import com.vanniktech.rxpermission.RealRxPermission
import io.reactivex.disposables.CompositeDisposable
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val compositeDisposable = CompositeDisposable()

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private val locationPermissionRequestCode = 1

    private lateinit var ratingManager: ReviewManager

    private fun handleImageCapture(uri: Uri) {
        Log.i("CAM", "Image captured: $uri")
        shouldShowCamera.value = false
    }

    private fun getOutputDirectory(): File {
        val mediaDir =
            externalMediaDirs.firstOrNull()?.let {
                File(it, "LandApp").apply { mkdirs() }
            }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted ->
            if (isGranted) {
                Log.i("kilo", "Permission granted")
                shouldShowCamera.value = true
            } else {
                Log.i("kilo", "Permission denied")
            }
        }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA,
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("kilo", "Permission previously granted")
                shouldShowCamera.value = true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA,
            ) -> Log.i("kilo", "Show camera permissions dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    // Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionNotification =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted: Boolean ->
            if (isGranted) {
                // FCM SDK (and your app) can post notifications.
            } else {
                // TODO: Inform user that that your app will not show notifications.
            }
        }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS,
                ) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (
                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)
            ) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionNotification.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()

        // MobileAds.initialize(this) {}

        ratingManager = ReviewManager(applicationContext, this)

        ratingManager.checkAndShowRatingDialog()

        setContent {
            AppTheme {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                    )
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    // Affichez une boîte de dialogue avant de demander la permission
                    AlertDialog
                        .Builder(this)
                        .setTitle(
                            AndroidStringResource(id = SharedRes.strings.location_permission_title),
                        ).setMessage(
                            AndroidStringResource(
                                id = SharedRes.strings.location_permission_text_label,
                            ),
                        ).setPositiveButton(
                            AndroidStringResource(id = SharedRes.strings.accept_text_button),
                        ) { _, _ ->
                            requestCameraPermission()
                            askNotificationPermission()
                            ActivityCompat.requestPermissions(
                                this,
                                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                locationPermissionRequestCode,
                            )
                            compositeDisposable.add(
                                RealRxPermission
                                    .getInstance(this)
                                    .requestEach(
                                        Manifest.permission.INTERNET,
                                        Manifest.permission.BLUETOOTH,
                                        Manifest.permission.BLUETOOTH_ADMIN,
                                        Manifest.permission.BLUETOOTH_SCAN,
                                        Manifest.permission.BLUETOOTH_ADVERTISE,
                                        Manifest.permission.BLUETOOTH_CONNECT,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                    ).reduce(
                                        true,
                                    ) {
                                        c: Boolean,
                                        p: Permission,
                                        ->
                                        c && p.state() == Permission.State.GRANTED
                                    }.subscribe { granted: Boolean ->
                                        if (granted) {
                                        }
                                    },
                            )
                        }.setNegativeButton(
                            AndroidStringResource(id = SharedRes.strings.refuse_text_button),
                        ) { _, _ ->
                            requestCameraPermission()
                            askNotificationPermission()
                        }.show()
                }
                navController = rememberNavController()
                NavModel(
                    navController = navController,
                    context = this,
                    outputDirectory = outputDirectory,
                    executor = cameraExecutor,
                    onImageCaptured = ::handleImageCapture,
                )
            }
        }

        /*FirebaseMessaging.getInstance().subscribeToTopic("all")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.e("TAG", "[FireBase] onCreate: subscribeToTopic")
                } else {
                    Log.e("TAG", "[FireBase] onCreate: subscribeToTopic failed")
                }
            }
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }

                println("[FireBase] Current token: ${task.result}")
                NotificationToken.saveToken(task.result)
            }
        )*/
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}
