plugins {
    id("library-conventions")
}

dependencies {
    val ktor_version: String by project
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
}