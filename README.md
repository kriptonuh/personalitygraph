# Personality-Graph

This application created to allow people better understand themselves and have ability to compare their personalities with other people.
Currently project is on Draft stage.

## Used technologies:
* Kotlin
* Gradle
* Koin (DI)
* Spek (BDD tests)
* Ktor (Web interface)
* Neo4j(Graph database)

## DataBase structure:
![DB_STRUCTURE](personality/src/main/resources/mediacontent/dbstructure.png?raw=true "DB structure")

## Local setup:
### Pre-requirements:
* [Gradle](https://gradle.org)
* [Java 8+](https://www.oracle.com/ru/java/technologies/javase/javase-jdk8-downloads.html)
* [Neo4j](https://neo4j.com/download/)
### Project setup:
* Update/create *resources/ogm.properties* with neo4j access params:
``` properties
URI=bolt://localhost
username={your_user}
password={your_password}
```
* Start application:
``` bash
./gradlew run
```
* Now after application started you can update DB with initial dummy items. There are two ways to do it:
    * go to http://0.0.0.0:8080/init - dummy data will be applied automatically
    * you can do the same manually with cypher script in resources/dbupdates/init-personality.cypher