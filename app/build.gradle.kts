/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

val versions: LibVersions by rootProject.extra

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = "com.example.background"
        renderscriptTargetApi = 11
        renderscriptSupportModeEnabled = true
        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // The following argument makes the Android Test Orchestrator run its
        // "pm clear" command after each test invocation. This command ensures
        // that the app's state is completely cleared between tests.
        testInstrumentationRunnerArguments = mapOf("clearPackageData" to "true")

        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.allWarningsAsErrors = true
}

dependencies {
    implementation("${Libs.APPCOMPAT}:${versions.appcompat}")
    implementation("${Libs.CONSTRAINTLAYOUT}:${versions.constraint_layout}")
    implementation("${Libs.LIFECYCLE_EXTENSION}:${versions.lifecycle}")
    implementation("${Libs.WORKMANAGER_KTS}:${versions.work}")
    implementation("${Libs.GLIDE}:${versions.glide}")
    implementation("${Libs.TIMBER}:${versions.timber}")
    implementation("${Libs.KT_STDLIB_JDK7}:${versions.kotlin}")

    androidTestImplementation("${Libs.TEST_CORE}:${versions.androidxArch}")
    androidTestImplementation("${Libs.TEST_JUNIT}:${versions.junit}")
    androidTestImplementation("${Libs.TEST_RULES}:${versions.test_rules}")
    androidTestImplementation("${Libs.TEST_RUNNER}:${versions.test_runner}")
    androidTestImplementation("${Libs.TEST_WORMANAGER}:${versions.work}")
}
