package test;

import hardcore.listsofvalues.*;
import hardcore.listsofvalues.CommittedUsage;
import hardcore.pages.CalculatorResultsPage;
import hardcore.pages.EmailPage;
import hardcore.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Hardcore {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor executor;
    private CalculatorResultsPage calculatorResultsPage;
    private EmailPage emailPage;

    @BeforeClass(description = "Setup the browser")
    public void browserSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @BeforeClass(description = "Algorithm of methods", dependsOnMethods = "browserSetup")
    public void getCalculatorResultAndSendItByEmail() {
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
                .clickOnCommittedUsageAreaAndSelect(CommittedUsage.ONE)
                .openCalculatorResultsPage()
                .clickOnEmailEstimateButton();
        calculatorResultsPage.switchToEmailWindow();
        emailPage = new EmailPage(driver, wait, actions, executor)
                .openEmailPage("http://temprmail.com")
                .copyNameOfEmail();
        emailPage.switchToCalculatorWindow();
        calculatorResultsPage.inputNameOfEmail().clickOnSendEmailButton().switchToEmailWindowForReceivingEmail();
        emailPage.clickOnEmailOpenButton();
    }

    @Test(description = "Checking for total cost compliance")
    public void compareTotalCost() {
        String emailCost = emailPage.getTotalCostFromEmail();
        emailPage.switchToCalculatorWindow();
        Assert.assertTrue(calculatorResultsPage.getTotalCost().contains(emailCost),
                "Total cost is not equals");
    }

    @AfterClass(description = "Closing the browser")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

