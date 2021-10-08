package com.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LogIn functionality")
@ExtendWith(ScreenShot.class)
public class LoginTest {
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";

    @BeforeEach
    public void setup() {
    }

    @AfterAll
    public static void cleanup() {
        WebDriverSingleton.getInstance().getDriver().close();
    }

    @Story("LogIn")
    @Description("Verify that user with correct credentials is successfully logged to the app")
    @DisplayName("Verify login to app with correct credentials")
    @TmsLink("ID-101")
    @Test
    public void login() {
        EnterPage enter = new EnterPage();
        LoginPage loginPage = enter.enterToLoginPage();
        MailPage mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);

        assertEquals(USER_NAME, mailPage.getUserName());
    }
}