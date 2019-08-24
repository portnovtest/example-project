package com.sample.tests.pages;

import com.sample.framework.ui.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

@Alias("Search")
public class SearchPage extends Page {

    @Alias("Destination")
    @FindBy(locator = "ss")
    public Edit editDestination;
    @Alias("Down Shevron")
    @FindBy(locator = "css=li.c-autocomplete__item")
    public Control buttonDownShevron;
    @Alias("Display Dates")
    @FindBy(locator = "css=div.sb-date-field__display")
    public Control displayDates;
    @Alias("Today's Date")
    @FindBy(locator = "//td[contains(@class, 'c2-day-s-today')]")
    public Control buttonTodaysDate;
    @Alias("Leisure")
    @FindBy(locator = "//input[@name='sb_travel_purpose' and @value='leisure']")
    public Control checkBoxLeisure;
    @Alias("Business")
    @FindBy(locator = "//input[@name='sb_travel_purpose' and @value='business']")
    public Control checkBoxBusiness;
    @Alias("Search")
    @FindBy(locator = "//button[@type='submit']")
    public Control buttonSubmit;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage setTravelPurpose(boolean isBusiness){
        if (isBusiness){
            this.checkBoxBusiness.click();
        } else {
            //"don't click";
        }
        return this;
    }
}
