group = "com.example.referralstore"
version = "1.0-SNAPSHOT"

plugins {
    java
    id("org.springframework.boot") version "2.6.3"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.6.3"
val lombokVersion = "1.18.22"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("mysql:mysql-connector-java:8.0.25")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}