/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("me.stasiak.flagship.kotlin-library-conventions")
    id("me.stasiak.flagship.kotlin-postgres-conventions")
}

dependencies {
    api(project(":deployment-unit:example-module:domain"))
}
