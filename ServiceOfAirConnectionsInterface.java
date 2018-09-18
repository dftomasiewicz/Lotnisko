package com.dft;

import javax.lang.model.element.Modifier;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

public interface ServiceOfAirConnectionsInterface {
    boolean planningFlight(Flight flight);

    boolean addPassenger(Passenger passenger, Flight flight);

    int howManyPlanesServedAirportInPeriod(Airport airport, LocalDateTime start, LocalDateTime end);

    int howManyFilghtsPlaneMadeInMonth(Plane plane, Enum<Month> month);

    List<Flight> allFlightBetweenDates(LocalDateTime start, LocalDateTime end);

    Map<Plane, Integer> planesAccordingToNumberOfPassengersTransported();

    List<Plane> planesAccordingToAlphabeticalOrderOfName();


}
