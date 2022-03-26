package Zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ChangeofAddressSteps {
    private WebDriver driver;

   String email= "Paulinka1609@wp.pl";
   String  password="Paulinaqwer";

    @Given("^Page (.*) opened in browser$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
    }

    @When("User click Sign in$")
    public void signInInputClick() {
        WebElement signInButon = driver.findElement(By.id("_desktop_user_info"));
        signInButon.click();
    }

    @And("^User completes Email$")
    public void completesEmail() {
        WebElement emailInput = driver.findElement(By.className("form-control"));
        emailInput.sendKeys(email);
    }

    @And("^User completes Password$")
    public void completesPassword() {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }

    @And("^User click SignIn$")
    public void signInClick() {
        WebElement signInButon2 = driver.findElement(By.id("submit-login"));
        signInButon2.click();
    }

    @And("^User click Addresses$")
    public void addressesClick() {
        WebElement addressesInput = driver.findElement(By.id("addresses-link"));
        addressesInput.click();
    }

    @And("^User click in Create new address$")
    public void createNewAddressClick() {
        WebElement createNewAddress = driver.findElement(By.xpath("//a[@data-link-action='add-address']"));
        // / – rozpoczyna wyszukiwanie od element root
        //// – zaznacza wszystkie węzły w dokumencie
        //. – jest aby zaznaczyć aktualny węzeł
        //.. – wskazuje rodzica aktualnego węzła
        //nazwa_węzła – wskazuje wszystkie węzły danego typu
        //@ – służy do określenia atrybutów
        createNewAddress.click();
    }

    @And("^User completes (.*), (.*), (.*),(.*), (.*), (.*)$")
    public void completionOfAddressData(String alias, String address, String city, String zippostalcode, String country, String phoneNumber) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
        WebElement zipOrPostalCodeInput = driver.findElement(By.name("postcode"));
        //zipOrPostalCodeInput.sendKeys("00-200");
        zipOrPostalCodeInput.sendKeys(zippostalcode);
        WebElement countryInput = driver.findElement(By.name("id_country"));
        countryInput.sendKeys(country);
        WebElement phoneInput = driver.findElement(By.name("phone"));
        //phoneInput.sendKeys("123");
        phoneInput.sendKeys(phoneNumber);
        Assert.assertNotNull(aliasInput);
        Assert.assertNotNull(addressInput);
        Assert.assertNotNull(zipOrPostalCodeInput);
        Assert.assertNotNull(cityInput);
        Assert.assertNotNull(countryInput);
        Assert.assertNotNull(phoneInput);
    }

    @And("User click Save$")
    public void saveClick() {
        WebElement saveButton = driver.findElement(By.xpath("//section[@id='content']//button"));
        saveButton.click();
    }


    @Then("Added (.*) are correct$")
    public void checkAddressData(String alias) {
        List<WebElement> aliasTrue = driver.findElements(By.xpath("//h4"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        for (int i = 1; i <= aliasTrue.size() - 1; i++) {
            Assert.assertTrue(aliasTrue.get(i).getText().equals(alias));

        }
    }

    @And("User delete address (.*)$")
    public void deleteClick(String alias) {
        WebElement delete = driver.findElement(By.xpath("//a[@data-link-action='delete-address']"));
        delete.click();
    }

    @And("The address is deleted$")
    public void checkDeleteAddress() {

        WebElement successText = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        Assert.assertEquals("Address successfully deleted!", successText.getText());
    }



}