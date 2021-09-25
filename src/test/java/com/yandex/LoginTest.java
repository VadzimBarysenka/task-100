package com.yandex;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";

    @BeforeEach
    public void setup() {
    }

    @AfterEach
    public void cleanup() {
        WebDriverSingleton.getInstance().getDriver().close();
    }

    @Test
    public void login() {
        EnterPage enter = new EnterPage();
        LoginPage loginPage = enter.enterToLoginPage();
        MailPage mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);

        assertEquals(USER_NAME, mailPage.getUserName());
    }
}