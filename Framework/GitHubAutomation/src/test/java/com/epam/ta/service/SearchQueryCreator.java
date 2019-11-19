package com.epam.ta.service;

import com.epam.ta.model.SearchQuery;

public class SearchQueryCreator {

    public static final String TESTDATA_SEARCHQUERY_PLACE = "testdata.searchQuery.place";
    public static final String TESTDATA_SEARCHQUERY_ARRIVAL_DATE = "testdata.searchQuery.arrivalDate";
    public static final String TESTDATA_SEARCHQUERY_DEPARTURE_DATE = "testdata.searchQuery.departureDate";
    public static final String TESTDATA_SEARCHQUERY_TRAVELING_PERSON = "testdata.searchQuery.travelingPersons";
    public static final String TESTDATA_SEARCHQUERY_PLACE_NONEXISTENT = "testdata.searchQuery.placeNonexistent";


    public static SearchQuery withCredentialsFromProperty(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON));
    }

    public static SearchQuery withEmptyPlace(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON));
    }

    public static SearchQuery withNonexistent(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_SEARCHQUERY_PLACE_NONEXISTENT),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_SEARCHQUERY_TRAVELING_PERSON));
    }
}
