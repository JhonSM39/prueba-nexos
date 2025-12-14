package com.automation.api.tests.user;

import com.automation.api.config.ApiConfig;
import com.automation.api.services.UserService;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Epic("API Testing")
@Feature("Users")
@Listeners({AllureTestNg.class})
public class DeleteUserTest extends ApiConfig {

    private final UserService userService = new UserService();

    @Test(description = "DELETE /users/{id} - Eliminar un usuario")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Eliminar usuario")
    @Description("Valida que al eliminar un usuario se retorne el código 200 No Content")
    public void deleteUserSuccessfully() {

        // Arrange
        int userId = 2;
        Allure.step("Eliminar usuario con id: " + userId);

        // Act
        Response response = userService.deleteUser(userId);

        response.then().log().all();
        Allure.step("Response body:\n" + response.asString());

        // Assert
        assertThat(response.jsonPath().getBoolean("isDeleted"), is(true));
        assertThat(response.statusCode(), equalTo(200));
    }
}