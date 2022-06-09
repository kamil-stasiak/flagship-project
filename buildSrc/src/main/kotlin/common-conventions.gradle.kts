import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    val jqwik_version: String by project
    val arrow_version: String by project
    val kluent_version: String by project
    val kotlinx_coroutines_version: String by project
    val logback_version: String by project
    val sl4j_version: String by project


    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:1.9")

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinx_coroutines_version}")

    implementation("io.arrow-kt:arrow-core:${arrow_version}")
//    implementation("io.arrow-kt:arrow-optics:${arrow_version}")
//    implementation("io.arrow-kt:arrow-fx-coroutines:${arrow_version}")

    testImplementation("org.amshove.kluent:kluent:${kluent_version}")

    testImplementation("net.jqwik:jqwik:${jqwik_version}")
    testImplementation("net.jqwik:jqwik-kotlin:${jqwik_version}")
    testImplementation("org.assertj:assertj-core:3.22.0")

    implementation("ch.qos.logback:logback-classic:$logback_version")
//    implementation("org.slf4j:slf4j-api:${sl4j_version}")
//    implementation("org.slf4j:slf4j-simple:${sl4j_version}")

}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.8.2")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xcontext-receivers",
            "-Xjsr305=strict", // Required for strict interpretation of (jqwik)
            "-Xemit-jvm-type-annotations", // Required for annotations on type variables (jqwik)
        )
        jvmTarget = "11" // 1.8 or above (jqwik)
        javaParameters = true // Required to get correct parameter names in  (jqwik)
    }
}

tasks.withType<Test> {
    useJUnitPlatform {
//        includeEngines("jqwik") // (jqwik)
//        include("**/*Properties.class")
//        include("**/*Example.class")
//        include("**/*Examples.class")
//        include("org/**/*Test.class")
//        include("**/*Tests.class")
    }
}