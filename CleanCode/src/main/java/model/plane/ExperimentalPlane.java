package model.plane;

import enums.ExperimentalPlaneClassificationLevel;
import enums.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane {
    private ExperimentalPlaneType experimentalPlaneType;
    private ExperimentalPlaneClassificationLevel experimentalPlaneClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneType experimentalPlaneType,
                             ExperimentalPlaneClassificationLevel experimentalPlaneClassificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.experimentalPlaneClassificationLevel = experimentalPlaneClassificationLevel;
    }

    public ExperimentalPlaneType getExperimentalPlaneType() {
        return experimentalPlaneType;
    }

    public void setExperimentalPlaneType(ExperimentalPlaneType experimentalPlaneType) {
        this.experimentalPlaneType = experimentalPlaneType;
    }

    public ExperimentalPlaneClassificationLevel getExperimentalPlaneClassificationLevel() {
        return experimentalPlaneClassificationLevel;
    }

    public void setExperimentalPlaneClassificationLevel(ExperimentalPlaneClassificationLevel experimentalPlaneClassificationLevel) {
        this.experimentalPlaneClassificationLevel = experimentalPlaneClassificationLevel;
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}