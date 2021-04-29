package com.gridnine.testing;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterImplTest {

    private FlightFilter flightFilter = new FlightFilterImpl();
    private FlightBuilder flightBuilder = new FlightBuilder();
    private List<Flight> testFlightList = flightBuilder.createFlights();

    @Test
    void departuresUpToCurrentTime_test() {
        assertEquals(1,flightFilter.departuresUpToCurrentTime(testFlightList).size());
    }

    @Test
    void segmentsWithArrivalDateEarlierThanDepartureDate_test() {
        assertEquals(1,flightFilter.segmentsWithArrivalDateEarlierThanDepartureDate(testFlightList).size());
    }

    @Test
    void totalTimeSpentOnEarthExceedsTwoHours_test() {
        assertEquals(2,flightFilter.totalTimeSpentOnEarthExceedsTwoHours(testFlightList).size());
    }
}