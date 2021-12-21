package framework.util;

import framework.model.ComputeEngineProject;
import framework.service.ComputeEngineProjectCreator;

public class FormattingStrings {

    private static final ComputeEngineProject computeEngineProject = ComputeEngineProjectCreator.withCredentialFromProperty();

    public static String getDatacenterLocationString() {
       return "Region: " + computeEngineProject.getDatacenterLocation().toString();
    }
    public static String getCommitmentTermString(){
        return "Commitment term: " + computeEngineProject.getCommittedUsage().toString();
    }
    public static String getMachineClassString() {
        return "VM class: " + computeEngineProject.getMachineClass().toString();
    }
    public static String getMachineTypeString() {
        return "Instance type: " + computeEngineProject.getMachineType().toString() +
                "\nCommitted Use Discount applied";
    }
    public static String getLocalSSDString() {
        return "Local SSD: " + computeEngineProject.getLocalSSD().toString() +
                " GiB\nCommitted Use Discount applied";
    }
}
