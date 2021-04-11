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
    private By eleSectionHeading = By.xpath("//section[@class='caro caro_sqr mWrap']//strong");
    private By eleGaanaTagline = By.xpath("//strong[contains(text(),'${heading}')]");
    private By eleFirstPodcast = By.xpath("(//a[contains(@class,\"img default_bg\")])[1]");
    private By btnPlayPodcast = By.xpath("//button[contains(text(),'Play')]");
    private By elePodcastPlayTime = By.xpath("//span[@class=\"_a\"]");
    private By btnPausePlayer = By.xpath("//button[@class='play']/*[@viewBox='0 0 24 24']");
    private By eleSections = By.xpath("//div[contains(@class,\"caro_container\")]");
    private By elePodcastName = By.xpath("//div[@class='_a']//strong");
    private By elePodcastTitleBreadcrumb = By.xpath("//span[@class='_title']");
    private By btnMarkFavPodcast = By.xpath("//button[contains(@class ,\"icon sm-hide\")]/*[@class='fav ']");
    private By btnUnmarkPodcastFav = By.xpath("//button[contains(@class ,\"icon sm-hide\")]/*[@class='fav checked']");
    private By btnUnmarkPodcastEpisodeFav = By.xpath("(//button[contains(@class ,\"_btn _fav sm-hide\")])[1]/*[@class='fav checked']");
    private By btnMarkPodcastEpisodeFav = By.xpath("(//button[contains(@class ,\"_btn _fav sm-hide\")])[1]/*[@class='fav ']");
    private By eleSeasonPodcast = By.xpath("//small[contains(text(),\"Season 1\")]");
    private By elePodcastEpisodeListHeading = By.xpath("//div[contains(text(),'${heading}')]");
    private By eleSortingHeading = By.xpath("//span[contains(text(),'Sort by: ')]");
    private By eleSortOldestFirst = By.xpath("//li[contains(text(),'Oldest First')]");
    private By eleDateFirstEpisode = By.xpath("(//div[@class=\"col col_3 sm-hide\"])[1]");
    private By eleNewestFirst = By.xpath("//li[contains(text(),'Newest First')]");





    /**
     * This method use to verify sorting on Podcast page
     *
     * @return true if sorting working fine
     * @return false if sorting is not working correctly
     * @author nikhil.bhatia
     */
    public boolean verifySorting() throws ParseException {
        boolean flag = false;
        if(isDisplayed(eleSortingHeading)){
            String date1 =  getText(eleDateFirstEpisode);
            click(eleSortingHeading);
            click(eleSortOldestFirst);
            wait.hardWait(3);
            String date2 =  getText(eleDateFirstEpisode);
            System.out.println(date2);
            if(compareDate(date1,date2)>0){
                flag = true;
            }
            else flag = false;
            TestNGLogUtility.info("sorting for oldest first working fine "+flag);
            click(eleSortingHeading);
            click(eleNewestFirst);
            wait.hardWait(3);
            String date3 =  getText(eleDateFirstEpisode);
            if(compareDate(date2,date3)<0){
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
        if(date1.compareTo(date2) >= 0)
        {
            return 1;
        }
        else if(date1.compareTo(date2) <= 0)
        {
            return -1;
        }
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
        wait.hardWait(10);
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
        wait.waitForElementToBeClickable(btnMarkFavPodcast);
        click(btnMarkFavPodcast);
        wait.waitForVisibilityOfElement(btnUnmarkPodcastFav);
        return isDisplayed(btnUnmarkPodcastFav);

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
