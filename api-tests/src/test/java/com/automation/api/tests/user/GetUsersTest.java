package com.automation.api.tests.user;
import com.automation.api.config.ApiConfig;

import com.automation.api.services.UserService;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Epic("API Testing")
@Feature("Users")
@Listeners({AllureTestNg.class})
public class GetUsersTest extends ApiConfig{

    private final UserService userService = new UserService();

    @Test(description = "GET /users - Validar código y estructura")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Obtener listado de usuarios")
    @Description("Valida que el endpoint retorne código 200 y estructura JSON correcta")
    public void getUsersSuccessfully() {

        Response response = userService.getUsers();
        response.then().log().all();
        Allure.step("Response body:\n" + response.asString());

        // Código 200
        assertThat(response.statusCode(), equalTo(200));

        // Lista de usuarios no vacía
        assertThat(response.jsonPath().getList("users"), is(not(empty())));

        // Validar campos del primer usuario
        assertThat(response.jsonPath().getInt("users[0].id"), greaterThan(0));
        assertThat(response.jsonPath().getString("users[0].firstName"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].lastName"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].maidenName"), is(notNullValue()));
        assertThat(response.jsonPath().getInt("users[0].age"), greaterThan(0));
        assertThat(response.jsonPath().getString("users[0].gender"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].email"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].phone"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].username"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].password"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].birthDate"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].image"), is(not(emptyString())));
        assertThat(response.jsonPath().getString("users[0].bloodGroup"), is(not(emptyString())));
        assertThat(response.jsonPath().getFloat("users[0].height"), greaterThan(0f));
        assertThat(response.jsonPath().getFloat("users[0].weight"), greaterThan(0f));
        assertThat(response.jsonPath().getString("users[0].eyeColor"), is(not(emptyString())));
    }
}