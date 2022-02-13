# Multi-JVM Library

Experiment to configure a Gradle multi-project setup containing Java and Android
library subprojects, each producing artifacts (`.jar` and `.aar`, respectively)
where the Android library depends on the Java library.

## 📦 Artifacts

Running `./gradlew publishToMavenLocal` produces the following file tree:

```text
~/.m2/repository/at
└── phatbl
    └── multijvm
        ├── androidlib
        │   ├── 0.1
        │   │   ├── androidlib-0.1.aar
        │   │   └── androidlib-0.1.pom
        │   └── maven-metadata-local.xml
        └── javalib
            ├── 0.1
            │   ├── javalib-0.1-javadoc.jar
            │   ├── javalib-0.1-sources.jar
            │   ├── javalib-0.1.jar
            │   ├── javalib-0.1.module
            │   └── javalib-0.1.pom
            └── maven-metadata-local.xml
```

## 📄 License

This repo is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for rights and limitations.
