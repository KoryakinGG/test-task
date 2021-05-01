package com.gridnine.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterImplTest {

    FlightFilter flightFilter = new FlightFilterImpl();
    FlightBuilder flightBuilder = new FlightBuilder();


    @Test
    void departuresUpToCurrentTime_takeFlightsArray_thenOk() {
        List<Flight> testFlightList = flightBuilder.createFlights();
        assertEquals(1,flightFilter.departuresUpToCurrentTime(testFlightList).size());
    }

    @Test
    void segmentsWithArrivalDateEarlierThanDepartureDate_takeFlightsArray_thenOk() {
        List<Flight> testFlightList = flightBuilder.createFlights();
        assertEquals(1,flightFilter.segmentsWithArrivalDateEarlierThanDepartureDate(testFlightList).size());
    }

    @Test
    void totalTimeSpentOnEarthExceedsTwoHours_takeFlightsArray_thenOk() {
        List<Flight> testFlightList = flightBuilder.createFlights();
        assertEquals(2,flightFilter.totalTimeSpentOnEarthExceedsTwoHours(testFlightList).size());
    }
}