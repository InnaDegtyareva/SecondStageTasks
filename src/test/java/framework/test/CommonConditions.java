package framework.test;

import framework.driver.DriverSingleton;
import framework.model.ComputeEngineProject;
import framework.page.CalculatorResultsPage;
import framework.page.EmailPage;
import framework.page.HomePage;
import framework.service.ComputeEngineProjectCreator;
import framework.util.TestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor executor;
    protected CalculatorResultsPage calculatorResultsPage;
    protected EmailPage emailPage;
    ComputeEngineProject computeEngineProject = ComputeEngineProjectCreator.withCredentialFromProperty();

    @BeforeClass(description = "Setup the browser")
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    @BeforeClass(description = "Algorithm of methods")
    public void getCalculatorResults() {
        calculatorResultsPage = new HomePage(driver, wait, actions, executor)
                .openHomePage("http://cloud.google.com")
                .clickSearchButton()
                .inputSearchDataAndOpenResultsPage("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage()
                .switchToFrame()
                .selectSearching()
                .clickOnInstancesAreaAndSelect(computeEngineProject.getNumberOfInstances())
                .clickOnOperationSystemAreaAndSelect(computeEngineProject.getOperationSystem())
                .clickOnVMClassAreaAndSelect(computeEngineProject.getMachineClass())
                .clickOnSeriesAreaAndSelect(computeEngineProject.getSeries())
                .clickOnMachineTypeAreaAndSelect(computeEngineProject.getMachineType())
                .clickOnAddGPUButton()
                .clickOnGPUTypeAreaAndSelect(computeEngineProject.getGpuType())
                .clickOnNumberOfGPUAreaAndSelect(computeEngineProject.getNumberOfGPU())
                .clickOnLocalSSDAreaAndSelect(computeEngineProject.getLocalSSD())
                .clickOnDatacenterLocationAreaAndSelect(computeEngineProject.getDatacenterLocation())
                .clickOnCommittedUsageAreaAndSelect(computeEngineProject.getCommittedUsage())
                .openCalculatorResultsPage();
    }

    @AfterClass(description = "Closing the browser", alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}

