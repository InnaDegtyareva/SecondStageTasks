package hurtMePlenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorResultsPage extends AbstractPage {

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

    public String getRegion() {
        return regionArea.getText();
    }
    public String getCommitmentTerm() {
        return commitmentTermArea.getText();
    }
    public String getVmClass() {
        return vmClassArea.getText();
    }
    public String getInstanceType() {
        return instanceTypeArea.getText();
    }
    public String getLocalSSD() {
        return localSSDArea.getText();
    }
    public String getTotalCost() {
        wait.until(ExpectedConditions.visibilityOf(totalCostArea));
        return totalCostArea.getText();
    }
}

