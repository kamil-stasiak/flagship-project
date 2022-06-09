
plugins {
    id("test-containers-conventions")
}

dependencies {
    // todo extract testContainers version
    val test_containers_version: String by project
    val postgres_version: String by project

    testImplementation("org.testcontainers:postgresql:${test_containers_version}")
    implementation("org.postgresql:postgresql:${postgres_version}")
}