package test;

import iCanWin.HomePage;
import iCanWin.PastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class ICanWin {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private PastePage pastePage;
    private final String code = "Hello from WebDriver";

    @BeforeClass(description = "Setup the browser")
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @BeforeClass(description = "Algorithm of methods", dependsOnMethods = "browserSetup")
    public void createNewPaste() {
        pastePage = new HomePage(driver, wait, actions)
                .openPage("http://pastebin.com")
                .clickCookiesCloseButton()
                .inputCode(code)
                .inputPasteExpiration()
                .inputPasteName("helloweb")
                .openNewPastePage();
    }
    @Test(description = "Checking for creation equal paste code")
    public void checkNewPasteCreation() {
        Assert.assertEquals(pastePage.getNewPasteCode(), code, "Pastas codes are not equal");
    }
    @AfterClass(description = "Closing the browser")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
