package framework.test;

import framework.page.EmailPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComparisonOfTotalCostTest extends CommonConditions {

    @BeforeClass(dependsOnMethods = "getCalculatorResults", description = "Algorithm of methods")
    public void getCalculatorResultsByEmail() {
        calculatorResultsPage.switchToEmailWindow();
        emailPage = new EmailPage(driver, wait, actions, executor)
                .openEmailPage("https://mytemp.email")
                .clickStartHereButton();
        String emailName = emailPage.getNameOfEmail();
        emailPage.switchToCalculatorWindow();
        calculatorResultsPage.clickOnEmailEstimateButton()
                .inputNameOfEmail(emailName)
                .clickOnSendEmailButton()
                .switchToEmailWindowForReceivingEmail();
        emailPage.clickOpenEmailButton();

    }
    @Test(description = "Checking for total cost compliance")
    public void compareTotalCost() {
        String emailCost = emailPage.getCostFromNewEmail();
        emailPage.switchToCalculatorWindow();
        Assert.assertTrue(calculatorResultsPage.getTotalCost().contains(emailCost),
                "Total cost is not equals");
    }
}

