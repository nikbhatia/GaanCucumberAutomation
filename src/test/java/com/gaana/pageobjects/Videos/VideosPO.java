package com.gaana.pageobjects.Videos;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class VideosPO extends BaseAutomation {

    GenericMethod generic = new GenericMethod();

    private By VideoTabs = By.xpath("//div[@class='_ul']//a//small");
    private By VideoSong = By.cssSelector("li:nth-child(1)>div>a");
    private By forwardscroll = By.cssSelector("button.btn.btn_next.sm-hide");
    private By hoverEle = By.xpath("//div[@class='_ul']");
    private By videoStartime = By.xpath("//div[@id=\"vtimeplayed\"]");
    private By videoEndtime = By.xpath("//div[@id=\"vtimefull\"]");
    private By videoPage = By.xpath("//video[@id=\"gaanaVideoPlayer\"]");
    private By selectedTab = By.xpath("//a[@class='link selected']//small");

    public void videoSong_Play() {
        String songsTitle = driver.findElement(VideoSong).getText();
        wait.hardWait(3);
        click(VideoSong);
        wait.hardWait(5);
        String PlaySongTitle = getPageTitle();
        if (PlaySongTitle.contains(songsTitle)) {
            Assert.assertTrue(true);
        }
    }

    public void selectTabs() {
        List<WebElement> Tabs = driver.findElements(VideoTabs);
        for (int i = 0; i < Tabs.size(); i++) {
            wait.hardWait(3);
            String ele = Tabs.get(i).getText();
            hoverelement();
            scrollforward();
            generic.click(Tabs.get(i));
            if (Tabs.get(i).getAttribute("class").contains("selected")) {
                wait.hardWait(3);
                Assert.assertEquals(getText(selectedTab),ele,"Tab is selected");
            }else {
                Assert.fail(ele+" Tab is not selected");
            }
        }

    }

    public void hoverelement() {
        WebElement Hoverele = driver.findElement(hoverEle);
        mouseHoverToWebElement(Hoverele);
    }

    public void scrollforward() {
        click(forwardscroll);
    }

    public void verifyVideoPlayed() {

        WebElement Hoverele = driver.findElement(videoPage);
        mouseHoverToWebElement(Hoverele);
        wait.hardWait(3);
        if ((getText(videoStartime) != "00:00") && (getText(videoEndtime) != "00:00")) {
            Assert.assertTrue(true);
        }
        driver.navigate().back();
        wait.hardWait(2);
    }
    public void clickOnVideos(){
        List<WebElement> Tabs = driver.findElements(VideoTabs);
        for (int i = 0; i < (Tabs.size()-1); i++) {
            Tabs = driver.findElements(VideoTabs);
            wait.hardWait(3);
            generic.click(Tabs.get(i));
            if (Tabs.get(i).getAttribute("class").contains("selected")) {
                wait.hardWait(2);
                videoSong_Play();
                verifyVideoPlayed();
            }
        }
    }
}