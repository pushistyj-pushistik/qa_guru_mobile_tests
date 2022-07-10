package tests;

import com.codeborne.selenide.Configuration;
import drivers.AndroidEmulatorMobileDriver;
import drivers.BrowserstackMobileDriver;
import drivers.RealDeviceMobileDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AllureAttachments.sessionId;

public class TestBase {
    static String deviceHost = System.getProperty("deviceHost", "local");

    @BeforeAll
    public static void setup() {
        if (Objects.equals(deviceHost, "browserStack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (Objects.equals(deviceHost, "emulator")) {
            Configuration.browser = AndroidEmulatorMobileDriver.class.getName();
        } else {
            Configuration.browser = RealDeviceMobileDriver.class.getName();
        }

        Configuration.browserSize = null;
        addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        AllureAttachments.screenshotAs("Screenshot");
        AllureAttachments.pageSource();
        closeWebDriver();
        if (Objects.equals(deviceHost, "browserStack")) {
        AllureAttachments.addVideo(sessionId);
        }
    }
}
