package com.rest.TM.Sandbox;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TM_test {


    @Test (priority = 1)
    public void Name_Test()
    {
        String name =  given().
                baseUri("https://api.tmsandbox.co.nz").
                when().
                get("/v1/Categories/6327/Details.json?catalogue=false").
                then().
                body("Name", equalTo("Carbon credits")).
                extract().
                response().path("Name") ;


        System.out.println("Name: = " + name);
        Assert.assertEquals(name,"Carbon credits");
   }

    @Test (priority = 2)
    public void CanRelist_Test()
    {
        boolean can_relist =  given().
                baseUri("https://api.tmsandbox.co.nz").
                when().
                get("/v1/Categories/6327/Details.json?catalogue=false").
                then().
                 body("CanRelist", equalTo(true) ).
                extract().
                response().path("CanRelist") ;


        System.out.println("CanRelist: = " + can_relist);
        Assert.assertEquals(can_relist,true);

    }

    @Test (priority = 3)
    public void Description_Test()
    {
        String Description_text =  given().
                baseUri("https://api.tmsandbox.co.nz").
                when().
                get("/v1/Categories/6327/Details.json?catalogue=false").
                then().
//                body("Promotions[1].Description", equalTo("2x larger image") ).
                extract().
                response().path("Promotions[1].Description") ;


        System.out.println("Description_text: = " + Description_text);
        Assert.assertEquals(Description_text,"2x larger image");

    }


}
