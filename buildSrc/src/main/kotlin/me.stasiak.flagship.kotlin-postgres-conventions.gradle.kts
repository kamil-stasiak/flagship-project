plugins {
    id("me.stasiak.flagship.kotlin-test-containers-conventions")
}

dependencies {
    // todo extract testContainers version
    testImplementation("org.testcontainers:postgresql:1.17.2")
    implementation("org.postgresql:postgresql:42.2.5")
}