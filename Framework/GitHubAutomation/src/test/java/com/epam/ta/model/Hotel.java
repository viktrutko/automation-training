package com.epam.ta.model;

import java.util.Objects;

public class Hotel {

    private String place;
    private String arrivalDate;
    private String departureDate;
    private int roomsNumber;

    public Hotel(String place, String arrivalDate, String departureDate, int roomsNumber) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomsNumber = roomsNumber;
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

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "place='" + place + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", roomsNumber=" + roomsNumber +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Hotel)) return false;
        Hotel hotel = (Hotel) object;
        return roomsNumber == hotel.roomsNumber &&
                Objects.equals(place, hotel.place) &&
                Objects.equals(arrivalDate, hotel.arrivalDate) &&
                Objects.equals(departureDate, hotel.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, arrivalDate, departureDate, roomsNumber);
    }
}
