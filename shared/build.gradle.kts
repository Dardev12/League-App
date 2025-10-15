import org.gradle.kotlin.dsl.android
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import dev.icerock.gradle.MRVisibility

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinCocoapods)
    alias(other.plugins.ktlint)
    alias(moko.plugins.mokoResources)
    //alias(sqldelight.plugins.sqldelight)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    /*targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            linkerOpts.add("-lsqlite3")
        }
    }*/

    cocoapods {
        version = "1.0"
        summary = "Shared"
        homepage = "Link to a Kotlin/Native module homepage"
        podfile = project.file("../iosApp/Podfile")
        ios.deploymentTarget = "18.2"

        framework {
            baseName = "shared"
            export(moko.mokoLibResources)
            export(moko.mokoGraphics)
            export(moko.mokoParcelize)
            isStatic = true
        }
        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = NativeBuildType.RELEASE
    }

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    js {
        outputModuleName = "shared"
        browser()
        binaries.library()
        generateTypeScriptDefinitions()
        compilerOptions {
            target = "es2015"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(moko.mokoLibResources)
                api(moko.mokoGraphics)

                //implementation(sqldelight.sqlCommon)
                //implementation(sqldelight.sqlCoroutines)

                implementation(ktor.ktorCore)
                implementation(ktor.ktorCio)

                implementation(coroutines.coroutineCoreKMM)

                implementation(kotlinx.kotlinxSerialization)
                implementation(kotlinx.kotlinxDatetime)
                implementation(kotlinx.kotlinXCoroutinesCore)

                implementation(other.napier)
                implementation(other.slf4j)

                api(koin.koinCore)

                implementation(firebase.firebaseAuthentication)
                implementation(firebase.firebaseFirestore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            kotlin.srcDir("build/generated/moko/androidMain/src")
            dependencies {
                //implementation(sqldelight.sqlAndroid)
                implementation(ktor.ktorAndroid)
            }
        }
        /*val androidNativeTest by getting {
            dependencies {
                implementation(test.junit)
                implementation(test.mockk)

                //implementation(sqldelight.sqlDriver)
                //implementation(sqldelight.sqlJKvm)
            }
        }*/
        val jsMain by getting {
            dependencies {
                implementation(ktor.ktorJs)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                api(moko.mokoLibResources)
                api(moko.mokoGraphics)
                api(moko.mokoParcelize)
                //implementation(sqldelight.sqlIos)
                implementation(ktor.ktorIos)
                implementation(other.touchlabStately)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.kmp.dardev.league.app.template.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

/*sqldelight {
    databases {
        create("LeagueDatabase") {
            packageName.set("com.kmp.dardev.league.app.template.database")
            srcDirs.setFrom("src/commonMain/sqldelight")
        }
    }
}*/

multiplatformResources {
    resourcesPackage.set("com.kmp.dardev.league.app.template")
    resourcesClassName.set("SharedRes")
    resourcesVisibility.set(MRVisibility.Public)
    iosMinimalDeploymentTarget.set("18.2")
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    verbose.set(true)
    ignoreFailures.set(false)
    //disabledRules.set(setOf("final-newline", "no-wildcard-imports","function-naming"))
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)

    }
}