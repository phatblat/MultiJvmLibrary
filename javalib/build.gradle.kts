plugins {
    `java-library`
    kotlin("jvm")
    `maven-publish`
//    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("jar") {
            from(components["java"])
            afterEvaluate {
                artifactId = tasks.jar.get().archiveBaseName.get()
            }
        }
    }
}

//signing {
//    sign(publishing.publications["mavenJava"])
//}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
