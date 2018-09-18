package com.dft;

import java.util.Objects;

public abstract class Plane implements Comparable<Plane> {
    private String name;
    private TypeOfPlane typeOfPlane;


    public Plane(String name, TypeOfPlane typeOfPlane) {
        this.name = name;
        this.typeOfPlane = typeOfPlane;

    }

    public String getName() {
        return name;
    }

    public TypeOfPlane getTypeOfPlane() {
        return typeOfPlane;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(name, plane.name) &&
                typeOfPlane == plane.typeOfPlane;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, typeOfPlane);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name=" + name + '\'' +
                ", typeOfPlane=" + typeOfPlane +
                ", idNumber="  +
                '}';
    }

    @Override
    public int compareTo(Plane o) {
        return getName().compareToIgnoreCase(o.getName());
    }
}
