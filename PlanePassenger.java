package com.dft;

import java.util.Objects;

public class PlanePassenger extends Plane {
    private TypeOfPassengerPlane typeOfPassengerPlane;

    public PlanePassenger(String name, TypeOfPassengerPlane typeOfPassengerPlane) {
        super(name, TypeOfPlane.PASAZERSKI);
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    public TypeOfPassengerPlane getTypeOfPassengerPlane() {
        return typeOfPassengerPlane;
    }

    public void setTypeOfPassengerPlane(TypeOfPassengerPlane typeOfPassengerPlane) {
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlanePassenger that = (PlanePassenger) o;
        return typeOfPassengerPlane == that.typeOfPassengerPlane;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), typeOfPassengerPlane);
    }

    @Override
    public String toString() {
        return "PlanePassenger{" +
                "name=" + super.getName() +
                ", typeOfPassengerPlane=" + typeOfPassengerPlane +
                "}\n";
    }

//    @Override
//    public int compareTo(Plane o) {
//        return 0;
//    }
}
