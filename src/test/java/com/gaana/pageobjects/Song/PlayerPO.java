package com.gaana.pageobjects.Song;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;
import java.util.regex.Pattern;


public class PlayerPO extends BaseAutomation {

    GenericMethod generic = new GenericMethod();

    private By button_play = By.id("playBtn1");
    private By player = By.id("bottomplayer");
    private By nextSongIcon = By.xpath("//button[@title='Next Song']");
    private By nextSongInPlayer=By.cssSelector("._c.sm-hide>strong");
    private By playerToQueueIcon=By.cssSelector("#bottomplayer>._rt>._d");
    private By button_queueSave=By.cssSelector(".btn.btn1");
    private By secondSongInQueue=By.cssSelector(".innerscroll>ul>li:nth-of-type(2)>a");
    private By allSongListing=By.cssSelector(".innerscroll>ul>li");
    private By secondSongDeleteLink=By.cssSelector(".innerscroll>ul>li:nth-of-type(2)>._b");
    private By button_clearList=By.cssSelector(".btn.btn2");
    private By clearPopup=By.cssSelector("._inner.cent-pp.clearQ_pp");
    private By clearQueueCheckBox=By.cssSelector("._inner.cent-pp.clearQ_pp>label");
    private By link_ClearTheQueueInPopUp=By.cssSelector("._inner.cent-pp.clearQ_pp>.btn_grp>.trans_btn");


    public void clickPlayButton() {
        click(button_play);
    }
    public void clickClearListButton(){ click(button_clearList);}

    public boolean allSongRemoved()
    {
        boolean flag=false;
        click(clearQueueCheckBox);
        wait.hardWait(3);
        click(link_ClearTheQueueInPopUp);
        int songInQueueCountAfterDeletingFromPopUp=driver.findElements(allSongListing).size();
        System.out.println("songInQueueCountAfterDeletingFromPopUp  :"+songInQueueCountAfterDeletingFromPopUp);
        return (1==songInQueueCountAfterDeletingFromPopUp);
    }

    public boolean clearPopUp(){

        boolean flag=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        flag = wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(clearPopup).isDisplayed();
            }
        });
        return flag;

    }

    public boolean bottomPlayer() {
        boolean flag = false;
        return flag = isDisplayed(player);
    }

    public boolean nextSongEnabled(){
        boolean flag=false;
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        flag = wait1.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(nextSongIcon).getAttribute("class").equalsIgnoreCase("next sm-hide ");
            }
        });
        return flag;
    }

    public boolean playButtonVerify(){
       return driver.findElement(button_play).getText().equalsIgnoreCase("Pause");
    }

    public boolean nextSongInQueueMatcher()
    {
        boolean flag=false;
        String nextSongName=driver.findElement(nextSongInPlayer).getText().trim();
        String[] song=nextSongName.split(Pattern.quote("|"));
        System.out.println("next Song Name : "+song[0]);
        driver.findElement(playerToQueueIcon).click();
        wait.waitForVisibilityOfElement(button_queueSave);

        String secondSongQueue=driver.findElement(secondSongInQueue).getAttribute("title");
        System.out.println("second Song in Queue List "+secondSongQueue);
        return flag=song[0].trim().contains(secondSongQueue.trim());

    }

    public boolean removeSongFromQueueList(){
        boolean flag=false;
        int songInQueueCount=driver.findElements(allSongListing).size()-1;
        generic.actionClick(secondSongDeleteLink);
        int songInQueueCountAfterDelete=driver.findElements(allSongListing).size();
        System.out.println("songInQueueCount :"+songInQueueCount +"  and " +"songInQueueCountAfterDelete :"+ songInQueueCountAfterDelete);
        return (songInQueueCount==songInQueueCountAfterDelete);

    }
}
