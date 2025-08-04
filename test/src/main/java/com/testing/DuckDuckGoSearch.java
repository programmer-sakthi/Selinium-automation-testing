package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;

public class DuckDuckGoSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open DuckDuckGo
            driver.get("https://duckduckgo.com");

            // 2. Enter query in the search box and submit
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            searchBox.submit();

            // 3. Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ol.react-results--main li")));

            // 4. Find all <li> inside the result list
            List<WebElement> results = driver.findElements(By.cssSelector("ol.react-results--main li"));

            // 5. Print first <a> tag in each <li>
            for (WebElement result : results) {
                try {
                    WebElement link = result.findElement(By.tagName("a"));
                    String href = link.getAttribute("href");
                    System.out.println(href);
                } catch (Exception e) {
                    // Skip if <a> not found in this <li>
                }
            }

            if(!results.isEmpty())
            {
                results.get(0).click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
