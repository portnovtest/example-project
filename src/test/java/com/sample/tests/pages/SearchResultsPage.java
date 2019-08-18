package com.sample.tests.pages;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends Page {
    @FindBy(locator = "ss")
    public Edit editDestination;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
