/**
 * Created by mkwon on 06/11/2020.
 */
object Dependency {
    object GradlePlugin {
        const val build = "com.android.tools.build:gradle:${Versions.buildGradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val googleService = "com.google.gms:google-services:${Versions.googleServicesGradle}"
        const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"
        const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Lifecycle {
        const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
        const val lifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    }

    object Google {
        const val playCore = "com.google.android.play:core-ktx:${Versions.playCore}"
        const val playServiceADID = "com.google.android.gms:play-services-ads-identifier:${Versions.playServicesADID}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
        const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycle}"
        const val compiler = "androidx.hilt:hilt-compiler:${Versions.hiltLifecycle}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val test = "androidx.room:room-testing:${Versions.room}"
    }

    object Work {
        const val work = "androidx.work:work-runtime:${Versions.work}"
        const val workTest = "androidx.work:work-testing:${Versions.work}"
    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:${Versions.firebaseBoM}"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val dynamicLinks = "com.google.firebase:firebase-dynamic-links-ktx"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    }

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    object Glide {
        const val okHttp3Integration = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
        const val hamcreset = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
        const val kotlinJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }

    object ApiTest {
        const val junitPlatformRunner = "org.junit.platform:junit-platform-runner:${Versions.junitPlatformRunner}"
        const val junitJupiterAPI = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiter}"
        const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiter}"
    }

    object AndroidTest {
        const val rules = "androidx.test:rules:${Versions.testRules}"
        const val runner = "androidx.test:runner:${Versions.testRunner}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

}