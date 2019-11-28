package runner;

import model.airport.Airport;
import model.plane.MilitaryPlane;
import model.plane.PassengerPlane;
import action.AirportCreator;
import action.AirportSorting;

public class AirportRunner {
    public static void main(String[] args) {
        Airport airport = AirportCreator.createAirportWithCredentials();

        Airport militaryAirport = new Airport(airport.getPlanesOfCertainType(MilitaryPlane.class));
        Airport passengerAirport = new Airport(airport.getPlanesOfCertainType(PassengerPlane.class));

        AirportSorting.sortPlanesByMaxDistance(militaryAirport);
        System.out.println("Military airport sorted by max distance: " + militaryAirport);

        AirportSorting.sortPlanesByMaxSpeed(passengerAirport);
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport);

        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}