plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.targetSdk)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    // logger module
    implementation(project(":logger-android:logger"))

    // kotlin
    implementation(Dependency.Kotlin.stdlib)

    // androidX
    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appcompat)
    implementation(Dependency.AndroidX.constraintLayout)
    implementation(Dependency.AndroidX.swipeRefreshLayout)
    implementation(Dependency.AndroidX.recyclerView)
    implementation(Dependency.AndroidX.activity)
    implementation(Dependency.AndroidX.fragment)

    // lifecycle
    implementation(Dependency.Lifecycle.lifecycleLiveData)
    implementation(Dependency.Lifecycle.lifecycleViewModel)

    // material
    implementation(Dependency.Google.material)

    // ADID
    implementation(Dependency.Google.playServiceADID)

    // coroutines
    implementation(Dependency.coroutines)

    // test
    testImplementation(Dependency.Test.junit)
    testImplementation(Dependency.Test.mockito)
    testImplementation(Dependency.Test.truth)
}