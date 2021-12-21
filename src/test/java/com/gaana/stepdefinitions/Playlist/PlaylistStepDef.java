package com.gaana.stepdefinitions.Playlist;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.pageobjects.Playlist.PlaylistPO;
import com.gaana.test.base.BaseAutomation;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PlaylistStepDef extends BaseAutomation{

    PlaylistPO playlistPO = (PlaylistPO) PageObjectWrapper.getObject(PlaylistPO.class);
    GenericClassMethod genericClass = new GenericClassMethod();
	
    
    @Then("user clicks on {string} link")
    public void click_on_homepage_title_link(String string) {
    	genericClass.clickOnGaanaLogo();
    	genericClass.clickOnHomeHeadingTitle(string);
    	wait.hardWait(2);
    }
    
    @Then("user clicks on {string} button")
    public void user_clicks_on_CreatePlaylist_button(String string) {
    	playlistPO.clickOnButton(string);
    }
    
    @And("user creates {string}")
    public void user_createsPlaylist(String string) throws InterruptedException {
    	assertTrue(playlistPO.validatePresenceCreatePlaylistPopup(), "Create Playlist popup is not displayed.");
        playlistPO.enterPlaylistName(string);
    	playlistPO.clickOnCPBtn();
    }
    
    @Then("user verifies the created playlist")
    public void user_verifies_the_created_playlist() throws InterruptedException {
    	assertTrue(playlistPO.validatePlaylistCreated(), "Playlist '"+PlaylistPO.playListName+"' is not created.");
    	playlistPO.clickOnCreatedPlaylist();
    	assertTrue(playlistPO.validatePlaylistCreatedHeading(), "Playlist "+PlaylistPO.playListName+" heading is incorrect.");
    	assertTrue(playlistPO.validatePlaylistCreatedTrackCount("00 Track"), "Track Count is incorrect");
    	
    }
    
    @Then("user edits the playlist name {string}")
    public void user_edits_the_playlist_name(String string) {
    	playlistPO.clickOnThreeDot();
    	playlistPO.clickOnEditPlaylist();
    	wait.hardWait(2);
    	playlistPO.clearPlaylistTextbox();
    	playlistPO.enterEditPlaylistName(string);
    	playlistPO.clickOnSaveButton();
    	assertTrue(playlistPO.validatePlaylistCreatedHeading(), "Playlist "+PlaylistPO.playListName+" heading is incorrect.");
    	assertTrue(playlistPO.validatePlaylistCreatedTrackCount("00 Track"), "Track Count is incorrect");
    	
    }
    
    @Then("user adds a song in playlist")
    public void user_adds_a_song_in_playlist() {
    	genericClass.clickOnGaanaLogo();
    	playlistPO.clickFirstTrendingSongHome();playlistPO.clickOnThreeDot();
    	playlistPO.clickOnAddToPlaylist();
    	assertTrue(playlistPO.addSongToExistingPlaylist(), "Unable to find existing playlist "+PlaylistPO.playListName);
    	
    }

    @Then("user verifies that song is added successfully in playlist")
    public void user_verifies_that_song_is_added_successfully_in_playlist() throws InterruptedException {
        playlistPO.clickOnCreatedPlaylist();
    	assertTrue(playlistPO.validatePlaylistCreatedHeading(), "Playlist "+PlaylistPO.playListName+" heading is incorrect.");
    	pageRefresh();
    	assertTrue(playlistPO.validatePlaylistCreatedTrackCount("01 Track"), "Track Count is incorrect");
    	assertTrue(playlistPO.validateTrendingSongAddedToPlaylist(), "Added Song is not displayed in the playlist.");
    }

    @Then("user deletes the playlist and verifies playlist is deleted successfully")
    public void user_deletes_the_playlist_and_verifies_playlist_is_deleted_successfully() {
    	playlistPO.clickOnThreeDot();
    	playlistPO.clickOnDeletePlaylist();
    	playlistPO.clickOnDeletePlaylistButton();
    	assertFalse(playlistPO.validatePlaylistCreated(), "Updated Playlist is not deleted successfully");
    }
    
    @Then("user deletes the added song from the playlist")
    public void user_deletes_the_added_song_from_the_playlist() {
    	playlistPO.clickOnThreeDot();
    	playlistPO.clickOnEditPlaylist();
    	assertTrue(playlistPO.validatePresenceDeleteSelectedDisabled(), "'Delete Selected button is either not displayed or is not disabled.");
    	playlistPO.clickOnSelectAll();
    	wait.hardWait(2);
    	playlistPO.clickOnDeleteSelected();
    	wait.hardWait(2);
    	playlistPO.clickOnSaveButton();

    	playlistPO.retrySongDeletePlaylist();
    }

    @Then("user verifies that song is deleted successfully from the playlist")
    public void user_verifies_that_song_is_deleted_successfully_from_the_playlist() {
    	assertTrue(playlistPO.validatePlaylistCreatedHeading(), "Playlist "+PlaylistPO.playListName+" heading is incorrect.");
    	assertTrue(playlistPO.validatePlaylistCreatedTrackCount("00 Track"), "Track Count is incorrect");
    }
    
    @Then("user clean ups the {string}")
    public void user_clean_ups_the(String string) {
        playlistPO.playlistCleanUp(string);
    }
}
