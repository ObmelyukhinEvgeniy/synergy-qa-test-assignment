package api_1;

import io.restassured.http.ContentType;
import java.util.List;
import static io.restassured.RestAssured.given;

public class Test {
    private final static String URL = "https://reqres.in";
    @org.junit.jupiter.api.Test
    public void checkCode200Test() {
        List<PojoClassBaseData> user = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getList("", PojoClassBaseData.class);
                //.statusCode(200);
                int i = 0;
    }
}
