plugins {
    id("java")
}

group = "com.frappu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Make java decent at least
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

    // Javalin
    implementation("io.javalin:javalin:5.4.2")

    // Dependency Injection
    implementation("com.google.inject:guice:5.1.0")

    // JSON Serialization/Deserialization
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")


    // Logging
    implementation("org.slf4j:slf4j-api:2.0.6")
    implementation("org.slf4j:slf4j-simple:2.0.6")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")

    // Persistence
    implementation("com.h2database:h2:2.1.214")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.1.7.Final")
    implementation("org.hibernate.common:hibernate-commons-annotations:6.0.6.Final")

    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.reflections:reflections:0.10.2")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}