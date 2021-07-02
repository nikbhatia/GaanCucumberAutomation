package com.gaana.pageobjects.Podcast;


import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Podcast Generic Functions
 *
 * @author nikhil.bhatia
 */

public class PodcastPO extends BaseAutomation {

    private By eleBreadcrumbTitle = By.xpath("//span[contains(text() ,'${title}')]");
    private By elePodcast = By.xpath("//h2[contains(text(),'${heading}')]");
    private By eleSectionHeading = By.xpath("//section[contains(@class,'caro caro_sqr mWrap')]//h2");
    private By eleGaanaTagline = By.xpath("//strong[contains(text(),'${heading}')]");
    private By eleFirstPodcast = By.xpath("(//a[contains(@class,\"img default_bg\")])[1]");
    private By btnPlayPodcast = By.xpath("//button[contains(text(),'Play')]");
    private By elePodcastPlayTime = By.xpath("//span[@class=\"_a\"]");
    private By btnPausePlayer = By.xpath("//button[@class='play playing']/*[@viewBox='0 0 24 24']");
    private By eleSections = By.xpath("//div[contains(@class,\"caro_container\")]");
    private By elePodcastName = By.xpath("//h1[@class='title']");
    private By elePodcastTitleBreadcrumb = By.xpath("//span[@class='_title']");
    private By btnMarkFavPodcast = By.xpath("//button[@title='Follow' and @id ='playVBtn' ]");
    private By btnUnmarkPodcastFav = By.xpath("//button[@title=\"Following\"]");
    private By btnUnmarkPodcastEpisodeFav = By.xpath("(//button[contains(@class ,\"_btn _fav sm-hide\")])[1]/*[@class='fav checked']");
    private By btnMarkPodcastEpisodeFav = By.xpath("(//button[contains(@class ,\"_btn _fav sm-hide\")])[1]/*[@class='fav ']");
    private By eleSeasonPodcast = By.xpath("//small[contains(text(),\"Season 1\")]");
    private By elePodcastEpisodeListHeading = By.xpath("//li[contains(text(),'${heading}')]");
    private By elePodcastDurationHeading = By.xpath("//li[contains(text(),'${heading}')]");
    private By eleSortingDropdown = By.xpath("//div[contains(@class,'cust_dropdown _col')]");
    private By eleSortOldestFirst = By.xpath("//li[contains(text(),'Oldest First')]");
    private By eleDateFirstEpisode = By.xpath("(//li[@class=\"_ply sm-hide _plyCr\"])[1]");
    private By eleNewestFirst = By.xpath("//li[contains(text(),'Newest First')]");
    private By eleFavPodcastMyMusic = By.xpath("//strong[contains(text(),'Favourite Podcasts')]");
    private By eleSeeAllFavPodcast = By.xpath("//a[contains(@href,'/myfavoritepodcasts')]/span");
    private By eleEntityMarkedFav = By.xpath("//a[@class=\"al t_over\" and contains(text() ,\"Ep 1 - Himachal\")]");
    private By eleNameFavPodcast = By.xpath("//a[@title=\"All Things Music with Sarthak\"]");




    /**
     * This method use to verify sorting on Podcast page
     *
     * @return true if sorting working fine
     * @return false if sorting is not working correctly
     * @author nikhil.bhatia
     */
    public boolean verifySorting() throws ParseException {
        boolean flag = false;
        if(isDisplayed(eleSortingDropdown)){
            String date1 =  getText(eleDateFirstEpisode);
            click(eleSortingDropdown);
            click(eleSortOldestFirst);
            wait.hardWait(3);
            String date2 =  getText(eleDateFirstEpisode);
            System.out.println(date2);
            if(compareDate(date1,date2) ==1){
                flag = true;
            }
            else flag = false;
            TestNGLogUtility.info("sorting for oldest first working fine "+flag);
            click(eleSortingDropdown);
            click(eleNewestFirst);
            wait.hardWait(3);
            String date3 =  getText(eleDateFirstEpisode);
            if(compareDate(date2,date3)==1){
                TestNGLogUtility.info("sorting for Newest first working fine "+flag);
                return flag && true;
            }
            else{
                TestNGLogUtility.info("issue with sorting for Newest first  "+flag);
                return false;
            }

        }
        return false;
    }


    /**
     * This method use to compare dates
     *
     * @param str1,str2 dates in string format for comparison
     * @return int
     * @author nikhil.bhatia
     */
    public int compareDate(String str1, String str2) throws ParseException {
        str1 = str1.replaceAll(" ","-").replace(",","");
        str2 = str2.replaceAll(" ","-").replace(",","");
        System.out.println(str1);
        System.out.println(str2);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        if(date1.compareTo(date2) != 0)
        {
            return 1;
        }
//        else if(date1.compareTo(date2) <= 0)
//        {
//            return -1;
//        }
        return 0;
    }


