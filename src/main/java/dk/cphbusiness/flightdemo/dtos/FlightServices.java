package dk.cphbusiness.flightdemo.dtos;

import java.time.Duration;
import java.util.List;

public class FlightServices {

    public static Duration getFlightTime(List<FlightInfoDTO> flights, String airline){
        return Duration.ofSeconds(
                flights.stream()
                        .filter(f ->f.getAirline() != null && f.getAirline().equalsIgnoreCase(airline))
                        .mapToLong(f->f.getDuration().getSeconds())
                        .sum()
        );
    }

    public static List<FlightInfoDTO> getFlightsAirport(List<FlightInfoDTO> flights, String airportA, String airportB){
        return flights.stream()
                .filter(f -> f.getOrigin() != null && f.getDestination() != null)
                .filter(f ->
                        (f.getOrigin().equalsIgnoreCase(airportA) && f.getDestination().equalsIgnoreCase(airportB)) || (f.getOrigin().equalsIgnoreCase(airportB) && f.getDestination().equalsIgnoreCase(airportA)))
                .distinct()
                .toList();
    }
}
