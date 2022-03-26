package Zadanie2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShoppingSteps {

    private WebDriver driver;

    String email= "Paulinka1609@wp.pl";
    String  password="Paulinaqwer";

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
  @And("User select and chose (.*) to buy$")
    public void choseProduct(String product){
        WebElement searchInput=driver.findElement(By.name("s"));
        searchInput.sendKeys(product);
        searchInput.submit();
        WebElement chooseProduct=driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a"));
        chooseProduct.click();
  }

   @And("User chose size (.*)$")
    public void  choseSize(String size){
        WebElement sizeproduct=driver.findElement(By.id("group_1"));
        sizeproduct.sendKeys(size);

   }
 @And("User chose (.*) products$")
  public void choseCountProducts(String count){
     WebElement countProduct=driver.findElement(By.id("quantity_wanted"));
     //countProduct.click();
     countProduct.clear();
     countProduct.sendKeys(count);
 }
  @And("User add products to the shopping card$")
    public void addProduct(){
        WebElement addButtom =driver.findElement(By.xpath("//button[@data-button-action='add-to-cart']"));
        addButtom.click();
  }
 @And("User click checkout$")
    public void clickCheckoutButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        WebElement ProceedToCheckoutButton=driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]"));
        ProceedToCheckoutButton.click();
 }
 //@And("User confirms address$")
   // public void
    //@And("User chose Prestashop "pick up in store"$")
    //@And("User chose Pay by Check$")
    //@And("User clicks "order with an obligation to pay"$")
   // Then Save a screenshot of the order confirmation and the amount$")
    //@And("Dodatkowe$")


}
