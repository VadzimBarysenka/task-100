package com.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LogOut functionality")
@ExtendWith(ScreenShot.class)
public class LogOutTest {
    private MailPage mailPage;
    private final static String USER_NAME = "someanotheruserfortest";
    private final static String USER_PASSWORD = "#EDCvfr4";
    private final static String LOGIN_PAGE_TITLE = "Authorizatio";

    @BeforeEach
    public void setup() {
        EnterPage enter = new EnterPage();
        LoginPage loginPage = enter.enterToLoginPage();
        mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);
    }

    @AfterAll
    public static void cleanup() {
        WebDriverSingleton.getInstance().closeDriver();
    }

    @Story("LogOut")
    @Description("Verify that users successfully logged out from the app")
    @DisplayName("Verify logout from the app")
    @TmsLink("ID-102")
    @Test
    public void logout() {
        LoginPage afterLogout = mailPage.logout();

        assertEquals(LOGIN_PAGE_TITLE, afterLogout.getLoginPageTitle());
    }
}
