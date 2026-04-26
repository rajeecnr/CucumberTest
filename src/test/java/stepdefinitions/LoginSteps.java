package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertTrue;


public class LoginSteps {
	WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters {string} and {string}")
    public void user_enters_credentials(String username , String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("clicks on login button")
    public void clicks_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("login result should be {string}")
    public void validate_home_page(String result) {
        if(result.equalsIgnoreCase("success")){
       String actualurl = driver.getCurrentUrl();
       System.out.println(actualurl);
       assertTrue(actualurl.contains("inventory"));}
       else if(result.equalsIgnoreCase("locked")){
           String actualErrorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
           System.out.println(actualErrorMsg);
           assertTrue(actualErrorMsg.contains("locked"));
        }

        driver.quit();
    }

}
