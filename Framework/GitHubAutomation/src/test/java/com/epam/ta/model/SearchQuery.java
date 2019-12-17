package com.epam.ta.model;

import java.util.Objects;

public class SearchQuery {


    private String place;
    private String arrivalDate;
    private String departureDate;
    private String travelingPersons;
    private Integer numberOfSingleRooms;
    private Integer numberOfAdults;
    private Integer numberOfDoubleRooms;
    private Integer numberOfChildren;

    public SearchQuery(String place, String travelingPersons, Integer numberOfSingleRooms, Integer numberOfDoubleRooms, Integer numberOfChildren) {
        this.place = place;
        this.travelingPersons = travelingPersons;
        this.numberOfSingleRooms = numberOfSingleRooms;
        this.numberOfDoubleRooms = numberOfDoubleRooms;
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfDoubleRooms() {
        return numberOfDoubleRooms;
    }

    public void setNumberOfDoubleRooms(Integer numberOfDoubleRooms) {
        this.numberOfDoubleRooms = numberOfDoubleRooms;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public SearchQuery(String place, String arrivalDate, String departureDate, String travelingPersons, Integer numberOfSingleRooms, Integer numberOfAdults) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.travelingPersons = travelingPersons;
        this.numberOfSingleRooms = numberOfSingleRooms;
        this.numberOfAdults = numberOfAdults;
    }


    @Override
    public String toString() {
        return "SearchQuery{" +
                "place='" + place + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", travelingPersons='" + travelingPersons + '\'' +
                ", numberOfSingleRooms=" + numberOfSingleRooms +
                ", numberOfAdults=" + numberOfAdults +
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
                Objects.equals(travelingPersons, that.travelingPersons) &&
                Objects.equals(numberOfSingleRooms, that.numberOfSingleRooms) &&
                Objects.equals(numberOfAdults, that.numberOfAdults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, arrivalDate, departureDate, travelingPersons, numberOfSingleRooms, numberOfAdults);
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

    public Integer getNumberOfSingleRooms() {
        return numberOfSingleRooms;
    }

    public void setNumberOfSingleRooms(Integer numberOfSingleRooms) {
        this.numberOfSingleRooms = numberOfSingleRooms;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

}



