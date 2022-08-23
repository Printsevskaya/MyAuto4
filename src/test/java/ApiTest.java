import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

@Test
public void testGet(){
    Response response1 =
            given()
                    .log().all()
                    .when()
                    .get("http://httpbin.org/get?a=1")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("headers.Connection", equalTo("close"))
                    .body("args.a", equalTo("1"))
                    .extract()
                    .response();
    response1.getBody().print();
}



}
