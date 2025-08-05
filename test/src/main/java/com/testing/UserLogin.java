package com.testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



// Test case - 2 & 3
// All test cases : https://www.automationexercise.com/test_cases
public class UserLogin {

    
    public static void LoginUserWithCredentials(String email, String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://www.automationexercise.com/login");
            driver.manage().window().maximize();

            
            
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[2]")).sendKeys(email);
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[3]")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/button")).click();

            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }           
    }
    
    
    
    
    public static void main(String args[]) {
        Dotenv dotenv=Dotenv.configure().directory("test").load();
        Dotenv.configure().directory("test").load();
        // TestCase 2 : login User with correct credentials
        // LoginUserWithCredentials(dotenv.get("REGISTRATION_EMAIL"), dotenv.get("REGISTRATION_PASSWORD"));
        // TestCase 3 : login User with incorrect credentials
        LoginUserWithCredentials("sakthi@gmail.com", "sakthi");
    }
}
