package com.gaana.stepdefinitions.Song;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import com.gaana.pageobjects.Song.SongPO;
import com.gaana.test.base.PageObjectWrapper;
import org.testng.Assert;

public class SongMyStepdefs {


    SongPO songPO = (SongPO) PageObjectWrapper.getObject(SongPO.class);

    @And("user clicks on threedot link")
    public void userClicksOnThreedotLink ()
    {
        System.out.println("inside userClicksOnThreedotLink");
        songPO.clickthreedot();

    }

    @Then("user verifies the elements {string} on the pop up")
    public void userVerifiesTheElementsOnThePopUp(String arg0) throws InterruptedException{

        System.out.println("inside userVerifiesTheElementsOnThePopUp");
        Assert.assertEquals(songPO.stringToArray(arg0),songPO.getelementsfromthreedotpopup().toArray());
    }
}
