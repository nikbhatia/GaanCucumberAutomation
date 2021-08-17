package com.gaana.stepdefinitions.Song;

import com.gaana.automation.util.GenericMethod;
import com.gaana.pageobjects.Home.HomePO;
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
    HomePO homePO = (HomePO) PageObjectWrapper.getObject(HomePO.class);

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
        assertTrue(songPO.checkSongInsideFavouriteSection(string));

    }


    @And("user clicks on first artist")
    public void userClicksOnFirstArtist() {
        songPO.clickFirstArtistLink();
    }


    @Then("user clicks on language")
    public void userClicksOnLanguage() {
        songPO.clickOnLanguage();

    }


    @Then("user verifies the languages {string} on the language pop up")
    public void userVerifiesTheLanguagesOnTheLanguagePopUp(String arg0) {
        assertTrue(songPO.validateLanguage(arg0), "languages are not in the proper order or updated "+arg0);

    }

    @Then("user verifies update button gets disabled on unselecting all the selected languages")
    public void userVerifiesUpdateButtonGetsDisabledOnUnselectingAllTheSelectedLanguages() {
        assertTrue(songPO.checkUpdateButton(),"Update button is still active");


    }

    @Then("user verifies submitted language is selected on opening the language pop up")
    public void userVerifiesSubmittedLanguageIsSelectedOnOpeningTheLanguagePopUp() {
        assertTrue(songPO.checkSelectedLanguage(),"updated language is not visible");
    }


    @Then("user navigates to display and language tab in settings section")
    public void userNavigatesToDisplayAndLanguageTabInSettingsSection() {
        songPO.displayLanTab();
    }

    @Then("user verifies language selected in display and language section")
    public void userVerifiesLanguageSelectedInDisplayAndLanguageSection() throws InterruptedException {
        assertTrue(songPO.langSelectedInDisplayLangTab(),"selected language shown in settings display language tab section is incorrect");
    }
}
