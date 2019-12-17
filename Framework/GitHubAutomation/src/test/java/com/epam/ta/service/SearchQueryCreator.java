package com.epam.ta.service;

import com.epam.ta.model.SearchQuery;

public class SearchQueryCreator {

    public static final String TESTDATA_SEARCHQUERY_PLACE = "testdata.searchQuery.place";
    public static final String TESTDATA_SEARCHQUERY_PLACE_WITHOUT = "testdata.searchQuery.placeWithout";
    public static final String TESTDATA_SEARCHQUERY_ARRIVAL_DATE = "testdata.searchQuery.arrivalDate";
    public static final String TESTDATA_SEARCHQUERY_DEPARTURE_DATE = "testdata.searchQuery.departureDate";
    public static final String TESTDATA_SEARCHQUERY_TRAVELING_PERSON = "testdata.searchQuery.travelingPersons";
    public static final String TESTDATA_SEARCHQUERY_PLACE_NONEXISTENT = "testdata.searchQuery.placeNonexistent";
    public static final String TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS = "testdata.searchQuery.travelingPersonsOthers";
    public static final String TESTDATA_SEARCHQUERY_SINGLE_ROOM = "testdata.searchQuery.singleRoom";
    public static final String TESTDATA_SEARCHQUERY_ADULT = "testdata.searchQuery.adult";
    public static final String TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT = "testdata.searchQuery.singleRoomWithout";
    public static final String TESTDATA_SEARCHQUERY_ADULT_WITHOUT = "testdata.searchQuery.adultWithout";
    public static final String TESTDATA_SEARCHQUERY_ARRIVAL_DATE_WITHOUT = "testdata.searchQuery.arrivalDateWithout";
    public static final String TESTDATA_SEARCHQUERY_DEPARTURE_DATE_WITHOUT = "testdata.searchQuery.departureDateWithout";
    public static final String TESTDATA_SEARCHQAERY_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE="testdata.searchQuery.departureDateBeforeArrivalDate";
    public static final String TESTDATA_SEARCHQUERY_DOUBLE_ROOM_WITHOUT = "testdata.searchQuery.doubleRoomWithout";
    public static final String TESTDATA_SEARCHQUERY_CHILDREN = "testdata.searchQuery.children";



    public static SearchQuery withCredentialsFromProperty(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }

    public static SearchQuery withEmptyPlace(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }

    public static SearchQuery withNonexistent(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE_NONEXISTENT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }

    public static SearchQuery withDifferentNumberOfRoomsAndPersons(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT)));
    }

    public static SearchQuery withEmptyNumberOfRooms(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }

    public static SearchQuery withDepartureDateBeforeArrivalDate(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQAERY_DEPARTURE_DATE_BEFORE_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }
    public static SearchQuery withMoreChildrenThanRooms(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DOUBLE_ROOM_WITHOUT)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_CHILDREN)));
    }
    public static SearchQuery withEmptyNumberOfPerson(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE_WITHOUT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSONS_OTHERS),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_SINGLE_ROOM)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ADULT_WITHOUT)));
    }

}
