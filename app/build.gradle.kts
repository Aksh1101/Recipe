plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)

    id("org.jetbrains.kotlin.plugin.serialization") version "2.4.10"
}

android {
    namespace = "com.aksh.recipe"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.aksh.recipe"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    // 1. Jetpack ViewModel (For UI Lifecycle Management)

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0") // For Jetpack Compose

    // 2. Jetpack Navigation (For Screen Routing)

    implementation("androidx.navigation:navigation-compose:2.10.0")

    // 3. Kotlinx Serialization (For JSON Parsing)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

    // 4. Coil (For Image Loading - Jetpack Compose Native Version)
    implementation("io.coil-kt.coil3:coil-compose:3.6.1")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.1")

    // 5. Material Icons (For System Graphics)
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

}