package com.github.fbenz.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.restdocs.JUnitRestDocumentation;

public class GitHubApiTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    private RequestSpecification documentationSpec;

    @Before
    public void setUp() {
        this.documentationSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addFilter(documentationConfiguration(restDocumentation)).build();
    }

    /**
     * This test accesses api.github.com and thus only works with an Internet connection and if api.github.com.
     * Such a test is usually avoided, but is used here to demo that any REST API could be documented with
     * Spring REST Docs.
     */
    @Test
    public void shouldReturnAllRepos() {
        given(this.documentationSpec)
                .filter(document("github/get-user",
                        preprocessResponse(prettyPrint()),
                        relaxedResponseFields(
                                fieldWithPath("name").description("Name of the user"),
                                fieldWithPath("public_repos").description("Number of public repos"))))
        .when()
                .get("/users/fbenz")
                .then()
                .statusCode(200);
    }
}
