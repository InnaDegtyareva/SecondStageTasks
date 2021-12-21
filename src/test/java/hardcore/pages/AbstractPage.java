package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.Logger;

public class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor executor;
    protected Logger logger;

    public AbstractPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        this.executor = executor;
        PageFactory.initElements(driver, this);
    }
}
