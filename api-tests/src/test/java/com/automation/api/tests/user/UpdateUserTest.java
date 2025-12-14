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
public class UpdateUserTest extends ApiConfig {

    private final UserService userService = new UserService();

    @Test(description = "PUT /users/{id} - Actualizar usuario")
    @Severity(SeverityLevel.NORMAL)
    @Story("Actualizar usuario existente (PUT)")
    @Description("Valida que el usuario sea actualizado correctamente y retorne 200 con updatedAt")
    public void updateUserSuccessfully() {

        // Arrange
        int userId = 2;   // ReqRes permite actualizar este usuario sin problema
        UserRequest request = new UserRequest("Jairo", "Munoz", 11);

        // Act
        Response response = userService.updateUser(userId, request);

        // Assert
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.jsonPath().getString("firstName"), equalTo("Jairo"));
        assertThat(response.jsonPath().getString("lastName"), equalTo("Munoz"));
        assertThat(response.jsonPath().getInt("age"), equalTo(11));
    }
}