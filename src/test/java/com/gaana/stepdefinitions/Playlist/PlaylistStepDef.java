package com.gaana.stepdefinitions.Playlist;

import com.gaana.automation.util.URLBuilder;
import com.gaana.pageobjects.Playlist.PlaylistPO;
import com.gaana.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;

public class PlaylistStepDef {



    PlaylistPO playlistPO = (PlaylistPO) PageObjectWrapper.getObject(PlaylistPO.class);


    @Given("User login to the application")
    public void loginToGaana() {
        playlistPO.navigateToUrl(URLBuilder.getURL("podcastPage"));
        Assert.assertEquals("nikhil","rahul");

    }


}
