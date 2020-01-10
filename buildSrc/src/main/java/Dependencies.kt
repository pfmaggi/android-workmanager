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

object Versions {
    val compileSdk = 29
    val minSdk = 16
    val targetSdk = 28
    val android_gradle_plugin = "4.0.0-alpha08"
    val kotlin = "1.3.60"
}

data class LibVersions(
        val androidxArch: String,
        val appcompat: String,
        val constraint_layout: String,
        val glide: String,
        val junit: String,
        val kotlin: String,
        val lifecycle: String,
        val test_rules: String,
        val test_runner: String,
        val timber: String,
        val work: String
)

object Libs {
    val APPCOMPAT = "androidx.appcompat:appcompat"
    val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout"
    val LIFECYCLE_EXTENSION = "androidx.lifecycle:lifecycle-extensions"
    val WORKMANAGER_KTS = "androidx.work:work-runtime-ktx"
    val GLIDE = "com.github.bumptech.glide:glide"
    val TIMBER = "com.jakewharton.timber:timber"
    val KT_STDLIB_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7"
    val TEST_CORE = "androidx.arch.core:core-testing"
    val TEST_JUNIT = "androidx.test.ext:junit"
    val TEST_RULES = "androidx.test:rules"
    val TEST_RUNNER = "androidx.test:runner"
    val TEST_WORMANAGER = "androidx.work:work-testing"
}