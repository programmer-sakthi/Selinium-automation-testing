package com.testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TestCase 1 : Register User 
// All test cases : https://www.automationexercise.com/test_cases
public class UserRegisteration {
    public static void main(String args[])
    {
        Dotenv dotenv=Dotenv.configure().directory("test").load();

        String name="Sakthi";
        String registration_email=dotenv.get("REGISTRATION_EMAIL");

        
        String gender="Mr"; // Mr or Mrs
        String password = dotenv.get("REGISTRATION_PASSWORD");

        boolean newsletter_signup = true;
        boolean recieve_special_offers = true;

        String firstName="Rangaraya";
        String secondName="Sakthivel";

        String company="Google";
        String address1="123 Main Street";
        String address2="Apt 1";
        String city="Chennai";
        String state="Tamil Nadu";
        String zipCode="12345";
        String country="India";
        String mobileNumber="1234567890";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  


        try {
            driver.get("https://www.automationexercise.com/login");
            driver.findElement(By.name("name")).sendKeys(name);
            WebElement email = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));
            email.sendKeys(registration_email);
            email.submit();

            String genderButtonId = gender.equals("Mr") ? "id_gender1" : "id_gender2"; 
            WebElement genderRadioButton = driver.findElement(By.id(genderButtonId));
            genderRadioButton.click();

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);

            WebElement dateElement = driver.findElement(By.id("days"));
            dateElement.sendKeys("26");
            
            WebElement monthElement = driver.findElement(By.id("months"));
            monthElement.sendKeys("June");

            WebElement yearElement = driver.findElement(By.id("years"));
            yearElement.sendKeys("2006");

            if (recieve_special_offers) {
                WebElement specialOffersCheckbox = driver.findElement(By.id("newsletter"));
                specialOffersCheckbox.click();
            }

            if (newsletter_signup) {
                WebElement newsletterCheckbox = driver.findElement(By.id("optin"));
                newsletterCheckbox.click();
            }

            WebElement first_name_input = driver.findElement(By.id("first_name"));
            first_name_input.sendKeys(firstName);

            WebElement last_name_input = driver.findElement(By.id("last_name"));
            last_name_input.sendKeys(secondName);

            WebElement company_input = driver.findElement(By.id("company"));
            company_input.sendKeys(company);

            WebElement address1_input = driver.findElement(By.id("address1"));
            address1_input.sendKeys(address1);

            WebElement address2_input = driver.findElement(By.id("address2"));
            address2_input.sendKeys(address2);

            WebElement city_input = driver.findElement(By.id("city"));
            city_input.sendKeys(city);

            WebElement state_input = driver.findElement(By.id("state"));
            state_input.sendKeys(state);

            WebElement zip_code_input = driver.findElement(By.id("zipcode"));
            zip_code_input.sendKeys(zipCode);

            WebElement country_input = driver.findElement(By.id("country"));
            country_input.sendKeys(country);

            WebElement mobile_number_input = driver.findElement(By.id("mobile_number"));
            mobile_number_input.sendKeys(mobileNumber);
        
            
            WebElement register_button = driver.findElement(By.xpath("//*[@id='form']/div/div/div/div[1]/form/button"));
            register_button.click();

            


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
