import jdk.nashorn.internal.objects.NativeRegExp.test
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val spek_version: String by project

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
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.koin:koin-core-ext:$koin_version")
    implementation("org.koin:koin-ktor:$koin_version")
    implementation("org.koin:koin-logger-slf4j:$koin_version")
    implementation("org.koin:koin-core:$koin_version")
    testImplementation("org.koin:koin-test:$koin_version")
    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek_version")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
tasks.withType(KotlinCompile::class)
    .forEach {
        it.kotlinOptions { freeCompilerArgs = listOf("-XXLanguage:+NewInference") }
    }