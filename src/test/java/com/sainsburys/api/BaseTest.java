package com.sainsburys.api;

import com.sainsburys.utils.LoadProperties;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class BaseTest {
  private Headers headers;
  private LoadProperties properties;

  public Headers setHeadersForAPI() {
    headers = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("pianoCard", "9826300010292317018"),
            new Header("pianoExternalHandle", "184e5d64-1b9a-4ada-a2c3-ac49253f7c10"),
            new Header("pianoWalletId", "128956750")
    );
    return headers;
  }

  public Response performGet() {
//    RestAssured.authentication = basic("foo", "bar");
//    RestAssured.baseURI = "http://localhost:9999/nectar-shared-offers-api/offers";
//    RestAssured.useRelaxedHTTPSValidation();
//    return given().headers(setHeadersForAPI()).when().log().all().get();
     useRelaxedHTTPSValidation();
    return given().headers(setHeadersForAPI())
            .when().log().all().get("http://localhost:9999/nectar-shared-offers-api/offers");
  }

//  public Response performGet() {
//    return given()
//            .contentType("application/json")
//            .baseUri(properties.getProperty("BASE_URL"))
//            .basePath(properties.getProperty("ENDPOINT_SHARED_OFFERS"))
//            .headers(setHeadersForAPI())
//            .get();
//  }
}
