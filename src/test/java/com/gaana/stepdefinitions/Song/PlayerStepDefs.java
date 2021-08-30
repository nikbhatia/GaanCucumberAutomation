package com.gaana.stepdefinitions.Song;

import com.gaana.pageobjects.Song.PlayerPO;
import com.gaana.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;

public class PlayerStepDefs {

    PlayerPO player = (PlayerPO) PageObjectWrapper.getObject(PlayerPO.class);

    @Then("user clicks on play button")
    public void userClicksOnPlayButton() {
        player.clickPlayButton();
    }

    @Then("user verifies the player is opened")
    public void userVerifiesThePlayerIsOpened() {
        assertTrue(player.bottomPlayer(),"player is not displayed after clicking on play button of the song");

    }


    @Then("user verifies next song icon is enabled after song is played some time")
    public void userVerifiesNextSongIconIsEnabledAfterSongIsPlayedSomeTime() {
        assertTrue(player.nextSongEnabled(),"next button icon is not enabled after 40 seconds, it may be due to song does not have next song");
    }

    @Then("user verifies play option is changed to pause")
    public void userVerifiesPlayOptionIsChangedToPause() {
        assertTrue(player.playButtonVerify(),"Play button name is not changed after song is played");
    }

    @Then("user verifies the next song shown in the player is same as appearing in Queue list")
    public void userVerifiesTheNextSongShownInThePlayerIsSameAsAppearingInQueueList() {
        assertTrue(player.nextSongInQueueMatcher(),"Next song in player queue and in the queue is not same");
    }

    @Then("user verifies user able to remove song from the queue list")
    public void userVerifiesUserAbleToRemoveSongFromTheQueueList() {
        assertTrue(player.removeSongFromQueueList(),"Song is not deleted");
    }

    @And("user clicks on clear list button")
    public void userClicksOnClearListButton() {
        player.clickClearListButton();
    }

    @Then("user verifies clear Queue pop up is opened")
    public void userVerifiesClearQueuePopUpIsOpened() {
        assertTrue(player.clearPopUp(),"Clear pop up is not opened");
    }

    @Then("user verifies all the songs in the queue is removed from clear list pop up")
    public void userVerifiesAllTheSongsInTheQueueIsRemovedFromClearListPopUp() {
        assertTrue(player.allSongRemoved(),"All songs are not removed");
    }
}
