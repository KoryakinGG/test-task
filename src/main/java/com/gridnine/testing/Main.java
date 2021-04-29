package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();

        System.out.println("\n-----==== The all flights ====-----\n");
        flightFilter.viewFlights(flightList);
        System.out.println("\n-----==== Departures up to the current time ====-----\n");
        flightFilter.viewFlights(flightFilter.departuresUpToCurrentTime(flightList));
        System.out.println("\n-----==== Segments with an arrival date earlier than the departure date ====-----\n");
        flightFilter.viewFlights(flightFilter.segmentsWithArrivalDateEarlierThanDepartureDate(flightList));
        System.out.println("\n-----==== The total time spent on earth exceeds two hours ====-----\n");
        flightFilter.viewFlights(flightFilter.totalTimeSpentOnEarthExceedsTwoHours(flightList));
    }
}
