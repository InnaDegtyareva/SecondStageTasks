package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class CalculatorResultsPage extends AbstractPage {

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement inputNameOfEmailArea;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.company']")
    private WebElement elementToMoveToSendEmailButton;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalCostArea;

    public CalculatorResultsPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public CalculatorResultsPage clickOnEmailEstimateButton() {
        emailEstimateButton.click();
        return this;
    }
    public void switchToEmailWindow() {
        executor.executeScript("window.open()");
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(1));
    }

    public CalculatorResultsPage inputNameOfEmail() {
        wait.until(ExpectedConditions.visibilityOf(inputNameOfEmailArea));
        inputNameOfEmailArea.sendKeys(Keys.LEFT_CONTROL + "v");
        return this;
    }
    public void selectScrolling (WebElement webElement) {
        executor.executeScript("arguments[0].scrollIntoView()", webElement);
    }
    public CalculatorResultsPage clickOnSendEmailButton() {
        selectScrolling(elementToMoveToSendEmailButton);
        wait.until(ExpectedConditions.visibilityOf(elementToMoveToSendEmailButton));
        sendEmailButton.click();
        return this;
    }

    public void switchToEmailWindowForReceivingEmail() {
        ArrayList<String> currentWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentWindows.get(1));
    }
    public String getTotalCost() {
        selectScrolling(totalCostArea);
        wait.until(ExpectedConditions.visibilityOf(totalCostArea));
        return totalCostArea.getText();
    }
}

