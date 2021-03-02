package com.gaana.pageobjects.Playlist;

import com.gaana.automation.util.TestNGLogUtility;
import com.gaana.test.base.BaseAutomation;

public class PlaylistPO extends BaseAutomation {


    public void navigateToUrl(String url){
        System.out.println("env url is "+url);
        goToPageURL(url);
        wait.waitForPageToLoadCompletely();
        TestNGLogUtility.info(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
}
