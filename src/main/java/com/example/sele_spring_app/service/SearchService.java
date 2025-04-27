package com.example.sele_spring_app.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import com.example.sele_spring_app.util.WebDriverUtil;

@Service
public class SearchService {

    public String performSearch(String url, String query) {
        WebDriver driver = WebDriverUtil.getWebDriver();

        try {
            // Open the provided URL
            driver.get(url);

            // Find the search box and submit the query
            WebElement searchBox = driver.findElement(By.name("q")); // Works for Google/Bing
            searchBox.sendKeys(query);
            searchBox.submit();

            // Wait for results to load and return the page title
            Thread.sleep(2000); // Simulate a delay to observe the results
            return "Search Results Loaded: " + driver.getTitle();
        } catch (InterruptedException e) {
            return "Error: Unable to perform the search. Please check the URL and query.";
        } finally {
            driver.quit(); // Close the browser
        }
    }
}