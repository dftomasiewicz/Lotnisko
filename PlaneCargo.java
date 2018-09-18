package com.dft;

import java.util.Objects;

public class PlaneCargo extends Plane  {
    private TypeOfCargoPlane typeOfCargoPlane;

    public PlaneCargo(String name, TypeOfCargoPlane typeOfCargoPlane) {
        super(name, TypeOfPlane.TOWAROWY);
        this.typeOfCargoPlane = typeOfCargoPlane;
    }

    public TypeOfCargoPlane getTypeOfCargoPlane() {
        return typeOfCargoPlane;
    }

    public void setTypeOfCargoPlane(TypeOfCargoPlane typeOfCargoPlane) {
        this.typeOfCargoPlane = typeOfCargoPlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaneCargo that = (PlaneCargo) o;
        return typeOfCargoPlane == that.typeOfCargoPlane;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), typeOfCargoPlane);
    }

    @Override
    public String toString() {
        return "PlaneCargo{" +
                "name=" + super.getName() +
                ", typeOfCargoPlane=" + typeOfCargoPlane +
                "}\n";
    }


//    @Override
//    public int compareTo(Plane p) {
//        return 0;
//    }
}
