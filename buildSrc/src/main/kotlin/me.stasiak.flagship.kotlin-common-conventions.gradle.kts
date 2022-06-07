import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
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

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    val arrowVersion = "1.1.3-alpha.7"
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
//    implementation("io.arrow-kt:arrow-optics:$arrowVersion")
//    implementation("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")

    testImplementation("org.amshove.kluent:kluent:1.68")

    val jqwikVersion = "1.6.5"
    testImplementation("net.jqwik:jqwik:${jqwikVersion}")
    testImplementation("net.jqwik:jqwik-kotlin:${jqwikVersion}")
    testImplementation("org.assertj:assertj-core:3.22.0")

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
        includeEngines("jqwik") // (jqwik)
    }
}