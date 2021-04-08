package com.gaana.pageobjects.Podcast;


import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;


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
    }


    /**
     * This method use to verify if podcast is being played
     *
     * @author nikhil.bhatia
     */
    public boolean verifyPodcastPlayed() {
        wait.waitForVisibilityOfElement(btnPausePlayer);
        wait.hardWait(8);
        if (isDisplayed(btnPausePlayer)) {
            System.out.println(getText(elePodcastPlayTime));
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
