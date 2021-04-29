package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    void viewFlights(List<Flight> flights);
    List <Flight> departuresUpToCurrentTime(List<Flight> flights);
    List <Flight> segmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights);
    List <Flight> totalTimeSpentOnEarthExceedsTwoHours(List<Flight> flights);
}
