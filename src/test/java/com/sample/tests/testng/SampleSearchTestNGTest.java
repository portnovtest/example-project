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

    @Test
    public void testSampleSearch() throws Exception {
        SearchPage searchPage = PageFactory.init(driver, SearchPage.class);

        searchPage.editDestination.setText("London");
        searchPage.buttonDownShevron.click();
        searchPage.displayDates.click();
        searchPage.buttonTodaysDate.click();
        searchPage.checkBoxBusiness.click();
        SearchResultsPage searchResultsPage = searchPage.buttonSubmit.click(SearchResultsPage.class);
        searchResultsPage.editDestination.click();
        assertTrue(searchResultsPage.isTextPresent("London"));
        searchResultsPage.captureScreenShot("./image-London.png");
    }
}
