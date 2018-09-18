package com.dft;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDateTime w1 = LocalDateTime.of(2018, Month.JULY, 18, 12, 15);
        LocalDateTime w2 = LocalDateTime.of(2018, Month.JULY, 12, 23, 53);
        LocalDateTime w3 = LocalDateTime.of(2018, Month.JULY, 2, 22, 57);
        LocalDateTime w4 = LocalDateTime.of(2018, Month.JULY, 1, 12, 15);
        LocalDateTime start = LocalDateTime.of(2018, Month.JULY, 1, 00, 01);
        LocalDateTime end = LocalDateTime.of(2018, Month.JULY, 30, 23, 59);

        Flight f1 = new Flight(Airport.WARSZAWA_CHOPIN, w4, Airport.LONDYN_Heathrow, w3, new PlanePassenger("AirbusLotu",  TypeOfPassengerPlane.AIRBUS_A300));
        Flight f2 = new Flight(Airport.WARSZAWA_CHOPIN, w4, Airport.WARSZAWA_MODLIN, w3, new PlanePassenger("AirbusWizza",  TypeOfPassengerPlane.AIRBUS_A300));
        Flight f3 = new Flight(Airport.BANGKOK_SUARNABHUMI, w4, Airport.WARSZAWA_CHOPIN, w3, new PlanePassenger("AirbusLotu",  TypeOfPassengerPlane.AIRBUS_A300));
        Flight f4 = new Flight(Airport.WARSZAWA_CHOPIN, w2, Airport.NOWY_YORK_JFK, w1, new PlanePassenger("BoeingRyan",  TypeOfPassengerPlane.BOEING747));
        Flight f5 = new Flight(Airport.NOWY_YORK_JFK, w2, Airport.LONDYN_LUTON, w1, new PlanePassenger("McDonnel",  TypeOfPassengerPlane.MCDONNELL_DOUGLAS_DC10));
        Flight f7 = new Flight(Airport.LONDYN_LUTON, w2, Airport.BANGKOK_SUARNABHUMI, w1, new PlanePassenger("McDonnel",  TypeOfPassengerPlane.MCDONNELL_DOUGLAS_DC10));
        Flight f6 = new Flight(Airport.NOWY_YORK_JFK, w2, Airport.LONDYN_LUTON, w1, new PlaneCargo("McDonnel towarowy",  TypeOfCargoPlane.ANTONOV_AN_225));
        Passenger p1 = new Passenger("Filip", "92929292");
        Passenger p2 = new Passenger("Filip", "92929292");
        Passenger p3 = new Passenger("Arek", "92929294");
        Passenger p4 = new Passenger("Dominik", "92929295");
        Passenger p5 = new Passenger("Natalia", "92929296");
        Passenger p6 = new Passenger("Bozena", "92929297");
        Passenger p7 = new Passenger("Krzysiek", "92929298");

        ServiceOfAirConnectionsInterface service = new ServiceOfAirConnections();
        service.planningFlight(f1);
        service.planningFlight(f2);
        service.planningFlight(f3);
        service.planningFlight(f4);
        service.planningFlight(f5);
        service.planningFlight(f6);
        service.planningFlight(f7);
        service.addPassenger(p1, f1);
        service.addPassenger(p2, f2);
        service.addPassenger(p4, f4);
        service.addPassenger(p3, f3);
        service.addPassenger(p5, f5);
        service.addPassenger(p6, f1);
        service.addPassenger(p7, f7);
        System.out.println(service.allFlightBetweenDates(start, end));
        service.howManyFilghtsPlaneMadeInMonth(new PlanePassenger("AirbusLotu",  TypeOfPassengerPlane.AIRBUS_A300), Month.JULY);
        service.howManyPlanesServedAirportInPeriod(Airport.WARSZAWA_CHOPIN, start, end);
        service.planesAccordingToAlphabeticalOrderOfName();
        service.planesAccordingToNumberOfPassengersTransported();


    }
}
