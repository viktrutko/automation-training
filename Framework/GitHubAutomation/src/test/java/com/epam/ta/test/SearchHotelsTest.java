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

    @Test
    public void searchHotelWhenDepartureDateBeforeArrivalDate(){
        SearchQuery testSearchQueryMain = SearchQueryCreator.withDepartureDateBeforeArrivalDate();
        String resultArrivalDate = new HomeHRSPage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQueryMain)
                .changedDepartureDateTerm();
        assertThat(resultArrivalDate, is(equalTo("18/01/2020")));
    }

    @Test
    public void searchHotelMoreChildrenThanRooms(){
        SearchQuery searchQuery = SearchQueryCreator.withMoreChildrenThanRooms();
        String messageOfMoreChildrenThanRooms = new HomeHRSPage(driver)
                .openPage()
                .searchMoreChildrenThanRooms(searchQuery)
                .messageOfMoreChildrenThanRoomsError();
        assertThat(messageOfMoreChildrenThanRooms,is(equalTo("Возможно размещение только 2 детей в двухместном номере.")));
    }

    @Test
    public void searchHotelChildrenAge(){
        SearchQuery searchQuery = SearchQueryCreator.withMoreChildrenThanRooms();
        String messageOfChildrenAge = new HomeHRSPage(driver)
                .openPage()
                .searchChildrenAge(searchQuery)
                .messageOfChildrenAgeError();
        assertThat(messageOfChildrenAge,is(equalTo("Укажите возраст сопровождающих Вас детей.")));
    }
    @Test
    public void searchHotelWithEmptyNumberOfPerson(){
        SearchQuery searchQuery = SearchQueryCreator.withEmptyNumberOfPerson();
        String messageOfEmptyNumberOfPerson = new HomeHRSPage(driver)
                .openPage()
                .searchNumberOfRoomsAndPersons(searchQuery)
                .messageOfDifferentNumberOfRoomsAndPersonsError();
        assertThat(messageOfEmptyNumberOfPerson,is(equalTo("Число комнат не соответствует числу проживающих.")));
    }

}

