// Root
plugins {
    id("java")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

val gid: String by project
val ver: String by project
val lombokVersion = "org.projectlombok:lombok:1.18.42"

allprojects {
    group = gid
    version = ver

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.vanniktech.maven.publish")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        // JetBrains Annotations
        // https://mvnrepository.com/artifact/org.jetbrains/annotations
        implementation("org.jetbrains:annotations:26.0.2-1")

        // Logging
        // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
        implementation("org.slf4j:slf4j-api:2.0.17")
        // SLF4J Provider (Logback)
        // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
        implementation("ch.qos.logback:logback-classic:1.5.21")

        // Lombok
        // https://mvnrepository.com/artifact/org.projectlombok/lombok
        implementation(lombokVersion)
        annotationProcessor(lombokVersion)

        // All modules JUnit Test
        // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.4")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        // https://mvnrepository.com/artifact/org.assertj/assertj-core
        testImplementation("org.assertj:assertj-core:3.27.6")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    tasks.test {
        useJUnitPlatform()
    }

    mavenPublishing {
//        publishToMavenCentral()
        signAllPublications()

        coordinates(gid, project.name, ver)

        pom {
            name = project.name
            description = "Quant teamspace regular ${project.name}"
            inceptionYear = "2025"
            url = "https://github.com/Quant-Off/quant-regular"

            licenses {
                license {
                    name = "MIT License"
                    url = "https://mit-license.org/"
                }
            }

            developers {
                developer {
                    id = "qtfelix"
                    name = "Q. T. Felix"
                    url = "https://github.com/Quant-TheodoreFelix"
                }
            }

            scm {
                url = "https://github.com/Quant-Off/quant-regular"
                connection = "scm:git:git://github.com/Quant-Off/quant-regular.git"
                developerConnection = "scm:git:ssh://git@github.com/Quant-Off/quant-regular.git"
            }
        }

        configure(com.vanniktech.maven.publish.JavaLibrary(
            sourcesJar = true,
            javadocJar = com.vanniktech.maven.publish.JavadocJar.Javadoc()
        ))
    }
}