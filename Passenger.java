package com.dft;

import java.util.Objects;

public class Passenger {
    private String name;
    private String pesel;

    public Passenger(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) &&
                Objects.equals(pesel, passenger.pesel) /*&&
                Objects.equals(flight, passenger.flight)*/;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pesel/*, flight*/);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", flight=" + /*flight +*/
                '}';
    }
}
