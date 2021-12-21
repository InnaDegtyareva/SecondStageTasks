package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        this.logger = LogManager.getRootLogger();
        PageFactory.initElements(driver, this);
    }
}
