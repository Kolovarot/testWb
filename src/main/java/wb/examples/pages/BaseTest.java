package wb.examples.pages;


import com.codeborne.selenide.Configuration;


abstract public class BaseTest {

    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }
}
