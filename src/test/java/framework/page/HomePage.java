package framework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchTextArea;

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public HomePage openHomePage(String homePageUrl) {
        driver.get(homePageUrl);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        logger.info("Home page has been opened");
        return this;
    }
    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }
    public SearchingResultsPage inputSearchDataAndOpenResultsPage(String searchingValue) {
        searchTextArea.sendKeys(searchingValue + "\n");
        return new SearchingResultsPage(driver, wait, actions, executor);
    }
}
