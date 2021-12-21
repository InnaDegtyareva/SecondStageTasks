package framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class EmailPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='truncate ng-binding flex']")
    private WebElement emailArea;
    @FindBy(xpath = "//a[text()='Start Here']")
    private WebElement startButton;
    @FindBy(xpath = "//span[contains(text(),'Google Cloud Sales')]")
    private WebElement incomeEmail;
    @FindBy(xpath = "//iframe[contains(@allow,'https://cloud')]")
    private WebElement switchToFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement switchToMyFrame;
    @FindBy(xpath = "//td[contains(text(),'USD')]")
    private WebElement totalCostArea;
    @FindBy(xpath = "//iframe[@id='body-html-iframe-content']")
    private WebElement emailFrame;

    public EmailPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }

    public EmailPage openEmailPage(String emailPageUrl) {
        logger.info("Email page " + emailPageUrl + " has been opened");
        driver.get(emailPageUrl);
        return this;
    }

    public EmailPage clickStartHereButton() {
        wait.until(ExpectedConditions.elementToBeClickable(startButton));
        startButton.click();
        return this;
    }

    public String getNameOfEmail() {
        wait.until(ExpectedConditions.visibilityOf(emailArea));
        return emailArea.getText();
    }

    public void switchToCalculatorWindow() {
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(0));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToMyFrame));
        logger.info("Switching to frames");
    }

    public void clickOpenEmailButton() {
        wait.until(ExpectedConditions.visibilityOf(incomeEmail));
        incomeEmail.click();
        logger.info("Email letter has been opened");
    }

    public String getCostFromNewEmail() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(emailFrame));
        wait.until(ExpectedConditions.visibilityOf(totalCostArea));
        logger.info("Getting total cost from the email");
        return totalCostArea.getText();
    }
}