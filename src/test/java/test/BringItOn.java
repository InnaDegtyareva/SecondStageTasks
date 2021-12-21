package test;

import bringItOn.HomePage;
import bringItOn.PastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class BringItOn {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private PastePage pastePage;
    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private final String pasteName = "how to gain dominance among developers";

    @BeforeClass(description = "Setup the browser")
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @BeforeClass(description = "Algorithm of methods", dependsOnMethods = "browserSetup")
    public void createOneMorePaste() {
        pastePage = new HomePage(driver, wait, actions)
                .openPage("http://pastebin.com")
                .clickCookiesCloseButton()
                .inputCode(code)
                .inputSyntaxHighlighting()
                .inputPasteExpiration()
                .inputPasteName(pasteName)
                .openNewPastePage();
    }

    @Test(description = "Checking for paste names compliance")
    public void comparePasteName() {
        Assert.assertEquals(pastePage.getPasteName(), pasteName, "Pastas names are not equal");
    }

    @Test(description = "Checking for syntax highlighting compliance")
    public void comparePasteSyntax() {
        Assert.assertEquals(pastePage.getPasteSyntaxHighlighting(), "Bash",
                "Pastas syntax highlighting are not equal");
    }

    @Test(description = "Checking for code compliance")
    public void comparePasteCode() {
        Assert.assertEquals(pastePage.getPasteCode(), code, "Pastas codes are not equal");
    }

    @AfterClass(description = "Closing the browser")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

