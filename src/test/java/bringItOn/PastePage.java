package bringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement pasteNameArea;
    @FindBy(xpath = "//div[@class='left']/child::a")
    private WebElement pasteSyntaxHighlightingArea;
    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement pasteCodeArea;

    public PastePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public String getPasteName() {
        wait.until(ExpectedConditions.visibilityOf(pasteNameArea));
        return pasteNameArea.getText();
    }

    public String getPasteSyntaxHighlighting() {
        wait.until(ExpectedConditions.visibilityOf(pasteSyntaxHighlightingArea));
        return pasteSyntaxHighlightingArea.getText();
    }

    public String getPasteCode() {
        wait.until(ExpectedConditions.visibilityOf(pasteCodeArea));
        return pasteCodeArea.getText();
    }
}
