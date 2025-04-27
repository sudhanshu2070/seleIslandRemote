package com.example.sele_spring_app.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {

    public static WebDriver getWebDriver() {
        
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // headless mode(for getting that in background)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }
}
