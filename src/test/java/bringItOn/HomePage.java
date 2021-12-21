package bringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[@class='cookie-button js-close-cookies']")
    private WebElement cookiesCloseButton;
    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;
    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
    private WebElement syntaxHighlightingButton;
    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement selectSyntaxHighlighting;
    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    private WebElement pasteExpirationButton;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement selectPasteExpiration;
    @FindBy(id = "postform-name")
    private WebElement pasteNameArea;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public HomePage openPage(String homePageUrl) {
        driver.get(homePageUrl);
        wait.until(ExpectedConditions.visibilityOf(pasteTextArea));
        return this;
    }

    public HomePage clickCookiesCloseButton() {
        cookiesCloseButton.click();
        return this;
    }

    public HomePage inputCode(String code) {
        pasteTextArea.sendKeys(code);
        return this;
    }

    public HomePage inputSyntaxHighlighting() {
        actions.moveToElement(createNewPasteButton).perform();
        wait.until(ExpectedConditions.visibilityOf(createNewPasteButton));
        wait.until(ExpectedConditions.elementToBeClickable(syntaxHighlightingButton));
        syntaxHighlightingButton.click();
        selectSyntaxHighlighting.click();
        return this;
    }

    public HomePage inputPasteExpiration() {
        pasteExpirationButton.click();
        selectPasteExpiration.click();
        return this;
    }

    public HomePage inputPasteName(String pasteName) {
        pasteNameArea.sendKeys(pasteName);
        return this;
    }

    public PastePage openNewPastePage() {
        createNewPasteButton.submit();
        return new PastePage(driver, wait, actions);
    }
}

