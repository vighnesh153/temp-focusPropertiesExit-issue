plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.tvtestviewscompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tvtestviewscompose"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

    }
    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.leanback)
    implementation(libs.glide)

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.compose.foundation:foundation:1.7.0-alpha04")
    implementation("androidx.compose.ui:ui:1.7.0-alpha04")

    implementation("androidx.tv:tv-material:1.0.0-alpha10")

    implementation("androidx.work:work-runtime-ktx:2.9.0")
}