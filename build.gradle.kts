plugins {
    id("java")
}

group = "com.github.tirnak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val springBootVersion = "3.5.3"

dependencies {
    implementation("org.springframework.boot:spring-boot:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")

    // Code generators
    implementation("org.projectlombok:lombok:1.18.38")
    implementation("org.mapstruct:mapstruct:1.6.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

tasks.test {
    useJUnitPlatform()
}