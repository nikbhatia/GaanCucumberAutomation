package com.gaana.stepdefinitions.Videos;

import cucumber.api.java.en.Then;
import com.gaana.pageobjects.Videos.VideosPO;
import org.testng.Assert;

public class VideoStepDef {

    VideosPO videosPO = new VideosPO();

    @Then("user clicks on video and verify the video title")
    public void user_clicks_on_video_and_verify_the_video_title(){

        videosPO.videoSong_Play();
    }

    @Then("user clicks on gaanavideo tabs")
    public void click_on_video_tabs() {
        videosPO.selectTabs();

    }

    @Then("click on video and verify the time")
    public void click_on_video_and_verify_the_time(){
        videosPO.videoSong_Play();
        videosPO.verifyVideoPlayed();
    }
    @Then("click on video and verify the video time")
    public void click_on_video_and_verify_the_video_time(){
        videosPO.clickOnVideos();
    }

}
