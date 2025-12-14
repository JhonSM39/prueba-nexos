package com.automation.api.tests.user;

import com.automation.api.config.ApiConfig;
import com.automation.api.models.UserRequest;
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
public class CreateUserTest extends ApiConfig {

    private final UserService userService = new UserService();

    @Test(description = "POST /users - Crear usuario")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Crear nuevo usuario")
    @Description("Valida que el usuario se cree correctamente, código 201 y campos generados")
    public void createUserSuccessfully() {

        // Arrange
        UserRequest request = new UserRequest("Jhon", "Sanchez", 10);
        Allure.step("Request body: " + request);

        // Act
        Response response = userService.createUser(request);

        response.then().log().all();
        Allure.step("Response body:\n" + response.asString());

        // Assert
        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.jsonPath().getString("firstName"), equalTo("Jhon"));
        assertThat(response.jsonPath().getString("lastName"), equalTo("Sanchez"));
        assertThat(response.jsonPath().getInt("age"), equalTo(10));

        // Campos generados
        assertThat(response.jsonPath().getString("id"), not(emptyString()));
        assertThat(response.statusCode(), equalTo(201));
    }
}