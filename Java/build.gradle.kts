import java.net.URI

// Apply the java plugin to add support for Java
plugins {
    id("java")
}

group = "org.codingdojo"
version = "1.0-snapshot"


// In this section you declare where to find the dependencies of your project
repositories {
    // Use maven central for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "8.0.1"
}

setProxy()

fun setProxy() {
    System.getenv("http_proxy").apply {
        if (isNullOrBlank()) {
            return
        }
        val uri = URI.create(this)
        System.setProperty("http.proxyHost", uri.host)
        System.setProperty("http.proxyPort", uri.port.toString())
    }
    System.getenv("https_proxy").apply {
        if (isNullOrBlank()) {
            return
        }
        val uri = URI.create(this)
        System.setProperty("https.proxyHost", uri.host)
        System.setProperty("https.proxyPort", uri.port.toString())
    }
    System.getenv("no_proxy").apply {
        if (isNullOrBlank()) {
            return
        }
        val nonProxyHosts = this.splitToSequence(",")
            .map {
                if (!it.startsWith('.')) {
                    return@map it
                }
                return@map "*$it"
            }.joinToString("|")
        System.setProperty("http.nonProxyHosts", nonProxyHosts)
        System.setProperty("https.nonProxyHosts", nonProxyHosts)
    }
    println("proxy set")
}