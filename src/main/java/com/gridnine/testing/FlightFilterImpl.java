package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterImpl implements FlightFilter {

    private final long HOURS_BETWEEN_FLIGHTS = 7200L;

    @Override
    public void viewFlights(List<Flight> flights) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        for (Flight flight : flights) {
            for (int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println("Flight number: " + flight.getId() + "\n"
                  + "Departure time: " + dateTimeFormatter.format(flight.getSegments().get(i).getDepartureDate()) + "\n"
                  + "Arrival time: " + dateTimeFormatter.format(flight.getSegments().get(i).getArrivalDate()) + "\n"
                  + "------------------------------");
            }
        }
    }

    @Override
    public List<Flight> departuresUpToCurrentTime(List<Flight> flights) {
        List<Flight> departuresList = new ArrayList<>();
        LocalDateTime departuresDateNow = LocalDateTime.now();

        for (Flight flight : flights) {
//            Это первый вариант, через for i
//            for (int i = 0; i < flight.getSegments().size(); i++) {
//                if (flight.getSegments().get(i).getDepartureDate().isBefore(departuresDateNow)) {
//                    departuresList.add(flight);
//                }
            if (flight.getSegments().stream().anyMatch(
                    segment -> segment.getDepartureDate().isBefore(departuresDateNow))) {
                departuresList.add(flight);
            }
        }
        return departuresList;
    }

    @Override
    public List<Flight> segmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights) {
        List<Flight> departuresList = new ArrayList<>();

        for (Flight flight : flights) {
//            Это первый вариант, через for i
//            for (int i = 0; i < flight.getSegments().size(); i++) {
//                if (flight.getSegments().get(i).getArrivalDate().isBefore(
//                                          flight.getSegments().get(i).getDepartureDate())) {
//                    departuresList.add(flight);
//                }
//            }
            if (flight.getSegments().stream().anyMatch(
                    segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))) {
                departuresList.add(flight);
            }
        }
        return departuresList;
    }

    @Override
    public List<Flight> totalTimeSpentOnEarthExceedsTwoHours(List<Flight> flights) {
        List<Flight> departuresList = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getSegments().size() >= 2) {
                long duration = 0L;
                for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                    duration += Duration.between(
                            flight.getSegments().get(i).getArrivalDate(),
                            flight.getSegments().get(i + 1).getDepartureDate()).getSeconds();
                }
                if (duration > HOURS_BETWEEN_FLIGHTS) {
                    departuresList.add(flight);
                }
            }
        }
        return departuresList;
    }
}
