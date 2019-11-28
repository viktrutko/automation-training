import model.airport.Airport;
import model.plane.ExperimentalPlane;
import enums.ExperimentalPlaneClassificationLevel;
import enums.MilitaryPlaneType;
import model.plane.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;
import model.plane.Plane;
import action.AirportCreator;
import action.AirportSorting;

import java.util.List;

public class AirportTest {

    @Test
    public void getTransportMilitaryPlanes() {
        Airport airport = AirportCreator.createAirportWithCredentials();
        Assert.assertTrue(airport.getMilitaryPlanesOfCertainType(MilitaryPlaneType.TRANSPORT)
                .stream()
                .allMatch(militaryPlane -> MilitaryPlaneType.TRANSPORT.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void getPassengerPlaneWithMaxCapacity() {
        PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        Airport airport = AirportCreator.createAirportWithCredentials();
        Assert.assertTrue(airport.getPassengerPlaneWithMaxPassengersCapacity()
                .equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void sortByMaxLoadCapacity() {
        Airport airport = AirportCreator.createAirportWithCredentials();
        AirportSorting.sortPlanesByMaxLoadCapacity(airport);
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean planesAreSorted = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                planesAreSorted = false;
                break;
            }
        }
        Assert.assertTrue(planesAreSorted);
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = AirportCreator.createAirportWithCredentials();
        Assert.assertTrue(airport.getMilitaryPlanesOfCertainType(MilitaryPlaneType.BOMBER)
                .stream()
                .allMatch(militaryPlane ->  MilitaryPlaneType.BOMBER.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = AirportCreator.createAirportWithCredentials();
        Assert.assertFalse(airport.getPlanesOfCertainType(ExperimentalPlane.class)
                .stream()
                .allMatch(experimentalPlane -> ExperimentalPlaneClassificationLevel.UNCLASSIFIED
                        .equals(experimentalPlane.getExperimentalPlaneClassificationLevel())));
    }
}