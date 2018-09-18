package com.dft;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class ServiceOfAirConnections implements ServiceOfAirConnectionsInterface {

    //  mozna by bylo zrobic jeszcze sety lotow ZREALIZOWANYCH i ANULOWANYCH i podpiero na tej podstawie zapisywac loty do roznych kolekcji
    private Set<Flight> setOfFlights = new HashSet<>();
    private Map<Flight, Set<Passenger>> mapOfPassengers = new HashMap<>();

    // w konstruktorze przygotowujemy miejsce (puste sety) na pasazerow, COS TO PRZYGOTOWYWANIE NIE DZIALA, MUSZE ZROBIC PIERWSZY SET W METODZIE addPassenger
    public ServiceOfAirConnections() {
        System.out.println("Ukatywniono obsluge polaczen lotniczych\n");
//        for (Flight f : setOfFlights) {
//            mapOfPassengers.put(f, new HashSet<>());
//        }
    }

    @Override
    public boolean planningFlight(Flight flight) {
        if (!setOfFlights.contains(flight)) {
            setOfFlights.add(flight);
            System.out.println("Lot " + flight + "\nzostal dodany\n");
            return true;
        }
        System.out.println("Taki lot juz istnieje, nie mozna go dodac ponownie");
        return false;
    }

    @Override
    public boolean addPassenger(Passenger passenger, Flight flight) {
        if (!mapOfPassengers.containsKey(flight)) {
            Set<Passenger> passengersSet = new HashSet<>();
            passengersSet.add(passenger);
            mapOfPassengers.put(flight, passengersSet);
            System.out.println("Pasazer " + passenger + " zostal dodany do lotu" + flight + "\n");
            return true;
        } else if (mapOfPassengers.get(flight).contains(passenger)) {
            System.out.println("Pasazer juz ma zerezerwowany ten lot, nie zostal dodany");
            return false;
        } else {
            System.out.println("Pasazer " + passenger + " zostal dodany do lotu" + flight + "\n");
            return mapOfPassengers.get(flight).add(passenger);
        }
    }

    @Override
    public int howManyPlanesServedAirportInPeriod(Airport airport, LocalDateTime start, LocalDateTime end) {
        List<Plane> planes = new LinkedList<>();
        for (Flight f : setOfFlights) {
            if (f.getDepartureAirport().equals(airport) || f.getArrivalAirport().equals(airport)) {
                if (f.getDepartureDate().isAfter(start) || f.getDepartureDate().isBefore(end) || f.getArrivalDate().isAfter(start) || f.getArrivalDate().isBefore(end)) {
                    planes.add(f.getPlane());
                }
            }
        }
        System.out.println("\nLotnisko " + airport + " w podanym okresie obsluzylo: " + planes.size() + " samolotow");
        return planes.size();
    }

    @Override
    public int howManyFilghtsPlaneMadeInMonth(Plane plane, Enum<Month> month) {
        int planesFlight = 0;
        for (Flight f : setOfFlights) {
            //nie wiem co uznac za wykonany lot, czy start czy ladowanie w danym czasie
            if (f.getPlane().equals(plane) && f.getDepartureDate().getMonth().equals(month)) {
                planesFlight++;
            }
        }
        System.out.println("\nSamolot " + plane + " wykonawal w zadanym miesiacu nastepujacy liczbe lotow: " + planesFlight);
        return planesFlight;
    }

    @Override
    public List<Flight> allFlightBetweenDates(LocalDateTime start, LocalDateTime end) {
        List<Flight> flights = new ArrayList<>();
        for (Flight f : setOfFlights) {
            if (f.getDepartureDate().isAfter(start) && f.getArrivalDate().isBefore(end)) {
                flights.add(f);
            }
        }
        Collections.sort(flights);
        System.out.println("\nWszystkie loty pomiedzy zadanymi datami: ");
        return flights;
    }

    @Override
    public Map<Plane, Integer> planesAccordingToNumberOfPassengersTransported() {
        Map<Plane, List<Integer>> map1 = new HashMap<>();
        for(Flight f : mapOfPassengers.keySet()){
            if(!map1.containsKey(f.getPlane())){
                List<Integer> set1 = new ArrayList<>();
                set1.add(mapOfPassengers.get(f).size());
                map1.put(f.getPlane(),set1);
            } else {
                map1.get(f.getPlane()).add(mapOfPassengers.get(f).size());
            }
        }
//        TreeMap gwarantuje kolejnosc, mozna potem np wykonac metode .descending()
        Map<Plane, Integer> numbersOfPassangers = new TreeMap<>();
        for(Plane p : map1.keySet()){
            int tmp = 0;
            for(Integer i : map1.get(p)){
                tmp += i;
            }
            numbersOfPassangers.put(p, tmp);
        }
        System.out.println("\nSamoloty wg ilosci przewiezionych pasazerow: ");
        System.out.println(numbersOfPassangers);
        return numbersOfPassangers;
    }

    @Override
    public List<Plane> planesAccordingToAlphabeticalOrderOfName() {
        Set<Plane> planesSet = new HashSet<>();
        for (Flight f : setOfFlights) {
            planesSet.add(f.getPlane());
        }

        List<Plane> planesList = new ArrayList<>();
        for (Plane p : planesSet) {
            planesList.add(p);
        }

        Collections.sort(planesList);
        System.out.println("\nSamoloty wg kolejnosci alfabetycznej: ");
        System.out.println(planesList);
        return planesList;

    }
}
