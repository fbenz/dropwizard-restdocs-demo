package com.github.fbenz.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import com.github.fbenz.RestdocsDemoApplication;
import com.github.fbenz.RestdocsDemoConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.restdocs.JUnitRestDocumentation;

public class BookResourceTest {

    @ClassRule
    public static final DropwizardAppRule<RestdocsDemoConfiguration> RULE =
            new DropwizardAppRule<>(RestdocsDemoApplication.class);

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    private RequestSpecification documentationSpec;

    @Before
    public void setUp() {
        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation)).build();
    }

    @Test
    public void shouldReturnAllBooks() {
        given(this.documentationSpec)
                .filter(document("books/get-all-books", responseFields(
                        fieldWithPath("[].id").description("Unique ID"),
                        fieldWithPath("[].title").description("Title of the book"),
                        fieldWithPath("[].pages").description("Number of pages"))))
        .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body("$", hasSize(1));
    }

    @Test
    public void shouldAddAnItem() {
        given(this.documentationSpec)
                .filter(document("books/add-a-book", requestFields(
                        fieldWithPath("title").description("Title of the book"),
                        fieldWithPath("pages").description("Number of pages"))))
                .contentType(ContentType.JSON)
                .body("{\"title\": \"The Pillars of the Earth\", \"pages\": 720}")
        .when()
                .post("/books")
                .then()
                .statusCode(204);
    }
}
