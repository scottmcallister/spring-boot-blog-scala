# spring-boot-blog-scala

A super simple micro blog app that demonstrates how Thymeleaf templates can be used in a Spring Boot application using Scala. The app is essentially a Scala rewrite of a Spring Boot micro blog [Java app](https://github.com/scottmcallister/micro-blog-spring-boot) I made. It features an in memory H2 database for storing blog entries and supports CRUD operations. This project was built as an example project and is not intended to be deployed to a production environment.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purposes.

### Prerequisites

To run this app, you'll need to have Java, Scala, and Maven installed. You could also use the Spring Boot CLI to run the app if you'd like to.

### Installing

Clone this repository and change into the project's directory.

```
$ git clone https://github.com/scottmcallister/spring-boot-blog-scala.git
$ cd spring-boot-blog-scala
```

Build a Jar file using Maven

```
$ mvn clean install -DskipTests
```

Start a local server using the jar file you just created

```
$ java -jar target/spring-boot-blog-scala-0.0.1-SNAPSHOT.jar
```

OR you can run using the spring-boot maven plugin.

```
$ mvn spring-boot:run
```

You should see the app running on `http://localhost:8080`

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Scala](https://www.scala-lang.org/) - JVM programming language
* [Maven](https://maven.apache.org/) - Dependency Management
* [Thymeleaf](http://www.thymeleaf.org/) - Template system