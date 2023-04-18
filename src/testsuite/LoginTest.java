package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Type  the username  to username filed element
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");
        //Type  the password  to password filed element
        WebElement passwordFeild = driver.findElement(By.name("password"));
        passwordFeild.sendKeys("admin123");
        // find the login button element and click
        WebElement loginButton = driver.findElement(By.xpath("//button[@type ='submit']"));
        loginButton.click();
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("User not login unsuccessfully",expectedText,actualText);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
