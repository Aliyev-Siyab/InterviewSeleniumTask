package com.ebay.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase{

    @Test
    public void searchAndVerifyItemTest(){

        app.getSelect().selectDepartment("2");
        app.getSelect().selectSection("1");
        app.getSelect().selectBrand("1");
        String secondItemName = app.getItem().getSecondItemName("2");
        app.getItem().enterItemNameToSearchBar(secondItemName);
        String firstItemName = app.getItem().getFirstItemName("1");

        app.getItem().pause(500);
        Assert.assertEquals(firstItemName,secondItemName);
    }
}

//        Open browser and maximize screen +
//        Get ebay.de +
//        Get ‘Elektronik’ + =  line-10
//        Select section ‘Handys & Smartphones’
//        Select ‘Apple’
//        Remember second element in search results
//        Enter the memorized value in the search bar
//        Find and check that the product name matches the stored value

