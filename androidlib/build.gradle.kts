plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
//    signing
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
//    implementation(project(mapOf("path" to ":javalib")))
    implementation(project(":javalib"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

publishing {
    publications {
        create<MavenPublication>("aar") {
//            artifactId = "androidlib"
            artifact("$buildDir/outputs/aar/${project.name}-release.aar")
        }
    }
}

afterEvaluate {
    val publishToMavenLocal by tasks.getting
    val assembleRelease by tasks.getting

    publishToMavenLocal.dependsOn(assembleRelease)
}

//signing {
//    sign(publishing.publications["mavenJava"])
//}

//tasks.javadoc {
//    if (JavaVersion.current().isJava9Compatible) {
//        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
//    }
//}
