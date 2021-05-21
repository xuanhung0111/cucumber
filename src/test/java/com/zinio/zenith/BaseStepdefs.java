
package com.zinio.zenith;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.zinio.zenith.models.dao.DaoFactory;
import com.zinio.zenith.models.dao.EntityDao;
import com.zinio.zenith.util.ListValidateUtil;
import com.zinio.zenith.util.ResponseError;
import com.zinio.zenith.util.TableRowEntityMapper;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by thinhluong on 9/12/16.
 */
@Component
public class BaseStepdefs implements ApplicationContextAware {
    private static ResponseBody responseBody;
    private static Headers responseHeaders;
    private static Response response;
    private static final String BASE_URL_KEY = "zenith.base.url";

    @Before(order = 2)
    public void setUp() {
    }

    private static ApplicationContext context;
    protected static Environment env;
    private static DaoFactory daoFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        env = context.getBean(Environment.class);
        daoFactory = context.getBean(DaoFactory.class);
    }

    @When("^I get the data via the API \"([^\"]*)\"$")
    public void iGetTheDataViaTheAPI(String endPoint) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        response = (Response) SerenityRest
                .given()
                .get(this.getBaseUrl() + endPoint);

        response
                .then()
                .statusCode(200);

        this.responseBody = response.body();
        this.responseHeaders = response.headers();
    }

    @When("^I get the data via the API \"([^\"]*)\" and filter with \"([^\"]*)\"$")
    public void iGetTheDataViaTheAPIAndFilterWith(String endPoint, String filterQuery) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = (Response) SerenityRest
                .given()
                .get(this.getBaseUrl() + endPoint + "?" + filterQuery);
        response
                .then()
                .statusCode(200);
        this.responseBody = response.body();
        this.responseHeaders = response.headers();
    }

    public String getBaseUrl() {
        return this.env.getProperty(BASE_URL_KEY);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public Headers getResponseHeaders() {
        return responseHeaders;
    }

    public Response getResponse() {
        return response;
    }


    /**
     * This function provide for post method
     *
     * @param name
     * @param endpointUri
     * @param postParams
     * @throws Throwable
     */
    @When("^I create \"([^\"]*)\" via \"([^\"]*)\" by using data below$")
    public void iCreateViaAPI(String name, String endpointUri, @NotNull Map<String, String> postParams) throws Throwable {

        // Convert post params to JSON string
        String body = postParams
                .entrySet()
                .stream()
                .filter(entry -> !"key".equals(entry.getKey()))
                .map(entry -> String.format("\"%s\":\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(",", "{", "}"));

        response = (Response) SerenityRest
                .given()
                .content(ContentType.JSON)
                .body(body)
                .post(this.getBaseUrl() + endpointUri);

        response
                .then()
                .statusCode(201);
        responseHeaders = response.headers();
        responseBody = response.body();
    }

    /**
     * This function provide for put method
     *
     * @param name
     * @param endpointUri
     * @param postParams
     * @throws Throwable
     */
    @When("^I update \"([^\"]*)\" via \"([^\"]*)\" by using data below$")
    public void iUpdateViaAPI(String name, String endpointUri, @NotNull Map<String, String> postParams) throws Throwable {

        // Convert post params to JSON string
        String body = postParams
                .entrySet()
                .stream()
                .filter(entry -> !"key".equals(entry.getKey()))
                .map(entry -> String.format("\"%s\":\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(",", "{", "}"));

        response = (Response) SerenityRest
                .given()
                .content(ContentType.JSON)
                .body(body)
                .put(this.getBaseUrl() + endpointUri);

        response
                .then()
                .statusCode(200);
        responseHeaders = response.headers();
        responseBody = response.body();
    }

    /**
     * This function provide for delete method
     *
     * @param name
     * @param endpointUri
     * @throws Throwable
     */
    @When("^I delete \"([^\"]*)\" via \"([^\"]*)\"$")
    public void iDeleteViaAPI(String name, String endpointUri) throws Throwable {

        response = (Response) SerenityRest
                .given()
                .delete(this.getBaseUrl() + endpointUri);
        response
                .then()
                .statusCode(200);

        responseHeaders = response.headers();
        responseBody = response.body();
    }

    @When("^I get the data unsuccessfully via the API \"([^\"]*)\"$")
    public void iGetTheDataUnsuccessfullyViaTheAPI(String endPoint) throws Throwable {
        response = (Response) SerenityRest
                .given()
                .get(this.getBaseUrl() + endPoint);
        this.responseBody = response.body();
        this.responseHeaders = response.headers();
    }

    @Then("^I see the error message: error code (\\d+), message: (.+), internal code : (.+)$")
    public void iSeeTheErrorMessageErrorCodeErrCodeMessageErrMessageInternalCodeInternalCode(int errCode, String errMsg, String internalCode) throws Throwable {
        String responseErrStr = this.getResponse().asString();
        responseErrStr = responseErrStr.replaceAll(
                "No route found for \"([^\"]+)\"",
                "No route found for \\\\\"$1\\\\\""
        );
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseError responseError = objectMapper.readValue(responseErrStr, ResponseError.class);
//        ResponseError responseError = this.getResponse().as(ResponseError.class);
        this.getResponse().then().statusCode(errCode);
        Assert.assertThat(responseError.isStatus(), Matchers.equalTo(false));
        Assert.assertThat(responseError.getError().getInternalCode(), Matchers.equalTo(internalCode));
        Assert.assertThat(responseError.getError().getMessage(), Matchers.equalTo(errMsg));
    }
}