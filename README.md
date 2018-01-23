# Dropwizard Spring REST Docs Demo

Sample application demonstrating how to use [Spring REST Docs](https://projects.spring.io/spring-restdocs/)
with non-Spring projects like [Dropwizard](http://www.dropwizard.io).
This is possible with REST Assured and it can even be used to document external REST APIs.
Just because it is possible, it does not mean that it's a good idea.
Therefore, advantages and disadvantages are listed below.

This project was created with
```bash
$ mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.2.2
```
and afterwards Spring REST Docs was added with a minimal configuration.

## Spring REST Docs in a non-Spring project

Advantages
* Beautiful and accurate documentation
* Can be generated and bundled with the project

Disadvantages
* A HTTP server has to be booted up and thus an integration test has to be used.
This can be avoided in a Spring project (e.g. when using Web MVC).
* Spring framework as a test dependency

## Spring REST Docs for an external REST API

Advantages
* Beautiful and accurate documentation

Disadvantages
* Separate project for the documentation
* It does not matter that the documentation is done in a test, because the tests are not part of the API project
