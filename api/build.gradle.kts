import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("java")
    id("org.openapi.generator") version "7.12.0"
}

group = "com.github.tirnak"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Openapi generated code server dependencies
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("org.springdoc:springdoc-openapi-ui:1.8.0")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")

    // Openapi generated code client dependencies
    implementation("io.github.openfeign:feign-core:13.6")
    implementation("io.github.openfeign:feign-jackson:13.6")
    implementation("io.github.openfeign:feign-okhttp:13.6")
    implementation("io.github.openfeign:feign-slf4j:13.6")
    implementation("io.github.openfeign.form:feign-form:3.8.0")

}

openApiGenerate {
    description = "Generates OpenAPI Spring controller code"

    generatorName.set("spring")
    inputSpec.set("${project.projectDir}/specs/openapi.yaml")
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

tasks.register<GenerateTask>("openApiGenerateClient") {
    group = "openapi tools"
    description = "Generates OpenAPI feign client code"

    generatorName.set("java")
    inputSpec.set("${project.projectDir}/specs/openapi.yaml")
    outputDir.set("${layout.buildDirectory.get()}/generated")
    apiPackage.set("${project.group}.generated.client.api")
    invokerPackage.set("${project.group}.generated.client.invoker")
    modelPackage.set("${project.group}.generated.client.model")
    modelNameSuffix = "ClientDto"
    apiNameSuffix = "Client"
    configOptions.put("library", "feign")
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
    dependsOn("openApiGenerate", "openApiGenerateClient")
}
