plugins {
    id("me.stasiak.flagship.kotlin-common-conventions")
}

dependencies {
    val testContainersVersion = "1.17.2"
    testImplementation("org.testcontainers:testcontainers:${testContainersVersion}")
    testImplementation("org.testcontainers:junit-jupiter:${testContainersVersion}")
}