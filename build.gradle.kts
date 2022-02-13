plugins {
    base
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    kotlin("android") version "1.6.10" apply false
    kotlin("jvm") version "1.6.10" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

nexusPublishing {
    repositories {
        sonatype {
            val releasesRepoUrl = layout.buildDirectory.dir("repos/releases")
            val snapshotsRepoUrl = layout.buildDirectory.dir("repos/snapshots")
            nexusUrl.set(uri(releasesRepoUrl))
            snapshotRepositoryUrl.set(uri(snapshotsRepoUrl))
        }
    }
}
