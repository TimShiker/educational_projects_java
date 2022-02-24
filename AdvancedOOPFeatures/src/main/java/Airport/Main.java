package Airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // generate airport with arriving and departing planes
        Airport airport = Airport.getInstance();

        for(Flight flight: findPlanesLeavingInTheNextTwoHours(airport)){
            System.out.println(flight.toString());
        }
    }

    // method to search planes leaving in the next two hours
    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        // first find what is time now and plus 2 hours
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        LocalTime timeNow = LocalTime.now();
        LocalTime timeAfterTwoHours = LocalTime.now().plusHours(2);

        List<Flight> planesLeavingInTheNextTwoHours;

        List<Terminal> terminals = new ArrayList<>(airport.getTerminals());

        // with lambda expressions search planes leaving in the next two hours and write it in list
        planesLeavingInTheNextTwoHours = terminals.stream().flatMap(terminal -> terminal.
                getFlights().stream()).
                filter(flight -> {

                    LocalTime timeFlight = LocalTime.parse(timeFormat.format(flight.getDate()));

                    return timeFlight.isAfter(timeNow) && timeFlight.isBefore(timeAfterTwoHours) &&
                            flight.getType().equals(Flight.Type.DEPARTURE);

                }).collect(Collectors.toList());

        return planesLeavingInTheNextTwoHours;
    }

}