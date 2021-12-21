package framework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class CalculatorResultsPage extends AbstractPage {

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputNameOfEmailArea;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.company']")
    private WebElement elementToMoveToSendEmailButton;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Region:')]")
    private WebElement regionArea;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term:')]")
    private WebElement commitmentTermArea;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class:')]")
    private WebElement vmClassArea;
    @FindBy(xpath = "//div[contains(@class,'md-list-item-text ng-binding') and contains(text(),'Instance type:')]")
    private WebElement instanceTypeArea;
    @FindBy(xpath = "//div[contains(@class,'md-list-item-text ng-binding') and contains(text(),'Local SSD:')]")
    private WebElement localSSDArea;
    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalCostArea;

    public CalculatorResultsPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public CalculatorResultsPage clickOnEmailEstimateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        logger.info("The final score has been calculated and is ready to be sent by e-mail");
        emailEstimateButton.click();
        return this;
    }
    public void switchToEmailWindow() {
        executor.executeScript("window.open()");
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(1));
    }

    public CalculatorResultsPage inputNameOfEmail(String emailName) {
        wait.until(ExpectedConditions.visibilityOf(inputNameOfEmailArea));
        inputNameOfEmailArea.click();
        inputNameOfEmailArea.sendKeys(emailName);
        logger.info("The name of the email has been inputted");
        return this;
    }

    public CalculatorResultsPage clickOnSendEmailButton() {
        selectScrolling(elementToMoveToSendEmailButton);
        wait.until(ExpectedConditions.visibilityOf(elementToMoveToSendEmailButton));
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        logger.info("The email has been sent");
        return this;
    }
    public void switchToEmailWindowForReceivingEmail() {
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(1));
        logger.info("Switching to email");
    }
    public String getRegion() {
        logger.info("Getting datacenter location from calculator");
        return regionArea.getText();
    }
    public String getCommitmentTerm() {
        logger.info("Getting commitment term from calculator");
        return commitmentTermArea.getText();
    }
    public String getVmClass() {
        logger.info("Getting machine class from calculator");
        return vmClassArea.getText();
    }
    public String getInstanceType() {
        logger.info("Getting instance type from calculator");
        return instanceTypeArea.getText();
    }
    public String getLocalSSD() {
        logger.info("Getting local SSD from calculator");
        return localSSDArea.getText();
    }
    public String getTotalCost() {
        selectScrolling(totalCostArea);
        wait.until(ExpectedConditions.visibilityOf(totalCostArea));
        logger.info("Getting total cost from calculator");
        return totalCostArea.getText();
    }
    public void selectScrolling (WebElement webElement) {
        executor.executeScript("arguments[0].scrollIntoView()", webElement);
    }
}

