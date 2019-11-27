package page;

import java.util.Objects;

public class SearchQuery {

    private String place;
    private String arrivalDate;
    private String departureDate;
    private String travelingPersons;

    public SearchQuery(String place, String arrivalDate, String departureDate, String travelingPersons) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.travelingPersons = travelingPersons;
    }

    public SearchQuery(String arrivalDate, String departureDate, String travelingPersons) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.travelingPersons = travelingPersons;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTravelingPersons() {
        return travelingPersons;
    }

    public void setTravelingPersons(String travelingPersons) {
        this.travelingPersons = travelingPersons;
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "place='" + place + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", travelingPersons='" + travelingPersons + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchQuery that = (SearchQuery) o;
        return Objects.equals(place, that.place) &&
                Objects.equals(arrivalDate, that.arrivalDate) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(travelingPersons, that.travelingPersons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, arrivalDate, departureDate, travelingPersons);
    }
}



