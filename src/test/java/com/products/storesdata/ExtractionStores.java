package com.products.storesdata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.codehaus.groovy.util.ListHashMap;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionStores {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port=3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    //1. Extract the limit
    @Test
    public void test001() {

        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+limit);
        System.out.println("------------------End of Test---------------------------");

    }
    //2. Extract the total
    @Test
    public void test002() {

        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : "+total);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {

        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name is : "+name);
        System.out.println("------------------End of Test---------------------------");

    }
    //4. Extract the names of all the store

    @Test
    public void test004() {

        List<String> nameofstore = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all name are : "+nameofstore);
        System.out.println("------------------End of Test---------------------------");

    }
    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<Integer> numofId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all Ids are : "+numofId);
        System.out.println("------------------End of Test---------------------------");


    }
    //6. Print the size of the data list
    @Test
    public void test006() {

        List<Integer> datasize = response.extract().path("data");
        //int sizes = datasize.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all size are : "+datasize);
        System.out.println("------------------End of Test---------------------------");


    }
    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {

        List<HashMap<String,?>> Storename =  response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product name st cloud list are : "+Storename);
        System.out.println("------------------End of Test---------------------------");

    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {

        List<String> Storeaddress =  response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of store address are : "+Storeaddress);
        System.out.println("------------------End of Test---------------------------");

    }
    //9. Get all the services of 8th store
    @Test
    public void test009(){
        List<HashMap<String,Object>> serviceid = response.extract().path("data[7].services");
        /*System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of 8th store is :");
        for (HashMap<String,Object> services : serviceid)
        {
            System.out.println(services);
        }*/
        System.out.println("Get all the Service of 8th Store : "+serviceid);

        System.out.println("------------------End of Test---------------------------");

    }

    //10. Get storeservices of the store where service name = Windows Store

    @Test
    public void Servicename()
    {
        List<HashMap<String,?>> service =response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");
        System.out.println("Storeservices is :"+service);
    }

    //11. Get all the storeId of all the store
    @Test
    public void GetStoreid()
    {
        List<HashMap<String,Object>> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get All the store Id "+storeId);

    }

    //12. Get id of all the store
    @Test
    public void GetAllIdStore()
    {
        List<HashMap<String,Object>> Allidstore = response.extract().path("data.id");
        System.out.println("Get all the id of store :"+Allidstore);
    }
    //13. Find the store names Where state = MN
    @Test
    public void Findstate()
    {
        List<String> findState = response.extract().path("data.findAll{it.state=='MN'}.name");
        System.out.println("Find the store name :"+findState);
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void FindNumberOfServices()
    {
        List<String> findServices = response.extract().path("data.findAll{it.name=='Rochester'}");
        System.out.println("Find total number of services :"+findServices);
        int total = response.extract().path("data[0].services.size");
        System.out.println("total number of services :"+total);
    }
    //15. Find the createdAt for all services whose name = “Windows Store”

    @Test
    public void findCreateAt()
    {
        List<HashMap<String,Object>> findcreateAt = response.extract().path("data.services[5].createdAt");
        System.out.println("Find the createAt for all services :"+findcreateAt);
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void findAllServices()
    {
        List<HashMap<String,Object>> findAllService = response.extract().path("data.findAll{it.name=='Sioux Falls'}.services");
        System.out.println("Find the createAt for all services :"+findAllService);
    }
    //17. Find the zip of all the store
    @Test
    public void findZipAllStore() {

        List<Integer> findZip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("find zip of all store : "+findZip);
        System.out.println("------------------End of Test---------------------------");


    }
    //18. Find the zip of store name = Maplewood (Roseville)
    @Test
    public void findZipOfStoreRoseville()
    {
        List<Integer> findzipstore = response.extract().path("data.findAll{it.name=='Maplewood'}.zip");
        System.out.println("Find the zip of store name :"+findzipstore);
    }
    //19. Find the storeservices details of the service name = Geek Squad Services (Magnolia Home Theater)
    @Test
    public void findStoreServices()
    {
        List<HashMap<String,?>> findServices = response.extract().path("data.findAll{it.name=='Geek Squad Services'}.services");
        System.out.println("Find the store services details :"+findServices);
    }
    //20. Find the lat of all the stores
    @Test
    public void findLat() {

        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("find lat of all the stores : "+lat);
        System.out.println("------------------End of Test---------------------------");


    }

}
