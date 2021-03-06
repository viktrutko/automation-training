package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomeHRSPage;
import page.SearchQuery;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SearchHotelsTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "D:\\BSU\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
    @Test
    public void thereIsMessageOfEmptyPlace()
    {
        SearchQuery searchQuery = new SearchQuery("Москва","20.01.2020","21.01.2020","1 взрослый, 1 одноместный номер");
        String messageOfEmptyPlaceError = new HomeHRSPage(driver)
                .openPage()
                .searchHotelWithEmptyPlace(searchQuery)
                .messageOfEmptyPlaceError();

        assertThat(messageOfEmptyPlaceError, is(equalTo("Введите пункт назначения.")));
    }

    @Test
    public void thereIsMessageNonexistentPlace()
    {
        SearchQuery searchQuery = new SearchQuery("Qqqqqqqqqqq","20.01.2020","21.01.2020","1 взрослый, 1 одноместный номер");
        String messageOfNonexistantPlaceError = new HomeHRSPage(driver)
                .openPage()
                .searchHotelWithTermsAndDefaultDate(searchQuery)
                .messageOfNonexistantPlaceError();

        assertThat(messageOfNonexistantPlaceError, is(equalTo("Примечание")));
    }
}
