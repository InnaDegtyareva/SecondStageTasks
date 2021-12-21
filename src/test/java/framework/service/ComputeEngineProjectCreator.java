package framework.service;

import framework.enumlist.*;
import framework.model.ComputeEngineProject;

public class ComputeEngineProjectCreator {
    public static final String TEST_DATA_NUMBER_OF_INSTANCES = "test.data.numberOfInstances";
    public static final String TEST_DATA_OPERATION_SYSTEM = "test.data.operationSystem";
    public static final String TEST_DATA_MACHINE_CLASS = "test.data.machineClass";
    public static final String TEST_DATA_SERIES = "test.data.series";
    public static final String TEST_DATA_MACHINE_TYPE = "test.data.machineType";
    public static final String TEST_DATA_GPU_TYPE = "test.data.gPUType";
    public static final String TEST_DATA_NUMBER_OF_GPU = "test.data.numberOfGPU";
    public static final String TEST_DATA_LOCAL_SSD = "test.data.localSSD";
    public static final String TEST_DATA_DATACENTER_LOCATION = "test.data.datacenterLocation";
    public static final String TEST_DATA_COMMITTED_USAGE = "test.data.committedUsage";

    public static ComputeEngineProject withCredentialFromProperty() {
        return new ComputeEngineProject(TestDataReader.getTestData(TEST_DATA_NUMBER_OF_INSTANCES),
                OperationSystem.valueOf(TestDataReader.getTestData(TEST_DATA_OPERATION_SYSTEM)),
                MachineClass.valueOf(TestDataReader.getTestData(TEST_DATA_MACHINE_CLASS)),
                Series.valueOf(TestDataReader.getTestData(TEST_DATA_SERIES)),
                MachineType.valueOf(TestDataReader.getTestData(TEST_DATA_MACHINE_TYPE)),
                GPUType.valueOf(TestDataReader.getTestData(TEST_DATA_GPU_TYPE)),
                NumberOfGPU.valueOf(TestDataReader.getTestData(TEST_DATA_NUMBER_OF_GPU)),
                LocalSSD.valueOf(TestDataReader.getTestData(TEST_DATA_LOCAL_SSD)),
                DatacenterLocation.valueOf(TestDataReader.getTestData(TEST_DATA_DATACENTER_LOCATION)),
                CommittedUsage.valueOf(TestDataReader.getTestData(TEST_DATA_COMMITTED_USAGE)));
    }
}
