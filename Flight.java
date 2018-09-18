package com.dft;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight implements Comparable<Flight> {
    private Airport departureAirport;
    private LocalDateTime departureDate;
    private Airport arrivalAirport;
    private LocalDateTime arrivalDate;
    private Plane plane;
    private StanLotu stanLotu;

//    public Flight() {
//    }

    public Flight(Airport departureAirport, LocalDateTime departureDate, Airport arrivalAirport, LocalDateTime arrivalDate, Plane plane) {
        this.departureAirport = departureAirport;
        this.departureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.arrivalDate = arrivalDate;
        this.plane = plane;
        this.stanLotu = StanLotu.PLANOWANY;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public StanLotu getStanLotu() {
        return stanLotu;
    }

    public void setStanLotu(StanLotu stanLotu) {
        this.stanLotu = stanLotu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureAirport == flight.departureAirport &&
                Objects.equals(departureDate, flight.departureDate) &&
                arrivalAirport == flight.arrivalAirport &&
                Objects.equals(arrivalDate, flight.arrivalDate) &&
                Objects.equals(plane, flight.plane) &&
                stanLotu == flight.stanLotu;
    }

    @Override
    public int hashCode() {

        return Objects.hash(departureAirport, departureDate, arrivalAirport, arrivalDate, plane, stanLotu);
    }

    @Override
    public String toString() {
        return "\nFlight{" +
                "departureAirport=" + departureAirport +
                ", departureDate=" + departureDate +
                ", arrivalAirport=" + arrivalAirport +
                ", arrivalDate=" + arrivalDate +
                ", plane=" + plane +
                ", stanLotu=" + stanLotu +
                "}";
    }

    @Override
    public int compareTo(Flight f) {
        return this.getArrivalDate().compareTo(f.getArrivalDate());
    }
}
