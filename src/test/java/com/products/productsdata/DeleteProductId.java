package com.products.productsdata;

import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteProductId extends TestBase {

    @Test
    public void delete() {
        Response response = given()
                .basePath("/products")
                .pathParam("id","333179") //9999712  185267
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }
}
