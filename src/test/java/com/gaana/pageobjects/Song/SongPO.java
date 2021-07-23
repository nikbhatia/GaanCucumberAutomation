package com.gaana.pageobjects.Song;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;
import com.gargoylesoftware.css.parser.selector.ElementSelector;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SongPO extends BaseAutomation {

    GenericMethod generic = new GenericMethod();

    private By firstTrendingSong = By.xpath("(//section[@class='caro caro_sqr mWrap']/div[@class='caro_container']/ul/li)[1]");
    private By threedotpopupelements = By.xpath("//div[contains(@class,'_txt t_over')]//span");
    private By threeDotcss = By.cssSelector("div._c>.icon.menu_ic>svg.threedot_svg");
    private By threedotpopcss = By.cssSelector("div._inner.bottom-pp.three_pp");
    private By favIcon=By.cssSelector("div._c>button.icon.sm-hide>svg");
    private By markedFavSong=By.xpath("//h2[contains(text(),'${string}')]//ancestor::div[@class='head']//following-sibling::div//img");
    private By songTitle= By.cssSelector("#detail_info>.info>._a>h1");
    private By firstArtistLinkInArtistPage= By.cssSelector(".ls_wrap>li:nth-of-type(1)");
    private By artistName=By.cssSelector("#detail_info>.info>._a>h1");
    public String songMarkedAsFav="";



    public void clickTrendingFirstSong() throws InterruptedException
    {
        wait.waitForVisibilityOfElement(firstTrendingSong);
        click(firstTrendingSong);
    }

    /*
    Below method marks a song as favourite, if the song is already marked as favourite
    then it un favourite's the song then marks the song as favourite.
     */
    public void clickFavouriteIconForSong()
    {
        wait.hardWait(2);
        wait.waitForVisibilityOfElement(favIcon);
        String favClass=driver.findElement(favIcon).getAttribute("class").trim();
        System.out.println("Fav icon is b4 clicked  "+favClass);
        if(favClass.contains("fav checked"))
        {
            click(favIcon);
            wait.hardWait(2);
            System.out.println("Fav icon is after clicked  "+driver.findElement(favIcon).getAttribute("class").trim());

        }
        click(favIcon);
        wait.hardWait(2);
        songMarkedAsFav=generic.getText(songTitle).trim();
    }




    public boolean checkSongInsideFavouriteSection(String string) throws InterruptedException {
        boolean song=false;
        System.out.println("string  "+string);
        By element=parameterizedLocator(markedFavSong,string);
        scrooling(element);
        List <WebElement> ll= driver.findElements(element);
        System.out.println("size of the " +string+ "  song list: " + ll.size());
        wait.hardWait(2);

              /*  for(int i=0;i<ll.size();i++)
               {
                   if(songMarkedAsFav.contains(ll.get(i).getAttribute("title").trim()))
                   {
                       song=true;
                       break;
                   }
               }
                 if(songMarkedAsFav.contains(ll.get(0).getAttribute("title").trim()))
                {
                    song=true;
                }*/

        switch(string) {
            case "Favourite Albums":
            case "Favourite Songs":
            case "Favourite Artists":
                if(songMarkedAsFav.contains(ll.get(0).getAttribute("title").trim()))
                {
                    song=true;
                }
                break;
            case "Favourite Playlists":
                for(int i=0;i<ll.size();i++)
                {
                    if(songMarkedAsFav.contains(ll.get(i).getAttribute("title").trim()))
                    {
                        System.out.println("songMarkedAsFav: "+ songMarkedAsFav+"  Inside my music fav section  "+ll.get(i).getAttribute("title").trim());
                        song=true;
                        break;
                    }
                }

        }

        return song;

    }


    public ArrayList<String> getElementsFromThreeDotPopup() throws InterruptedException
    {
        wait.hardWait(2);
        generic.isDisplay(threedotpopcss);
        ArrayList<String> arr= new ArrayList<String>();
        List<WebElement> ls= driver.findElements(threedotpopupelements);

        for(int i=0;i<ls.size();i=i+1)
        {
            String s=ls.get(i).getText();
            System.out.println(s.trim());
            arr.add(s);
        }
        System.out.println(arr.size());

        return arr;
    }


    public String[] stringToArray(String str)

    {
        String[] elementsList = str.split(",");
        return elementsList;
    }


    public boolean validateThreeDotLOV(String options)
    {
        wait.hardWait(2);
        return generic.validateListOfValues(options, threedotpopupelements);
    }

    /*
    Below method clicks the first Artist in the Artist page.
    */
    public void clickFirstArtistLink()
    {
        wait.waitForVisibilityOfElement(firstArtistLinkInArtistPage);
        click(firstArtistLinkInArtistPage);

    }

    public void scrooling(By ele) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("inside b4  try block");
                //   driver.findElement(By.xpath("//a[contains(@title,'Evergreen Romance')]"));
                driver.findElement(ele);
                System.out.println("inside try block");
                break;
            } catch (ElementNotVisibleException e) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400)");
                System.out.println("inside ElementNotVisibleException block");
                Thread.sleep(3000);
            } catch (NoSuchElementException e) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400)");
                System.out.println("inside NoSuchElementException block");
                Thread.sleep(3000);
            }

        }


    }
}
