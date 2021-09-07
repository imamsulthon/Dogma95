plugins {
    id("com.android.application")
    id("kotlin-android")
}

importCommonPlugins()
configAndroid()
importCommonDependencies()

android {
    defaultConfig {
        applicationId = Versions.App.id

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
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
    implementation(Dependencies.Epoxy.core)
    implementation(Dependencies.Epoxy.paging)
    implementation(Dependencies.Epoxy.databinding)
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.preference:preference:1.1.1")
    "kapt"(Dependencies.Epoxy.processor)

    implementation(Dependencies.Glide.core)
    "kapt"(Dependencies.Glide.compiler)

    implementation(Dependencies.Dagger.daggerHilt)
    implementation(Dependencies.Dagger.legacy)
    "kapt"(Dependencies.Dagger.hiltAndroidCompiler)
    implementation(Dependencies.Dagger.hiltLifeCycle)
    "kapt"(Dependencies.Dagger.hiltCompiler)
    implementation(Dependencies.Dagger.fragment)
    implementation(Dependencies.Dagger.activity)

    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.rxjava2)
    "kapt"(Dependencies.Room.annotation)

    implementation(Dependencies.androidBase)

    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.gsonConverter)
    implementation(Dependencies.Retrofit.rxJavaAdapter)

    implementation(Dependencies.Tools.chucker)

    debugImplementation(Dependencies.sherlock) {
        isTransitive = true
    }
    releaseImplementation(Dependencies.sherlock)

}
