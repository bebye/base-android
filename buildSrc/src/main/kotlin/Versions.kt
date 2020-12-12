/**
 * Created by mkwon on 06/11/2020.
 */
object Versions {
    // app version
    const val versionName = "1.0.0"
    const val versionCode = 100

    // gradle plugin
    const val buildGradle = "4.1.0"                 // https://developer.android.com/studio/releases/gradle-plugin
    const val googleServicesGradle = "4.3.4"        // https://developers.google.com/android/guides/releases
    const val firebaseCrashlyticsGradle = "2.3.0"

    // sdk
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildTools = "30.0.2"                 // https://developer.android.com/studio/releases/build-tools

    // kotlin
    const val kotlin = "1.4.0"                      // https://blog.jetbrains.com/kotlin/category/releases/

    // androidX
    const val core = "1.3.2"                        // https://developer.android.com/jetpack/androidx/releases/core?hl=ko
    const val appcompat = "1.2.0"                   // https://developer.android.com/jetpack/androidx/releases/appcompat
    const val lifecycle = "2.2.0"                   // https://developer.android.com/jetpack/androidx/releases/lifecycle
    const val constraintLayout = "2.0.0"            // https://developer.android.com/jetpack/androidx/releases/constraintlayout
    const val swipeRefreshLayout = "1.1.0"          // https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
    const val recyclerView = "1.1.0"                // https://developer.android.com/jetpack/androidx/releases/recyclerview
    const val paging = "2.1.2"                      // https://developer.android.com/jetpack/androidx/releases/paging
    const val navigation = "2.3.1"                  // https://developer.android.com/jetpack/androidx/releases/navigation
    const val activity = "1.1.0"                    // https://developer.android.com/jetpack/androidx/releases/activity
    const val fragment = "1.2.5"                    // https://developer.android.com/jetpack/androidx/releases/fragment

    // google
    const val playCore = "1.8.1"                    // https://developer.android.com/reference/com/google/android/play/core/release-notes
    const val playServicesADID = "17.0.0"           // https://developers.google.com/android/guides/releases
    const val material = "1.1.0"                    // https://github.com/material-components/material-components-android/releases
    const val gson = "2.8.6"                        // https://github.com/google/gson

    // hilt
    const val hiltAndroid = "2.28-alpha"            // https://github.com/google/dagger/releases
    const val hiltLifecycle = "1.0.0-alpha01"       // https://developer.android.com/training/dependency-injection/hilt-jetpack

    // dagger
    const val dagger = "2.28"                       // https://github.com/google/dagger/releases

    // room
    const val room = "2.2.5"                        // https://developer.android.com/jetpack/androidx/releases/room

    // work
    const val work = "2.3.4"                        // https://developer.android.com/jetpack/androidx/releases/work

    // firebase
    const val firebaseBoM = "26.0.0"                // https://firebase.google.com/support/release-notes/android

    // retrofit
    const val retrofit = "2.9.0"                    // https://square.github.io/retrofit/
    const val loggingInterceptor = "4.9.0"          // https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor

    // coroutines
    const val coroutines = "1.4.0"                  // https://github.com/Kotlin/kotlinx.coroutines/releases

    // glide
    const val glide = "4.11.0"                      // https://github.com/bumptech/glide/releases

    // test
    const val junit = "4.13"
    const val junitPlatformRunner = "1.2.0"
    const val junitJupiter = "5.2.0"                // https://junit.org/junit5/docs/current/user-guide/#overview
    const val mockitoCore = "3.3.3"                 // https://github.com/mockito/mockito
    const val hamcrest = "1.3"

    // androidTest
    const val testRules = "1.3.0"
    const val testRunner = "1.3.0"
    const val espresso = "3.3.0"
}