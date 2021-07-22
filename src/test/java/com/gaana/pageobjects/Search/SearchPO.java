package com.gaana.pageobjects.Search;

import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class SearchPO extends BaseAutomation {

    private By eleSearchIcon = By.xpath("//button[@class=\"input_box\"]");
    private By eleSearchBox = By.xpath("//input[@type = \"search\"]");
    private By eleHeadPlaylist = By.xpath("//h2[contains(text() ,'${title}')]");
   private By  eleSearchResult = By.xpath("(//a[contains(@title,'${title}')])[1]");


    public void search(String keyword){
        wait.hardWait(2);
        click(eleSearchIcon);
        sendKeys(eleSearchBox,keyword);
        TestNGLogUtility.info("Search Keyword" + keyword);
    }

    public boolean verifyHead(String heading){
        wait.hardWait(4);
        scrollToElement(parameterizedLocator(eleHeadPlaylist,heading));
        return isDisplayed(parameterizedLocator(eleHeadPlaylist,heading));
    }

   public boolean verifySearchResult(String searchResult){
        wait.hardWait(4);
        return isDisplayed(parameterizedLocator(eleSearchResult,searchResult));
   }



}
