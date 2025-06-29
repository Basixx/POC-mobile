package org.mobile.domain.operations;

import io.restassured.RestAssured;

public class ClientOperations extends Operations {

    public void callService1() {
        System.out.println(service1());
        RestAssured.given()
                .baseUri(service1())
                .get()
                .then()
                .statusCode(200);
    }

    public void callService2() {
        System.out.println(service2());
        RestAssured.given()
                .baseUri(service2())
                .get()
                .then()
                .statusCode(200);
    }

}
