package wb.examples.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public class TestBase {
    @BeforeAll
    public static void configureBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = false;
        Configuration.reportsFolder = System.getProperty("user.dir") + File.separator + "reports";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
    }
}
