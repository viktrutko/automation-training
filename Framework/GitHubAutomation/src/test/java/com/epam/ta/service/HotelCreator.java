package com.epam.ta.service;

import com.epam.ta.model.Hotel;

public class HotelCreator {

    public static final String TESTDATA_HOTEL_PLACE = "testdata.hotel.place";
    public static final String TESTDATA_HOTEL_ROOMS_NUMBER = "testdata.hotel.roomsNumber";
    public static final String TESTDATA_HOTEL_ARRIVAL_DATE = "testdata.hotel.arrivalDate";
    public static final String TESTDATA_HOTEL_DEPARTURE_DATE = "testdata.hotel.departureDate";
    public static final String TESTDATA_HOTEL_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE = "testdata.hotel.departureDateBeforeArrivalDate";
    public static final String TESTDATA_HOTEL_DEPARTURE_DATE_FOR_LONG_STAY = "testdata.hotel.departureDateForLongStay";
    public static final String TESTDATA_HOTEL_NONEXISTENT_PLACE = "testdata.hotel.nonexistentPlace";
    public static final String TESTDATA_HOTEL_ARRIVAL_DATE_YESTERDAY = "testdata.hotel.arrivalDateYesterday";
    public static final String TESTDATA_HOTEL_DEPARTURE_DATE_YESTERDAY = "testdata.hotel.departureDateYesterday";
    public static final String TESTDATA_HOTEL_ARRIVAL_DATE_WITHOUT = "testdata.hotel.arrivalDateWithout";
    public static final String TESTDATA_HOTEL_DEPARTURE_DATE_WITHOUT = "testdata.hotel.departureDateWithout";
    public static final String TESTDATA_HOTEL_ROOMS_NUMBER_GROUP = "testdata.hotel.roomsNumberGroup";


    public static Hotel withCredentialsFromProperty(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel withDepartureDateBeforeArrivalDate(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel forLongStay(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE_FOR_LONG_STAY),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel withNonexistentPlace(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_NONEXISTENT_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel withYesterdayDate(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE_YESTERDAY),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE_YESTERDAY),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel withoutDepartureDate(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE_WITHOUT),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }

    public static Hotel forGroup(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER_GROUP)));
    }

    public static Hotel withoutArrivalAndDepartureDate(){
        return new Hotel(TestDataReader.getTestData(TESTDATA_HOTEL_PLACE),
                TestDataReader.getTestData(TESTDATA_HOTEL_ARRIVAL_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_HOTEL_DEPARTURE_DATE_WITHOUT),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_ROOMS_NUMBER)));
    }
}
