plugins {
    id("library-conventions")
    id("postgres-conventions")
    id("com.squareup.sqldelight") version "1.5.3"
}

dependencies {
    api(project(":deployment-unit:user-module:domain"))
}

sqldelight {
    database("ExampleDatabase") {
        packageName = "com.example.db"
        sourceFolders = listOf("sqldelight")
//        dependency project(':OtherProject')
//        deriveSchemaFromMigrations = true
//        migrationOutputDirectory = file("$buildDir/resources/main/migrations")
//        migrationOutputFileFormat = ".sql"
    }
}