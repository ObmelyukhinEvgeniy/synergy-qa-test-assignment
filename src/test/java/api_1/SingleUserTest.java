package api_1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class SingleUserTest {
    @Test(description = "Check 200 OK", priority = 0)
    public void getUserSingleOK200Test() {
        Specifications.installSpecification(Specifications.requestSpecification("https://reqres.in"), Specifications.responseSpecificationOK200());
            given()
                    .spec(Specifications.requestSpecification("https://reqres.in"))
            .when()
                    .get("/api/users/2")
            .then()
                    .spec(Specifications.responseSpecificationOK200())
                    .assertThat()
                    .body("data.id", equalTo(2));

//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
    }
    @Test(description = "Check 404 Not Found", priority = 1)
    public void getUserSingleError404Test() {
        //Specifications.installSpecification(Specifications.requestSpecification("https://reqres.in"), Specifications.responseSpecificationError404());
        given()
                .spec(Specifications.requestSpecification("https://reqres.in"))
        .when()
                .get("/api/users/9999")
        .then()
                .spec(Specifications.responseSpecificationError404());
    }

    /*
    @Test
    public void checkCode200Test() {
        PojoClassBaseData user = RestAssured
                .given()
                    .baseUri("https://reqres.in")
                    .log().all()
                .when()
                    .contentType(ContentType.JSON)
                    .get("/api/users/2")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response().as(PojoClassBaseData.class);
    }
    */

}
