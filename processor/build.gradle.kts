// Module: processor
plugins {
    `java-library`
    id("com.vanniktech.maven.publish")
}

var googleService = "com.google.auto.service:auto-service:1.1.1"

dependencies {
    implementation(project(":annotations"))

    // https://mvnrepository.com/artifact/com.google.auto.service/auto-service
    compileOnly(googleService)
    annotationProcessor(googleService)

    // https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api
    compileOnly("jakarta.annotation:jakarta.annotation-api:3.0.0")
}