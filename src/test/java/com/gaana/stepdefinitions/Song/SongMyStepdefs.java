package com.gaana.stepdefinitions.Song;

import com.gaana.automation.util.GenericMethod;
import com.gaana.pageobjects.Playlist.PlaylistPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import com.gaana.pageobjects.Song.SongPO;
import com.gaana.test.base.PageObjectWrapper;
import org.testng.Assert;


import static org.testng.Assert.assertTrue;

public class SongMyStepdefs {

    PlaylistPO playlistPO = (PlaylistPO) PageObjectWrapper.getObject(PlaylistPO.class);
    SongPO songPO = (SongPO) PageObjectWrapper.getObject(SongPO.class);
    GenericMethod generic = new GenericMethod();


    @And("user clicks on threedot link")
    public void userClicksOnThreedotLink ()
    {
        System.out.println("inside userClicksOnThreedotLink");
        playlistPO.clickOnThreeDot();

    }

    @Then("user verifies the elements {string} on the pop up")
    public void userVerifiesTheElementsOnThePopUp(String arg0) throws InterruptedException{
        Assert.assertEquals(songPO.getElementsFromThreeDotPopup().toArray(),songPO.stringToArray(arg0));
    }

    @Then("user clicks on first trending song")
    public void user_clicks_on_first_trending_song() throws InterruptedException {
        songPO.clickTrendingFirstSong();
    }

    @Then("user clicks on favourite button")
    public void user_clicks_on_favourite_button() {
       songPO.clickFavouriteIconForSong();

    }

    @Then("verifies favourite song is present inside the {string} section")
    public void verifies_favourite_song_is_present_inside_the_section(String string) throws InterruptedException {
        System.out.println("string  "+string);
        assertTrue(songPO.checkSongInsideFavouriteSection(string));

    }


    @And("user clicks on first artist")
    public void userClicksOnFirstArtist() {

        songPO.clickFirstArtistLink();
    }

    @And("user clicks on favourite button on artist page")
    public void userClicksOnFavouriteButtonOnArtistPage() {
       // songPO.clickFavouriteIconForArtist();
    }
}
