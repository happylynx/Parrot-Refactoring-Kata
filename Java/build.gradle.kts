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