package framework.model;

import framework.enumlist.*;
import java.util.Objects;

public class ComputeEngineProject {

    private String numberOfInstances;
    private OperationSystem operationSystem;
    private MachineClass machineClass;
    private Series series;
    private MachineType machineType;
    private GPUType gpuType;
    private NumberOfGPU numberOfGPU;
    private LocalSSD localSSD;
    private DatacenterLocation datacenterLocation;
    private CommittedUsage committedUsage;

    public ComputeEngineProject(String numberOfInstances, OperationSystem operationSystem,
                                MachineClass machineClass, Series series, MachineType machineType,
                                GPUType gpuType, NumberOfGPU numberOfGPU, LocalSSD localSSD,
                                DatacenterLocation datacenterLocation, CommittedUsage committedUsage) {

        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGPU = numberOfGPU;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }
    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public OperationSystem getOperationSystem() {
        return operationSystem;
    }

    public MachineClass getMachineClass() {
        return machineClass;
    }

    public Series getSeries() {
        return series;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public GPUType getGpuType() {
        return gpuType;
    }

    public NumberOfGPU getNumberOfGPU() {
        return numberOfGPU;
    }

    public LocalSSD getLocalSSD() {
        return localSSD;
    }

    public DatacenterLocation getDatacenterLocation() {
        return datacenterLocation;
    }

    public CommittedUsage getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngineProject{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operationSystem=" + operationSystem +
                ", machineClass=" + machineClass +
                ", series=" + series +
                ", machineType=" + machineType +
                ", gpuType=" + gpuType +
                ", numberOfGPU=" + numberOfGPU +
                ", localSSD=" + localSSD +
                ", datacenterLocation=" + datacenterLocation +
                ", committedUsage=" + committedUsage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputeEngineProject)) return false;
        ComputeEngineProject that = (ComputeEngineProject) o;
        return getNumberOfInstances().equals(that.getNumberOfInstances())
                && getOperationSystem() == that.getOperationSystem()
                && getMachineClass() == that.getMachineClass() && getSeries() == that.getSeries()
                && getMachineType() == that.getMachineType() && getGpuType() == that.getGpuType()
                && getNumberOfGPU() == that.getNumberOfGPU() && getLocalSSD() == that.getLocalSSD()
                && getDatacenterLocation() == that.getDatacenterLocation()
                && getCommittedUsage() == that.getCommittedUsage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getOperationSystem(), getMachineClass(),
                getSeries(), getMachineType(), getGpuType(), getNumberOfGPU(), getLocalSSD(),
                getDatacenterLocation(), getCommittedUsage());
    }
}
