package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class EmailPage extends AbstractPage {

    @FindBy(xpath = "//iframe[contains(@allow,'https://cloud')]")
    private WebElement switchToFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement switchToMyFrame;
    @FindBy(xpath = "//button[@title='Copy email address']")
    private WebElement copyEmailNameButton;
    @FindBy(xpath = "//button[@type='button' and contains(text(),'Refresh')]")
    private WebElement refreshButton;
    @FindBy(xpath = "//p[@class='emails-list__subject']")
    private WebElement emailOpenButton;
    @FindBy(xpath = "//td//h3[contains(text(),'USD')]")
    private WebElement totalCostFromEmail;

    public EmailPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }

    public EmailPage openEmailPage(String EmailPageUrl) {
        driver.get(EmailPageUrl);
        return this;
    }

    public EmailPage copyNameOfEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(copyEmailNameButton));
        copyEmailNameButton.click();
        return this;
    }

    public void switchToCalculatorWindow() {
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(0));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToMyFrame));
    }

    public void clickOnEmailOpenButton() {
        refreshButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailOpenButton));
        emailOpenButton.click();
    }

    public String getTotalCostFromEmail() {
        wait.until(ExpectedConditions.visibilityOf(totalCostFromEmail));
        return totalCostFromEmail.getText();
    }
}