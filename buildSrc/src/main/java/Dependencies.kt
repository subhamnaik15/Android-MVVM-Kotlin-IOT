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
}

object AppDeps {

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinLib}"
    val appCompat =  "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material =  "com.google.android.material:material:${Versions.materialComponents}"
    val coordinateLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.recyclerView}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    val httpLodgging = "com.squareup.okhttp3:logging-interceptor:${Versions.httpLogging}"
    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    val androidCharts = "com.github.PhilJay:MPAndroidChart:${Versions.charts}"

}