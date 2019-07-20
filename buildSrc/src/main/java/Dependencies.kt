import Versions.gsonConverter
import Versions.koin_version

object Versions {
    const val kotlinLib = "1.3.20"
    const val minSDK = 22
    const val targetSDK = 28
    const val compileSDK = 28
    const val recyclerView = "1.1.0-alpha01"
    const val gson = "2.8.5"
    const val gsonConverter = "2.5.0"
    const val lottie = "2.8.0"
    const val charts = "v2.1.6"
    const val retrofit = "2.5.0"
    const val httpLogging = "3.12.0"
    const val appCompat = "1.0.2"
    const val materialComponents = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val koin_version = "1.0.1"
    const val lifeCycle = "1.1.1"
    const val kotlinVersion = "1.2.71"
    const val kotlinCoreKtxVersion = "1.0.2"
    const val supportDesign = "28.0.0"
    const val retrofitVersion = "2.4.0"
    const val gsonLib = "2.8.5"
    const val materialLibVersion = "1.0.0"
    const val cardViewVersion = "1.0.0"
    const val testRunnerVersion = "1.2.0"
    const val junitVersion = "4.12"
    const val espressoVersion = "3.2.0"
    const val lifecycle_version = "1.1.1"

}

object AppDeps {

    val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val junitLib = "junit:junit:4.12"
    val testRunner = "com.android.support.test:runner:1.0.2"
    val testRule = "com.android.support.test:rules:1.0.2"
    val espressoLib = "com.android.support.test.espresso:espresso-core:${Versions.espressoVersion}"
    val LifeCycleLib = "android.arch.lifecycle:extensions:${Versions.lifecycle_version}"
    val chartLib = "com.github.PhilJay:MPAndroidChart:${Versions.charts}"
    val animationLib = "com.airbnb.android:lottie:${Versions.lottie}"
    val appCompat =  "androidx.appcompat:appcompat:${Versions.appCompat}"
    val materialDesign = "com.google.android.material:material:${Versions.materialLibVersion}"
    //Constraintlayout
    val constraintlayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    //NetWork
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    val httpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.httpLogging}"
    val cardView = "com.android.support:cardview-v7:${Versions.supportDesign}"
    // ViewModel and LiveData
    val supportDesign = "com.android.support:design:${Versions.supportDesign}"
    //Koin
    val koinViewModel = "org.koin:koin-android-viewmodel:1.0.1"

}