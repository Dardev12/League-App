import org.gradle.kotlin.dsl.implementation
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    // alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(other.plugins.ktlint)
}

allprojects {
    repositories {
        maven(url = "https://jitpack.io")
    }
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(date.datePickerCore)
            implementation(date.datePickerCalendar)

            implementation(androidx.coreKtx)
            implementation(androidx.appCompat)
            implementation(androidx.composeUI)
            implementation(androidx.composeUITooling)
            implementation(androidx.composeUIToolingPreview)
            implementation(androidx.composeFoundation)
            implementation(androidx.composeMaterial)
            implementation(androidx.workerKtx)

            implementation(coroutines.coroutineAndroid)

            implementation(other.sweetToast)
            implementation(other.nodleSdk)
            implementation(other.rxPermission)
            implementation(other.twyper)

            implementation(firebase.androidFirebase)
            implementation(firebase.androidFirebaseKTXStorage)
            implementation(firebase.androidFirebaseMessaging)
            implementation(firebase.androidFirebaseMessagingKTX)
            implementation(firebase.androidFirebaseAnalytics)

            implementation(retrofit.retrofitMain)
            implementation(retrofit.retrofitGson)

            implementation(moshi.moshiMain)
            implementation(moshi.moshiKotlin)

            implementation(koin.koinCore)
            implementation(koin.koinAndroid)
            implementation(koin.koinAndroidxCompose)

            implementation(compose.navigation)
            implementation(compose.viewModelCompose)
            implementation(compose.animationCompose)
            implementation(compose.activityCompose)

            implementation(coil.coilCompose)

            implementation(google.composeMap)
            implementation(google.gmsGoogleMap)
            implementation(google.googlePlaces)
            implementation(google.guava)
            // implementation(google.playAdsService)
            implementation(google.auth)

            implementation(materialdesign.materialD3)
            implementation(materialdesign.materialD3WindowSize)

            implementation(camerax.cameraXLifeCycle)
            implementation(camerax.cameraXVideo)
            implementation(camerax.cameraXView)
            implementation(camerax.cameraXExtension)
            implementation(camerax.cameraXCAM)
            implementation(camerax.exifInterface)

            implementation(accompanist.permission)

            implementation(google.reviewMain)
            implementation(google.reviewKtx)

            implementation(kotlinx.kotlinxDatetime)
            implementation(kotlinx.kotlinBom)

            implementation(other.geoLib)
            implementation(other.canopasView)
        }
        commonMain.dependencies {
            /*implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)*/
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(projects.shared)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.kmp.dardev.league.app.template"
    compileSdk =
        libs.versions.android.compileSdk
            .get()
            .toInt()

    defaultConfig {
        applicationId = "com.kmp.dardev.league.app.template"
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()
        targetSdk =
            libs.versions.android.targetSdk
                .get()
                .toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    android.set(true)
    ignoreFailures.set(false)
    // disabledRules.set(setOf("final-newline", "no-wildcard-imports", "function-naming")) -> je souhaite disabled ces rules
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
    }
}

dependencies {
    // debugImplementation(compose.uiTooling)
}
