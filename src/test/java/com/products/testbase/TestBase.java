package com.products.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        //RestAssured.basePath="/products"; //product hoy to aa na aave direct testbase ma get ma

    }
}
