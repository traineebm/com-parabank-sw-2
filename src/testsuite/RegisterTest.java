package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find register link element and click on register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // This is from the given requirements
        String expectedMessage = "Signing up is easy!";

        // Find the given text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate expected and actual message
        Assert.assertEquals("Incorrect details: Please try again", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Find register link element and click on register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        // Finding the first name element
        WebElement firstName = driver.findElement(By.name("customer.firstName"));
        firstName.sendKeys("Meera");
        // Finding the last name element
        WebElement lastName = driver.findElement(By.name("customer.lastName"));
        lastName.sendKeys("Parmar");
        // Finding the address element
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("10 Brixton Road");
        // Finding the element of city
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Watford");
        // Finding the element of state
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("UK");
        // Finding the element of zipcode
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("WD24 4DX");
        // Finding the element of phone number
        WebElement phNo = driver.findElement(By.id("customer.phoneNumber"));
        phNo.sendKeys("7790697597");
        // Finding the element of SSN
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("123456");

        // Finding the username field element
        WebElement userName = driver.findElement(By.id("customer.username"));
        // Sending username details to username field element
        userName.sendKeys("Meera08"); // sending email to email field element
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("customer.password"));
        // sending Password to password field element
        passwordField.sendKeys("Asdfg10");
        // Finding the confirm field element
        WebElement confirmPassword = driver.findElement(By.name("repeatedPassword"));
        // sending Password to confirm field element
        confirmPassword.sendKeys("Asdfg10");
        // Finding the register button and clicking on it
        WebElement registerButton = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        registerButton.click();

        //Verify the given text from the requirements 'Your account was created successfully. You are now logged in.'
        String expectedText = "Your account was created successfully. You are now logged in.";
        WebElement actualTextElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        //Getting the text by using get method
        String actualText = actualTextElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Error message displayed", expectedText, actualText);
    }
    @After
    public void tearDown(){
       closeBrowser();
    }
}
