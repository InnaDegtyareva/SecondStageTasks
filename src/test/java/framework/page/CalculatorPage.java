package framework.page;

import framework.enumlist.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {

    @FindBy(xpath = "//iframe[contains(@allow,'https://cloud')]")
    private WebElement switchToFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement switchToMyFrame;
    @FindBy(xpath = "//div[@class='name ng-binding']")
    private WebElement selectSearching;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instancesArea;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemArea;
    @FindBy(xpath = "//*[@placeholder='VM Class']")
    private WebElement vMClassArea;
    @FindBy(xpath = "//*[@placeholder='Series']")
    private WebElement seriesArea;
    @FindBy(xpath = "//*[@placeholder='Instance type']")
    private WebElement machineTypeArea;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUButton;
    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement gPUTypeArea;
    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUArea;
    @FindBy(xpath = "//*[@placeholder='Local SSD']")
    private WebElement localSSDArea;
    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement datacenterLocationArea;
    @FindBy(xpath = "//*[@placeholder='Committed usage']")
    private WebElement committedUsageArea;
    @FindBy(xpath = "//button[contains(@ng-click,'ComputeEngineForm')]")
    private WebElement addToEstimateButton;

    private static final String OPERATION_SYSTEM_LOCATOR_PATTERN = "//md-option[@value='%s']";
    private static final String MACHINE_CLASS_LOCATOR_PATTERN = "(//md-option[@value='%s'])[2]";
    private static final String SERIES_LOCATOR_PATTERN = "//md-option[@value='%s']";
    private static final String MACHINE_TYPE_LOCATOR_PATTERN = "//*[@ng-repeat='instance in typeInfo']//*[contains(text(),'%s')]";
    private static final String GPU_TYPE_LOCATOR_PATTERN = "//*[@value='%s']";
    private static final String NUMBER_OF_GPU_LOCATOR_PATTERN = "//*[contains(@ng-disabled,'listingCtrl.minGPU') and @value='%s']";
    private static final String LOCAL_SSD_LOCATOR_PATTERN = "//*[@ng-value='item.value']//div[contains(text(),'%s')]";
    private static final String DATACENTER_LOCATION_LOCATOR_PATTERN = "(//*[contains(@ng-repeat,'fullRegionList')]//div[contains(text(),'%s')])[2]";
    private static final String COMMITTED_USAGE_LOCATOR_PATTERN = "(//*[@class='md-ink-ripple']//div[contains(text(),'%s')])[2]";


    public CalculatorPage(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor executor) {
        super(driver, wait, actions, executor);
    }
    public CalculatorPage switchToFrame() {
        logger.info("Calculator page has been opened");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(switchToMyFrame));
        logger.info("Switching to frames");
        return this;
    }
    public CalculatorPage selectSearching() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSearching));
        selectSearching.click();
        return this;
    }
    public CalculatorPage clickOnInstancesAreaAndSelect(String numberOfInstances) {
        instancesArea.click();
        instancesArea.sendKeys(numberOfInstances);
        return this;
    }
    public CalculatorPage clickOnOperationSystemAreaAndSelect(OperationSystem operationSystem) {
        operationSystemArea.click();
        selectValueFromTheList(OPERATION_SYSTEM_LOCATOR_PATTERN, operationSystem);
        return this;
    }
    public CalculatorPage clickOnVMClassAreaAndSelect(MachineClass machineClass) {
        selectScrolling(vMClassArea);
        wait.until(ExpectedConditions.visibilityOf(vMClassArea));
        vMClassArea.click();
        selectValueFromTheList(MACHINE_CLASS_LOCATOR_PATTERN, machineClass);
        return this;
    }
    public CalculatorPage clickOnSeriesAreaAndSelect(Series series) {
        seriesArea.click();
        selectValueFromTheList(SERIES_LOCATOR_PATTERN, series);
        return this;
    }
    public CalculatorPage clickOnMachineTypeAreaAndSelect(MachineType machineType) {
        machineTypeArea.click();
        selectValueFromTheList(MACHINE_TYPE_LOCATOR_PATTERN, machineType);
        return this;
    }
    public CalculatorPage clickOnAddGPUButton() {
        addGPUButton.click();
        return this;
    }
    public CalculatorPage clickOnGPUTypeAreaAndSelect(GPUType gpuType) {
        gPUTypeArea.click();
        selectValueFromTheList(GPU_TYPE_LOCATOR_PATTERN, gpuType);
        return this;
    }
    public CalculatorPage clickOnNumberOfGPUAreaAndSelect(NumberOfGPU numberOfGPU) {
        numberOfGPUArea.click();
        selectValueFromTheList(NUMBER_OF_GPU_LOCATOR_PATTERN, numberOfGPU);
        return this;
    }
    public CalculatorPage clickOnLocalSSDAreaAndSelect(LocalSSD localSSD) {
        localSSDArea.click();
        selectValueFromTheList(LOCAL_SSD_LOCATOR_PATTERN, localSSD);
        return this;
    }
    public CalculatorPage clickOnDatacenterLocationAreaAndSelect(DatacenterLocation datacenterLocation) {
        selectScrolling(committedUsageArea);
        wait.until(ExpectedConditions.visibilityOf(committedUsageArea));
        datacenterLocationArea.click();
        selectValueFromTheList(DATACENTER_LOCATION_LOCATOR_PATTERN, datacenterLocation);
        return this;
    }
    public CalculatorPage clickOnCommittedUsageAreaAndSelect(CommittedUsage committedUsage) {
        committedUsageArea.click();
        selectValueFromTheList(COMMITTED_USAGE_LOCATOR_PATTERN, committedUsage);
        return this;
    }
    public CalculatorResultsPage openCalculatorResultsPage() {
        logger.info("The necessary fields of the table have been filled in");
        addToEstimateButton.click();
        return new CalculatorResultsPage(driver, wait, actions, executor);
    }
    public <E extends Enum<E>> void selectValueFromTheList(String locatorPattern, E enumList) {
        driver.findElement(By.xpath(String.format(locatorPattern, enumList))).click();
    }
    public void selectScrolling(WebElement webElement) {
        executor.executeScript("arguments[0].scrollIntoView()", webElement);
    }
}
