import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project

plugins {
    application
    kotlin("jvm") version "1.4.10"
}

group = "io.personalitygraph"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    //maven { url = uri("https://dl.bintray.com/kodein-framework/Kodein-DI") }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("org.neo4j:neo4j-ogm-core:3.2.21")
    implementation("org.neo4j:neo4j-ogm-bolt-driver:3.2.21")
    //implementation("org.kodein.di:kodein-di-generic-jvm:5.2.0")
    //implementation("org.kodein.di:kodein-di-framework-ktor-server-jvm:6.2.0")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.koin:koin-core-ext:$koin_version")
    implementation ("org.koin:koin-ktor:$koin_version")
    implementation ("org.koin:koin-logger-slf4j:$koin_version")
    //implementation("dev.misfitlabs.kotlinguice4:kotlin-guice:1.4.1")
    implementation("org.koin:koin-core:$koin_version")
    testImplementation("org.koin:koin-test:$koin_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}