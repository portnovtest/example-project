package com.sample.tests.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.SearchPage;
import com.sample.tests.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class SampleSearchTest {

    private WebDriver driver;
    private String destination;
    private boolean isBusiness;

    public SampleSearchTest(String destination, boolean isBusiness) {
        super();
        this.destination = destination;
        this.isBusiness = isBusiness;
    }

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
                new Object[][]{
                        {"London", true},
                        {"Manchester", false},
                }
        );
    }

    @Test
    public void testSampleSearch() throws Exception {
        SearchPage searchPage = PageFactory.init(driver, SearchPage.class);

        searchPage.editDestination.setText(destination);
        searchPage.buttonDownShevron.click();
        searchPage.displayDates.click();
        searchPage.buttonTodaysDate.click();
        searchPage.setTravelPurpose(isBusiness);
        SearchResultsPage searchResultsPage = searchPage.buttonSubmit.click(SearchResultsPage.class);
        searchResultsPage.editDestination.click();
        assertTrue(searchResultsPage.isTextPresent(destination));
        searchResultsPage.captureScreenShot("./image-" + destination + ".png");
    }
}
