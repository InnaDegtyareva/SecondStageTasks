package hurtMePlenty.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultsPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='gs-title']/child::b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement resultOfSearch;

    @FindBy(xpath = "(//a[@class='gs-title']//b[text()='Pricing'])[5]")
    private WebElement helpToFindElement;

    public SearchingResultsPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public CalculatorPage openCalculatorPage() {
        wait.until(ExpectedConditions.visibilityOf(helpToFindElement));
        actions.moveToElement(helpToFindElement).perform();
        actions.moveToElement(resultOfSearch).perform();
        wait.until(ExpectedConditions.visibilityOf(resultOfSearch));
        resultOfSearch.click();
        return new CalculatorPage(driver, wait, actions, executor);
    }
}
