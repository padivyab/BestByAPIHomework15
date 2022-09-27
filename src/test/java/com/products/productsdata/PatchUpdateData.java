package com.products.productsdata;

import com.products.model.ProductsPojo;
import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUpdateData extends TestBase {

    @Test
    public void UpdateProductData()
    {
        ProductsPojo productsPojo =new ProductsPojo();
        productsPojo.setName("Dyson");
        productsPojo.setType("Blower");
        productsPojo.setPrice(4.6f);

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .pathParam("id","9999712")
                .body(productsPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    /*{
    "id": 9999712,
    "name": "Dyson",
    "type": "Vaccum",
    "price": 9.8,
    "upc": "041333436757",
    "shipping": 567,
    "description": "Power Preserve technology",
    "manufacturer": "dyson",
    "model": "MN1300R4Z",
    "updatedAt": "2022-09-26T17:32:47.187Z",
    "createdAt": "2022-09-26T17:32:47.187Z"
}
*/
}
