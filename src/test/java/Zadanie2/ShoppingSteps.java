package Zadanie2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ShoppingSteps {

    private WebDriver driver;

    String email = "Paulinka1609@wp.pl";
    String password = "Paulinaqwer";

    @Given("User open page (.*) in browser$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
    }

    @When("User logs in")
    public void logIn() {
        WebElement signInButon = driver.findElement(By.id("_desktop_user_info"));
        signInButon.click();
        WebElement emailInput = driver.findElement(By.className("form-control"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement signInButon2 = driver.findElement(By.id("submit-login"));
        signInButon2.click();
    }

    @And("User selects and chooses (.*) to buy$")
    public void chooseProduct(String product) {
        WebElement searchInput = driver.findElement(By.name("s"));
        searchInput.sendKeys(product);
        searchInput.submit();
        WebElement discount= driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/div/span[3]"));
        Assert.assertTrue(discount.getText().equals("-20%"));
        WebElement chooseProduct = driver.findElement(By.xpath("//a[contains(text(),'Hummingbird printed sweater')]"));
        chooseProduct.click();
    }

    @And("User chooses size (.*)$")
    public void chooseSize(String size) {
        WebElement sizeproduct = driver.findElement(By.id("group_1"));
        sizeproduct.sendKeys(size);

    }

    @And("User chooses (.*) products$")
    public void chooseCountProducts(String count) {
        WebElement countProduct = driver.findElement(By.id("quantity_wanted"));
        for (int i = 0; i < 11; i++) {
            countProduct.clear();
        }
        countProduct.sendKeys(count);

    }

    @And("User adds products to the shopping card$")
    public void addProduct() {
        WebElement addButtom = driver.findElement(By.xpath("//button[@data-button-action='add-to-cart']"));
        addButtom.click();
    }

    @And("User clicks Proceed to checkout$")
    public void clickCheckout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]"));
        proceedToCheckoutButton.click();
        WebElement proceedToCheckoutButton2 = driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]"));
        proceedToCheckoutButton2.click();
    }

    @And("User confirms address$")
    public void clickContinue() {
        WebElement contiuneButom = driver.findElement(By.name("confirm-addresses"));
        contiuneButom.click();
    }

    @And("User chooses Prestashop \"pick up in store\"$")
    public void choosePrestaShop() {
        WebElement prestaShopRadio = driver.findElement(By.xpath("//span[contains(text(),'PrestaShop')]"));
        prestaShopRadio.click();
        WebElement continueButtonInShippingMethod = driver.findElement(By.name("confirmDeliveryOption"));
        continueButtonInShippingMethod.click();
    }

    @And("User chooses Pay by Check$")
    public void choosePayByCheck() {
        WebElement payByCheckradio = driver.findElement(By.id("payment-option-1"));
        payByCheckradio.click();
    }

    @And("User agree to the terms of service$")
    public void clickIAgreeToTheTerms() {
        WebElement iAgreeToTheTermsCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        iAgreeToTheTermsCheckbox.click();
    }

    @And("User clicks \"order with an obligation to pay\"$")
    public void clickOrderWithAnObligationToPay() {
        WebElement orderWithAnObligationToPayButton = driver.findElement(By.xpath("//button[contains(text(),'Order with an obligation to pay')]"));
        orderWithAnObligationToPayButton.click();
    }

    @Then("Save a screenshot of the order confirmation and the amount$")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "Zadanie2", "the_order_confirmation_and_the_amount" + currentDateTime + ".png"));
    }


    @And("User clicks on you profile$")
    public void clickAccount() {
        WebElement Account = driver.findElement(By.xpath("//span[contains(text(),'Paulina Rogozinska')]"));
        Account.click();
    }

    @And("User chooses \"order history and details\"$")
    public void chooseOrderHistoryAndDetails() {
        WebElement orderHistoryAndDetailsButton = driver.findElement(By.id("history-link"));
        orderHistoryAndDetailsButton.click();
    }


    @And("Close browser")
    public void closeBrowser() {
        this.driver.quit();
    }
}


