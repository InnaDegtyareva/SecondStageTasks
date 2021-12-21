package iCanWin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastePage extends AbstractPage {

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement pasteCodeValue;

    public PastePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public String getNewPasteCode() {
        wait.until(ExpectedConditions.visibilityOf(pasteCodeValue));
        return pasteCodeValue.getText();
    }
}
