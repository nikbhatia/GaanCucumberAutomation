/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaana.automation.util;

import com.gaana.test.base.BaseAutomation;

import java.util.HashMap;
import java.util.Map;

/**
 * This file contaions functions to build urls according to testing environments
 * @author nikhil.bhatia
 */
public class URLBuilder {

    public static Map<String, String> endPoints = new HashMap<String, String>();

    public static void setEndPoint() {
        endPoints.put("podcastPage", "/podcast");
        endPoints.put("myMusicPage","/music");
        endPoints.put("subscriptionPage", "/subscribe/buy-gaana-plus");
        endPoints.put("artistPage", "/artist");
        endPoints.put("albumPage", "/album");
        endPoints.put("Songpage","/song/paani-paani-3");
        endPoints.put("Playlistpage","/playlist/gaana-dj-hindi-top-50-1");
        endPoints.put("Album","/album/baarish-ban-jaana");
        endPoints.put("androidTv","/tv");
        endPoints.put("quickSilverLogin","/cXVpY2tzaWx2ZXI=");
        endPoints.put("particularPodcast","/podcast/all-things-music-with-sarthak-2018");
        endPoints.put("Lyricspage","/lyrics/tere-sang-yaara-1");

        endPoints.put("Playlist","/playlist");

        endPoints.put("FavPodcastPage","/myfavoritepodcasts");

    }



    public static String getEndPoint(String moduleName) {
        setEndPoint();
        return endPoints.get(moduleName);
    }
    /**
     * @author nikhil.bhatia
     * @param moduleName
     * @return Page URL {String} This method will return page URL according to
     * the module name, if environment is test then it will replace the name
     * space according to the Maven value or configuration file
     */
    public static String getURL(String moduleName) {
        String baseURL = YamlReader.getAppConfigValue("URLs.baseURL");
        String environment = System.getProperty("testEnvironment");
        if (environment == null || environment.isEmpty()) {
            environment = ReadWritePropertyFile.getProperty("testEnvironment", BaseAutomation.configFile);
        }
        if (environment.equalsIgnoreCase("test")) {
            String nameSpace = System.getProperty("nameSpace");
            if ((nameSpace == null) || (nameSpace.isEmpty())) {
                nameSpace = ReadWritePropertyFile.getProperty("nameSpace", BaseAutomation.configFile);
            }
            System.out.println(nameSpace);
            baseURL = baseURL.replaceFirst("gaana", nameSpace);
            TestNGLogUtility.info("URL: " + baseURL);
        }
        if(!moduleName.contains("home"))
        	baseURL = baseURL + getEndPoint(moduleName);
        System.out.println(baseURL);
        
        return baseURL;
    }
}
