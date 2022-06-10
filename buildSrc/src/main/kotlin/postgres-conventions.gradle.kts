
plugins {
    id("test-containers-conventions")
}

dependencies {
    val test_containers_version: String by project
    testImplementation("org.testcontainers:postgresql:${test_containers_version}")
    val postgres_version: String by project
    implementation("org.postgresql:postgresql:${postgres_version}")

    val sqdelight_version: String by project
    implementation("com.squareup.sqldelight:jdbc-driver:${sqdelight_version}")
    implementation("com.squareup.sqldelight:sqlite-driver:${sqdelight_version}")
    implementation("com.squareup.sqldelight:gradle-plugin:${sqdelight_version}")

    val hikari_version: String by project
    implementation("com.zaxxer:HikariCP:${hikari_version}")
}