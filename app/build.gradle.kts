plugins {
//    id("com.android.application")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.troncell.baidufacesdk"
    compileSdk = 34

    defaultConfig {
//        applicationId = "com.troncell.baidufacesdk"
        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

group = "com.github.wzh-gpu"
version = "1.0.0"

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".

            create<MavenPublication>("aarDeptrumSDK") {
                groupId = group.toString()
                artifactId = "deptrumsdk"
                version = version

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/deptrumSDK.aar")
                }

            }
            create<MavenPublication>("aarFaceSDK") {
                groupId = group.toString()
                artifactId = "facesdk"
                version = version

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/FaceSDK_8.1_20230216-release.aar")
                }

            }
            create<MavenPublication>("aarImiSDK") {
                groupId = group.toString()
                artifactId = "imisdk"
                version = version

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/ImiSDK.aar")
                }

            }
            create<MavenPublication>("aarOpenCv") {
                groupId = group.toString()
                artifactId = "opencv"
                version = version

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/opencv.aar")
                }

            }
            create<MavenPublication>("aarOrbbecModule") {
                groupId = group.toString()
                artifactId = "orbbec"
                version = version

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/orbbec_module-debug.aar")
                }

            }

        }

    }
}