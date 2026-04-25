package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {
	WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username and password")
    public void user_enters_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("clicks on login button")
    public void clicks_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be navigated to home page")
    public void validate_home_page() {
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
