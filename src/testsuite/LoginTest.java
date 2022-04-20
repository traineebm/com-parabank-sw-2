package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Finding the username field element
        WebElement userName = driver.findElement(By.name("username"));
        // Sending username to username field element
        userName.sendKeys("Meera08"); // sending email to email field element
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("Asdfg10");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //Verify the given text from the requirements 'Accounts Overview' text is display
        String expectedText = "Accounts Overview";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        //Getting the text by using get method
        String actualText = actualTextElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Error message displayed", expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage() {
        // Finding the username field element
        WebElement userName = driver.findElement(By.name("username"));
        // Sending username details to username field element
        userName.sendKeys("musafir007"); // sending email to email field element
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("powerBall");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        //verify the error message form the given text 'The username and password couldnot be verified.'
        String expectedText = "The username and password could not be verified.";
        WebElement actualTextElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        //Getting the text by using get method
        String actualText = actualTextElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Error message not displayed", expectedText, actualText);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Finding the username field element
        WebElement userName = driver.findElement(By.name("username"));
        // Sending username to username field element
        userName.sendKeys("Meera08"); // sending email to email field element
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("Asdfg10");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        // Finding the login out link and clicking on it
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();
        //verify the given text 'Customer Login' from the requirements
        String expectedText = "Customer Login";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        //Getting the text by using get method
        String actualText = actualTextElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Error message not displayed", expectedText, actualText);
    }
     @After
    public void tearDown(){
     closeBrowser();
     }
}
















