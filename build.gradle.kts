plugins {
    application
    jacoco

}


application {
    mainClass.set("Main")
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}





tasks.test {
    // use JUnit Platform for unit tests.`
   useJUnitPlatform()
   // run jacoco and generate report after tests are run
   finalizedBy(tasks.jacocoTestReport)
}



jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}


