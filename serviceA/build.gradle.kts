plugins {
    id("java")
    id("org.openapi.generator") version "7.12.0"
}

group = "com.github.tirnak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val springBootVersion = "3.5.3"

dependencies {
    implementation("org.springframework.boot:spring-boot:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

    // Code generators
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    implementation("org.mapstruct:mapstruct:1.6.3")

    // Openapi generated code dependencies
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("org.springdoc:springdoc-openapi-ui:1.8.0")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")

    // persistence
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.postgresql:postgresql:42.7.3")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")

    testImplementation("org.testcontainers:postgresql:1.19.7")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

tasks.test {
    useJUnitPlatform()
}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("${project.projectDir}/specs/service-a-openapi.yaml")
    outputDir.set("${layout.buildDirectory.get()}/generated")
    apiPackage.set("$group.generated.api")
    invokerPackage.set("$group.generated.invoker")
    modelPackage.set("$group.generated.model")
    modelNameSuffix = "Dto"
    configOptions.put("dateLibrary", "java8")
    configOptions.put("useJakartaEe", "true")
    configOptions.put("interfaceOnly", "true")
    configOptions.put("useResponseEntity", "false")
}

sourceSets {
    main {
        java {
            srcDir("${layout.buildDirectory.get()}/generated/src/main/java")
        }
    }
}

tasks.named("compileJava") {
    dependsOn("openApiGenerate")
}