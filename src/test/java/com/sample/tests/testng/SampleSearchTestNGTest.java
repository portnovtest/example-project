package com.sample.tests.testng;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.SearchPage;
import com.sample.tests.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SampleSearchTestNGTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "inclass_provider")
    public Object[][] createData(){
        return new Object[][] {
                {"London", true},
                {"Manchester", false},
        };
    }

    public static class StaticProvider {
        @DataProvider(name = "sample_provider")
        public static Object[][] staticData(){
            return new Object[][] {
                    {"Leeds", true},
                    {"Newcastle", false},
            };
        }
    }

    private void sampleSearch(String destination, boolean isBusiness) throws Exception {
        SearchPage searchPage = PageFactory.init(driver, SearchPage.class);

        searchPage.editDestination.setText(destination);
        searchPage.buttonDownShevron.click();
        searchPage.displayDates.click();
        searchPage.buttonTodaysDate.click();
        SearchResultsPage searchResultsPage = searchPage.setTravelPurpose(isBusiness).buttonSubmit.click(SearchResultsPage.class);
        searchResultsPage.editDestination.click();
        assertTrue(searchResultsPage.isTextPresent(destination));
        searchResultsPage.captureScreenShot("./image-" + destination + ".png");
    }

    @Test(dataProvider = "inclass_provider")
    public void testSampleSearchFromTheSameClass(String destination, boolean isBusiness) throws Exception {
        sampleSearch(destination, isBusiness);
    }
    @Test(dataProvider = "sample_provider", dataProviderClass = StaticProvider.class)
    public void testSampleSearchClassProvider(String destination, boolean isBusiness) throws Exception {
        sampleSearch(destination, isBusiness);
    }
}
