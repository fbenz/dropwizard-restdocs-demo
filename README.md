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

See the [BookResourceTest](https://github.com/fbenz/dropwizard-restdocs-demo/blob/master/src/test/java/com/github/fbenz/resources/BookResourceTest.java)
for an example of such a test.

Advantages
* Beautiful and accurate documentation
* Can be generated and bundled with the project

Disadvantages
* A HTTP server has to be booted up and thus an integration test has to be used.
This can be avoided in a Spring project (e.g. when using Web MVC).
* Spring framework as a test dependency

For projects using Jersey, [restdocsext-jersey](https://github.com/RESTDocsEXT/restdocsext-jersey) can be used as an alternative.
The Jersey Test Framework allows to write more lightweight tests.

## Spring REST Docs for an external REST API

See the [GitHubApiTest](https://github.com/fbenz/dropwizard-restdocs-demo/blob/master/src/test/java/com/github/fbenz/resources/GitHubApiTest.java)
for an example of such a test.

Advantages
* Beautiful and accurate documentation

Disadvantages
* Separate project for the documentation
* It does not matter that the documentation is done in a test, because the tests are not part of the API project

## API documentation result

The API documentation can be generated with `mvn package`.
It can also be
[viewed here](https://htmlpreview.github.io/?https://github.com/fbenz/dropwizard-restdocs-demo/blob/master/generated-documentation.html).
