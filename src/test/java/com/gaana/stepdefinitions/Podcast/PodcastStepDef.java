package com.gaana.stepdefinitions.Podcast;

import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.pageobjects.Podcast.PodcastPO;
import com.gaana.test.base.BaseAutomation;
import com.gaana.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.text.ParseException;

public class PodcastStepDef extends BaseAutomation{


    PodcastPO podcastPO = (PodcastPO) PageObjectWrapper.getObject(PodcastPO.class);


    @And("user verifies {string} with value {string}")
    public void validatePresenceOfElements(String label, String value){
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(label,value),"label"+label );
        TestNGLogUtility.pass("label " + label );
        TestNGLogUtility.pass("value " + value);
    }

    @And("user verifies {string} with value {string} {string}")
    public void validatePresenceOfElements(String label, String value,String value1){
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(label,value),"label"+label );
        TestNGLogUtility.pass("label :" + label + "value :" + value);
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(label,value1),"label"+label );
        TestNGLogUtility.pass("label :" + label + "value :" + value);
    }

    @Then("user verifies Sections and its headings")
    public void verifySectionHeadings(){
     Assert.assertTrue(podcastPO.verifySectionHeadings(),"Sections heading is missing");
     TestNGLogUtility.pass("Number of sections and their headings are intact");
    }


    @Then("user clicked on first podcast")
    public void clickOnFirstPodcast() throws ParseException {
        podcastPO.clickOnFirstPodcast();
        TestNGLogUtility.info("User clicked on first podcast");
    }

    @And("user verifies podcast heading and breadcrumb for podcast")
    public void verifyPodcastName(){
        Assert.assertTrue(podcastPO.verifyTitleForPodcastInBreadcrumb(),"Podcast name in Heading and Breacrumb are different");
        TestNGLogUtility.pass("Podcast name in Heading and Breacrumb are same");
    }

    @Then("user played the podcast")
    public void clickOnPlayButton(){
        podcastPO.clickOnPlayPodcastPage();
        TestNGLogUtility.info("User clicked on play podcast");
    }

    @And("user verifies podcast is being played")
    public void verifyPodcastBeingPlayed(){
        Assert.assertTrue(podcastPO.verifyPodcastPlayed(),"Podcast is not being played");
        TestNGLogUtility.pass("Podcast is being played");
    }

    @And("user verifies {string} with value {string} {string} {string}")
    public void validatePresenceOfElements(String label, String value1,String value2,String value3) {
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(label, value1), "label" + label);
        TestNGLogUtility.pass("label :" + label + "value :" + value1);
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(label, value2), "label" + label);
        TestNGLogUtility.pass("label :" + label + "value :" + value2);
        Assert.assertTrue(podcastPO.validatePresenceOfElementsOnPodcastPage(value3, value1), "label" + label);
        TestNGLogUtility.pass("label :" + label + "value :" + value3);
    }

    @And("user verifies sorting is working correctly")
    public void verifySorting() throws ParseException {
        Assert.assertTrue(podcastPO.verifySorting(),"sorting is not working correctly");
        TestNGLogUtility.pass("Sorting is working correctly");
    }

    @Then("user mark podcast as favourite")
    public void verifyFavouritePodcastPage(){
        Assert.assertTrue(podcastPO.markPodcastFavourite());
    }

    @Then("user verify podcast is availble in list of fav podcast")
    public void verifyMarkedFavPodcast(){
        Assert.assertTrue(podcastPO.verifyFavPodcast());
    }





}
