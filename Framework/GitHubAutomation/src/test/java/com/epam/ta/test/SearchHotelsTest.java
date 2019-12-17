package com.epam.ta.test;

import com.epam.ta.model.SearchQuery;
import com.epam.ta.page.HomeHRSPage;
import com.epam.ta.service.SearchQueryCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class SearchHotelsTest extends CommonConditions {

    @Test
    public void thereIsMessageOfEmptyPlace()
    {
        SearchQuery searchQuery = SearchQueryCreator.withEmptyPlace();
        String messageOfEmptyPlaceError = new HomeHRSPage(driver)
                .openPage()
                .searchHotelWithEmptyPlace(searchQuery)
                .messageOfEmptyPlaceError();

        assertThat(messageOfEmptyPlaceError, is(equalTo("Введите пункт назначения.")));
    }

    @Test
    public void thereIsMessageNonexistentPlace()
    {
        SearchQuery searchQuery = SearchQueryCreator.withNonexistent();
        String messageOfNonexistantPlaceError = new HomeHRSPage(driver)
                .openPage()
                .searchHotelWithTermsAndDefaultDate(searchQuery)
                .messageOfNonexistantPlaceError();

        assertThat(messageOfNonexistantPlaceError, is(equalTo("Примечание")));
    }

    @Test
    public void searchHotelWithDifferentNumberOfRoomsAndPersons(){
        SearchQuery searchQuery = SearchQueryCreator.withDifferentNumberOfRoomsAndPersons();
        String messageOfDifferentNumberOfRoomsAndPersons = new HomeHRSPage(driver)
                .openPage()
                .searchOfDifferentNumberOfRoomsAndPersons(searchQuery)
                .messageOfDifferentNumberOfRoomsAndPersonsError();
        assertThat(messageOfDifferentNumberOfRoomsAndPersons,is(equalTo("Число комнат не соответствует числу проживающих.")));
    }

    @Test
    public void searchHotelWithEmptyNumberOfRooms(){
        SearchQuery searchQuery = SearchQueryCreator.withEmptyNumberOfRooms();
        String messageOfEmptyNumberOfRooms = new HomeHRSPage(driver)
                .openPage()
                .searchNumberOfRoomsAndPersons(searchQuery)
                .messageOfEmptyNumberOfRoomsError();
        assertThat(messageOfEmptyNumberOfRooms,is(equalTo("Введите необходимое число комнат.")));
    }
}

