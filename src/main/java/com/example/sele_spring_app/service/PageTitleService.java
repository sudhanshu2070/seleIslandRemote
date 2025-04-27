package com.example.sele_spring_app.service;

import com.example.sele_spring_app.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class PageTitleService {

    public String getPageTitle(String url) {
        WebDriver driver = WebDriverUtil.getWebDriver();

        try {
            driver.get(url);
            return "Page Title: " + driver.getTitle();
        } finally {
            driver.quit();
        }
    }
}