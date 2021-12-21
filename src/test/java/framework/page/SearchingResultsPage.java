package framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultsPage extends AbstractPage {
    @FindBy(xpath = "(//a[@href='https://cloud.google.com/products/calculator'])[2]")
    private WebElement resultOfSearch;

    public SearchingResultsPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public CalculatorPage openCalculatorPage() {
        logger.info("The search results page has been opened");
        wait.until(ExpectedConditions.visibilityOf(resultOfSearch));
        resultOfSearch.click();
        return new CalculatorPage(driver, wait, actions, executor);
    }
}
