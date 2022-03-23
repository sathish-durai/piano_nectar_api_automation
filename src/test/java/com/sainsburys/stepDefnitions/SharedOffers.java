package com.sainsburys.stepDefnitions;

import com.sainsburys.api.BaseTest;
import com.sainsburys.pages.StatusCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SharedOffers extends BaseTest {
    private Response response;
    private int expectedStatus;

    @Given("the api sends the request")
    public void theApiSendsTheRequest() {
        response = performGet();
        System.out.println(response);
    }

    @When("the api get the response status")
    public void theApiGetTheResponseStatus() {
        expectedStatus = response.getStatusCode();
        System.out.println(expectedStatus);
    }

    @Then("the api status to be verified")
    public void theApiStatusToBeVerified(DataTable dataTable) {
        assertEquals(200,expectedStatus);
    }
}
