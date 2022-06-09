plugins {
    id("common-conventions")
}

dependencies {
    val test_containers_version: String by project
    testImplementation("org.testcontainers:testcontainers:${test_containers_version}")
    testImplementation("org.testcontainers:junit-jupiter:${test_containers_version}")
}