package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_SURNAME = "testdata.user.surname";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PHONE = "testdata.user.phone";
    public static final String TESTDATA_USER_GUEST = "testdata.user.guest";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_SURNAME),
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PHONE),
                TestDataReader.getTestData(TESTDATA_USER_GUEST));
    }
}
