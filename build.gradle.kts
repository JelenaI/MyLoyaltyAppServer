import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val koin_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kmongo_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.0"
}

group = "com.jelenai"
version = "0.0.1"
application {
    mainClass.set("com.jelenai.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("io.ktor:ktor-server-html-builder:$ktor_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")

    // KMongo
    implementation("org.litote.kmongo:kmongo:$kmongo_version")
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongo_version")

    // Koin core features
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.insert-koin:koin-logger-slf4j:$koin_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}