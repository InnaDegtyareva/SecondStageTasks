package framework.test;

import framework.util.FormattingStrings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonOfCalculatorFieldData extends CommonConditions {

     @Test(description = "Checking for region compliance")
    public void compareRegion() {
        Assert.assertEquals(calculatorResultsPage.getRegion(), FormattingStrings.getDatacenterLocationString(),
                "Region is not equals");
    }
    @Test(description = "Checking for commitment term compliance")
    public void compareCommitmentTerm() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentTerm(), FormattingStrings.getCommitmentTermString(),
                "Commitment term is not equals");
    }
    @Test(description = "Checking for VM class compliance")
    public void compareVMClass() {
        Assert.assertEquals(calculatorResultsPage.getVmClass(), FormattingStrings.getMachineClassString(),
                "VM class is not equals");
    }
    @Test(description = "Checking for instance type compliance")
    public void compareInstanceType() {
        Assert.assertEquals(calculatorResultsPage.getInstanceType(), FormattingStrings.getMachineTypeString(),
                "Instance type is not equals");
    }
    @Test(description = "Checking for local SSD compliance")
    public void compareLocalSSD() {
        Assert.assertEquals(calculatorResultsPage.getLocalSSD(), FormattingStrings.getLocalSSDString(),
                "Local SSD is not equals");
    }
}
