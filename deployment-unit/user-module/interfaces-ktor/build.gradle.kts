plugins {
    id("ktor-conventions")
    kotlin("plugin.serialization") version "1.6.21"
}

dependencies {
    api(project(":deployment-unit:common:ktor"))
    api(project(":deployment-unit:common:errors"))
    api(project(":deployment-unit:user-module:application"))
}
