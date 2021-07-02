package com.gaana.stepdefinitions.Search;

import com.gaana.pageobjects.Search.SearchPO;
import com.gaana.test.base.BaseAutomation;
import cucumber.api.java.en.And;
import org.testng.Assert;

public class SearchStepDef extends BaseAutomation {

    SearchPO searchPO = new SearchPO();

    @And("user search with the {string} keyword")
    public void search(String searchKeyword){
         searchPO.search(searchKeyword);
    }

    @And("verify result available for {string}")
    public void verifyHeadings(String heading){
        Assert.assertTrue(searchPO.verifyHead(heading));
    }

    @And("verify search result available for {string}")
    public void verifySearchResult(String searchResult){
        Assert.assertTrue(searchPO.verifySearchResult(searchResult));
    }


}
