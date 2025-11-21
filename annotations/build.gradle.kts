var gid: String by extra
var ver: String by extra

mavenPublishing {
    coordinates(gid,
        "processor",
        ver)

    pom {
        name.set("quant-regular-annotations")
        description.set("Quant regular annotations")
        inceptionYear.set("2025")
        url.set("https://github.com/Quant-Off/quant-regular/")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://mit-license.org/")
                distribution.set("https://mit-license.org/")
            }
        }
        developers {
            developer {
                id.set("username")
                name.set("Q. T. Felix")
                url.set("https://github.com/Quant-TheodoreFelix/")
            }
        }
        scm {
            url.set("https://github.com/Quant-Off/quant-regular/")
            connection.set("scm:git:git://github.com/Quant-Off/quant-regular.git")
            developerConnection.set("scm:git:ssh://git@github.com/Quant-Off/quant-regular.git")
        }
    }
}

dependencies {
}