package com.products.productsdata;

import com.products.model.ProductsPojo;
import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateData extends TestBase {

    @Test
    public void CreateNewData()
    {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Dyson");
        productsPojo.setType("Vaccum");
        productsPojo.setPrice(9.8f);
        productsPojo.setUpc("041333436757");
        productsPojo.setShipping(567);
        productsPojo.setDescription("Power Preserve technology");
        productsPojo.setManufacturer("dyson");
        productsPojo.setModel("MN1300R4Z");

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productsPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }



}
