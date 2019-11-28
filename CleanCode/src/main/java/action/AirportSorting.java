package action;

import model.airport.Airport;
import model.plane.Plane;

import java.util.Comparator;

public class AirportSorting {

    public static void sortPlanesByMaxDistance(Airport airport) {
        airport.getPlanes().sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
    }

    public static void sortPlanesByMaxSpeed(Airport airport) {
        airport.getPlanes().sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
    }

    public static void sortPlanesByMaxLoadCapacity(Airport airport) {
        airport.getPlanes().sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
    }
}