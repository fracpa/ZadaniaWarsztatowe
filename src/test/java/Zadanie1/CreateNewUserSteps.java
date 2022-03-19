package Zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import java.time.Duration;

public class CreateNewUserSteps {
    private WebDriver driver;


    @Given("^Page (.*) opened in browser$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
    }

    @When("User Click Sign in$")
    public void signInInputClick() {
        WebElement signInInput = driver.findElement(By.id("_desktop_user_info"));
        signInInput.click();
    }

    @And("^User completes Email (.*)$")
    public void completesEmail(String email) {
        WebElement emailInput = driver.findElement(By.className("form-control"));
        emailInput.sendKeys(email);
    }

    @And("^User completes Password (.*)$")
    public void completesPassword(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }
    @And("^User Click SignIn$")
    public void signInClick() {
        WebElement signInInput2 = driver.findElement(By.id("submit-login"));
        signInInput2.click();
    }
    @And("^User Click Addresses$")
    public void AddressesClick() {
        WebElement addressesInput = driver.findElement(By.id("addresses-link"));
        addressesInput.click();
    }
    @And("^User Click Create new address$")
    public void CreateNewAddressClick() {
        WebElement createNewAddressInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        createNewAddressInput.click();
    }
    @And("^User completes (.*), (.*), (.*)$")
    public void CompletionOfAddressData(String alias, String address, String city) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
       // WebElement zipOrPostalCodeInput = driver.findElement(By.name("postcode"));
       // zipOrPostalCodeInput.sendKeys(ziporpostalcode);
       // WebElement countryInput = driver.findElement(By.name("id_country"));
       // countryInput.sendKeys(country);
      // WebElement phoneInput = driver.findElement(By.name("phone"));
       // phoneInput.sendKeys(phone);
    }
    // Then Added addresses are correct
}