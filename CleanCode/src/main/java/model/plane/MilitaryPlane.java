package model.plane;

import enums.MilitaryPlaneType;

import java.util.Objects;

public class MilitaryPlane extends Plane {
    private MilitaryPlaneType militaryPlaneType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneType militaryPlaneType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = militaryPlaneType;
    }

    public MilitaryPlaneType getMilitaryPlaneType() {
        return militaryPlaneType;
    }

    public void setMilitaryPlaneType(MilitaryPlaneType militaryPlaneType) {
        this.militaryPlaneType = militaryPlaneType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", militaryPlaneType=" + militaryPlaneType +
                        '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MilitaryPlane)) return false;
        if (!super.equals(object)) return false;
        MilitaryPlane militaryPlane = (MilitaryPlane) object;
        return militaryPlaneType == militaryPlane.militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }

}