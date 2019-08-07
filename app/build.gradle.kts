import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

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
    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}")
    implementation("androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}")
    implementation("androidx.work:work-runtime-ktx:${Versions.work}")
    implementation("com.github.bumptech.glide:glide:${Versions.glide}")
    implementation("com.jakewharton.timber:timber:${Versions.timber}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")

    androidTestImplementation("androidx.arch.core:core-testing:${Versions.androidxArch}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.junit}")
    androidTestImplementation("androidx.test:rules:${Versions.test_rules}")
    androidTestImplementation("androidx.test:runner:${Versions.test_runner}")
    androidTestImplementation("androidx.work:work-testing:${Versions.work}")
}
