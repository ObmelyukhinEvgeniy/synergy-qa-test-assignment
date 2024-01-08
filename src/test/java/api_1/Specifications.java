package api_1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class Specifications {
    public static RequestSpecification requestSpecification(String baseURL) {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecificationOK200() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecificationAssert() {
        return new ResponseSpecBuilder()
                .expectBody("data.id", Matchers.equalTo(2))
                .expectBody("data.email", Matchers.equalTo("janet.weaver@reqres.in"))
                .expectBody("data.first_name", Matchers.equalTo("Janet"))
                .expectBody("data.last_name", Matchers.equalTo("Weaver"))
                .expectBody("data.avatar", Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"))
                .build();
    }

    public static ResponseSpecification responseSpecificationError404() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
