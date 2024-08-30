import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    application
    `maven-publish`
    `java-library`
}

val versionKotest = "5.7.2"

group = "com.github.muguliebe"
version = "0.4.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("org.slf4j:slf4j-api:2.0.9")
    api("org.apache.commons:commons-lang3:3.13.0")

    // test
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.kotest:kotest-runner-junit5:$versionKotest")
    testImplementation("io.kotest:kotest-assertions-core:$versionKotest")
    testImplementation("io.kotest:kotest-property:$versionKotest")
    testImplementation("io.kotest:kotest-framework-datatest:$versionKotest")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
}

sourceSets {
    getByName("main") {
        java.srcDir("src/main/kotlin")
        resources.srcDir("src/main/resources")
    }
}

tasks.jar {
    enabled = true
}

publishing {
    publications {
        create<MavenPublication>("zfwk-utils") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = rootProject.name
            version = project.version.toString()
        }
    }
    repositories {
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.withType<ProcessResources>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.test {
    useJUnitPlatform()
}
