import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate

object Dependencies {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val androidBase = "com.github.enginebai:AndroidBase:${Versions.androidBase}"

    const val sherlock = "com.github.ajitsing:sherlock:1.0.4@aar"

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ArchitectureComponents.lifecycle}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val runner = "androidx.test:runner:${Versions.testRunner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Dagger{
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.Dagger.hilt}"
        const val legacy = "androidx.legacy:legacy-support-v4:${Versions.Dagger.legacy}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Dagger.hilt}"
        const val hiltLifeCycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.Dagger.lifecycle}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Dagger.lifecycle}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.Dagger.fragment}"
        const val activity = "androidx.activity:activity-ktx:${Versions.Dagger.activity}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    }

    object Logging {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
        const val logger = "com.orhanobut:logger:${Versions.logger}"
    }

    object Epoxy {
        const val core = "com.airbnb.android:epoxy:${Versions.epoxy}"
        const val processor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
        const val databinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
        const val paging = "com.airbnb.android:epoxy-paging:${Versions.epoxy}"
    }

    object Paging {
        const val runtime =
            "androidx.paging:paging-runtime:${Versions.ArchitectureComponents.paging}"
        const val rxJava2 =
            "androidx.paging:paging-rxjava2:${Versions.ArchitectureComponents.paging}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.ArchitectureComponents.room}"
        const val annotation = "androidx.room:room-compiler:${Versions.ArchitectureComponents.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.ArchitectureComponents.room}"
        const val rxjava2 = "androidx.room:room-rxjava2:${Versions.ArchitectureComponents.room}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val runtime =
            "androidx.paging:paging-runtime:${Versions.ArchitectureComponents.paging}"
        const val rxJava2 =
            "androidx.paging:paging-rxjava2:${Versions.ArchitectureComponents.paging}"
    }

    object Tools {
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    }
}

fun Project.importCommonPlugins() {
    plugins.apply("kotlin-android")
    plugins.apply("kotlin-android-extensions")
    plugins.apply("kotlin-kapt")
    plugins.apply("dagger.hilt.android.plugin")
}

// apply common plugin
fun Project.importCommonDependencies() {
    dependencies {

        // The two following syntax is applicable
        // source: https://github.com/gradle/kotlin-dsl-samples/issues/843
        "implementation"(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        "implementation"(Dependencies.Kotlin.stdLib)

        "implementation"(Dependencies.rxJava)
        "implementation"(Dependencies.rxAndroid)

        val implementation by configurations
        val testImplementation by configurations
        val androidTestImplementation by configurations

        implementation(Dependencies.AndroidX.appCompat)
        implementation(Dependencies.AndroidX.coreKtx)
        implementation(Dependencies.AndroidX.constraintLayout)
        implementation(Dependencies.material)

        implementation(Dependencies.Logging.logger)
        implementation(Dependencies.Logging.timber)

        implementation(Dependencies.Retrofit.core)
        implementation(Dependencies.okhttp)
        implementation(Dependencies.gson)

        implementation(Dependencies.Paging.runtime)
        implementation(Dependencies.Paging.rxJava2)

        testImplementation(Dependencies.Test.junit)
        androidTestImplementation(Dependencies.Test.runner)
        androidTestImplementation(Dependencies.Test.espressoCore)
    }
}