    /**
     * This method use to verify presence of elements on Podcast page
     *
     * @param labelName Present on the page
     * @param value
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean validatePresenceOfElementsOnPodcastPage(String labelName, String value) {
        boolean flag = false;
        switch (labelName.toString()) {

            case "Episode Headings":
                if(isDisplayed(eleSeasonPodcast)) {
                    flag = isDisplayed(parameterizedLocator(elePodcastEpisodeListHeading, value));
                    TestNGLogUtility.info(getText(parameterizedLocator(elePodcastEpisodeListHeading, value)));
                }
                else return false;
                break;
            case "Duration":
                if(isDisplayed(eleSeasonPodcast)) {
                    flag = isDisplayed(parameterizedLocator(elePodcastDurationHeading, value));
                    TestNGLogUtility.info(getText(parameterizedLocator(elePodcastDurationHeading, value)));
                }
                else return false;
                break;
            case "Breadcrumb Title":
                flag = isDisplayed(parameterizedLocator(eleBreadcrumbTitle, value));
                TestNGLogUtility.info(getText(parameterizedLocator(eleBreadcrumbTitle, value)));
                break;
            case "Page Heading":
                flag = isDisplayed(parameterizedLocator(elePodcast, value));
                TestNGLogUtility.info(getText(parameterizedLocator(elePodcast, value)));
                break;
            case "Gaana Tagline":
                jsUtil.scrollToElement(parameterizedLocator(eleGaanaTagline, value));
                flag = isDisplayed(parameterizedLocator(eleGaanaTagline, value));
                TestNGLogUtility.info(getText(parameterizedLocator(eleGaanaTagline, value)));
                break;
        }
        return flag;
    }

    /**
     * This method use to verify sections and their headings
     *
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifySectionHeadings() {
        if (getElements(eleSections).size() == getElements(eleSectionHeading).size()) {
            return true;
        }
        return false;
    }

    /**
     * This method use to click on first podcast
     *
     * @author nikhil.bhatia
     */
    public void clickOnFirstPodcast() {
        click(eleFirstPodcast);
        wait.waitForPageToLoadCompletely();
    }

    /**
     * This method use to click on first podcast
     *
     * @author nikhil.bhatia
     */
    public void clickOnPlayPodcastPage() {
        wait.waitForVisibilityOfElement(btnPlayPodcast);
        wait.hardWait(8);
        click(btnPlayPodcast);
        wait.hardWait(4);
    }


    /**
     * This method use to verify if podcast is being played
     *
     * @author nikhil.bhatia
     */
    public boolean verifyPodcastPlayed() {
        wait.waitForVisibilityOfElement(btnPausePlayer);
        wait.hardWait(4);
        if (isDisplayed(btnPausePlayer)) {
            System.out.println(getText(elePodcastPlayTime));
            if(getText(elePodcastPlayTime)=="00:00"){
                wait.hardWait(4);
            }
            if (!getText(elePodcastPlayTime).equalsIgnoreCase("00:00")) {
                return true;
            }
        }
        return false;
    }


    /**
     * This method use to verify podcast name in heading and breadcrumb
     *
     * @author nikhil.bhatia
     */
    public boolean verifyTitleForPodcastInBreadcrumb() {
        if (getText(elePodcastName).equalsIgnoreCase(getText(elePodcastTitleBreadcrumb))) {
            return true;
        }
        return false;
    }


    /**
     * This method use to mark podcast favourite
     *
     * @author nikhil.bhatia
     */
    public boolean markPodcastFavourite() {
        if(isDisplayed(btnMarkFavPodcast)) {
            click(btnMarkFavPodcast);
            return isDisplayed(btnUnmarkPodcastFav);
        }
        else if(isDisplayed(btnUnmarkPodcastFav)){
        click(btnUnmarkPodcastFav);
        wait.hardWait(2);
        click(btnMarkFavPodcast);
        wait.waitForVisibilityOfElement(btnUnmarkPodcastFav);
        return isDisplayed(btnUnmarkPodcastFav);
    }
    return false;}

    /**
     * This method use to verify favourite podcast displayed on my music page
     *
     * @author nikhil.bhatia
     */
    public boolean verifyMarkedFavPodcast(){
        jsUtil.scrollToElement(eleFavPodcastMyMusic);
        click(eleSeeAllFavPodcast);
return true; // will update
    }


    public boolean verifyFavPodcast(){
       return isDisplayed(eleNameFavPodcast);
    }


    /**
     * This method use to unmark podcast favourite
     *
     * @author nikhil.bhatia
     */
    public boolean unmarkPodcastFavourite() {
        wait.waitForElementToBeClickable(btnUnmarkPodcastFav);
        click(btnUnmarkPodcastFav);
        wait.waitForVisibilityOfElement(btnMarkFavPodcast);
        return isDisplayed(btnMarkFavPodcast);

    }

}
