package test;

import hurtMePlenty.listsofvalues.*;
import hurtMePlenty.pages.CalculatorResultsPage;
import hurtMePlenty.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class HurtMePlenty {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor executor;
    private CalculatorResultsPage calculatorResultsPage;

    @BeforeClass(description = "Setup the browser")
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @BeforeClass(description = "Algorithm of methods", dependsOnMethods = "browserSetup")
    public void getCalculatorResults() {
        calculatorResultsPage = new HomePage(driver, wait, actions, executor)
                .openHomePage("http://cloud.google.com")
                .clickSearchButton()
                .inputSearchDataAndOpenResultsPage("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage()
                .switchToFrame()
                .selectSearching()
                .clickOnInstancesAreaAndSelect()
                .clickOnOperationSystemAreaAndSelect(OperationSystem.FREE_DEBIAN_CENTOS_COREOS_UBUNTU_OR_BYOL)
                .clickOnVMClassAreaAndSelect(MachineClass.REGULAR)
                .clickOnSeriesAreaAndSelect(Series.N1)
                .clickOnMachineTypeAreaAndSelect(MachineType.N1_STANDARD_8)
                .clickOnAddGPUButton()
                .clickOnGPUTypeAreaAndSelect(GPUType.NVIDIA_TESLA_T4)
                .clickOnNumberOfGPUAreaAndSelect(NumberOfGPU.ONE)
                .clickOnLocalSSDAreaAndSelect(LocalSSD.TWO_X_375_GB)
                .clickOnDatacenterLocationAreaAndSelect(DatacenterLocation.FRANKFURT)
                .clickOnCommittedUsageAreaAndSelect(CommitedUsage.ONE)
                .openCalculatorResultsPage();
    }

    @Test(description = "Checking for region compliance")
    public void compareRegion() {
        Assert.assertEquals(calculatorResultsPage.getRegion(), "Region: Frankfurt",
                "Regions are not equal");
    }

    @Test(description = "Checking for commitment term compliance")
    public void compareCommitmentTerm() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentTerm(), "Commitment term: 1 Year",
                "Commitment terms are not equal");
    }

    @Test(description = "Checking for VM class compliance")
    public void compareVMClass() {
        Assert.assertEquals(calculatorResultsPage.getVmClass(), "VM class: regular",
                "VM classes are not equal");
    }

    @Test(description = "Checking for instance type compliance")
    public void compareInstanceType() {
        Assert.assertEquals(calculatorResultsPage.getInstanceType(), "Instance type: n1-standard-8" +
                        "\nCommitted Use Discount applied",
                "Instance types are not equal");
    }

    @Test(description = "Checking for local SSD compliance")
    public void compareLocalSSD() {
        Assert.assertEquals(calculatorResultsPage.getLocalSSD(), "Local SSD: 2x375 GiB" +
                        "\nCommitted Use Discount applied",
                "Local SSDs are not equal");
    }

    @Test(description = "Checking for total cost compliance")
    public void compareTotalCost() {
        Assert.assertTrue(calculatorResultsPage.getTotalCost().contains("USD 1,841.97"),
                "Total cost is not equals");
    }

    @AfterClass(description = "Closing the browser")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
