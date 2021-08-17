package com.gaana.pageobjects.Song;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SongPO extends BaseAutomation {

    GenericMethod generic = new GenericMethod();
    GenericClassMethod genericClass = new GenericClassMethod();

    private By firstTrendingSong = By.xpath("(//section[@class='caro caro_sqr mWrap']/div[@class='caro_container']/ul/li)[1]");
    private By threedotpopupelements = By.xpath("//div[contains(@class,'_txt t_over')]//span");
    private By threeDotcss = By.cssSelector("div._c>.icon.menu_ic>svg.threedot_svg");
    private By threedotpopcss = By.cssSelector("div._inner.bottom-pp.three_pp");
    private By favIcon=By.cssSelector("div._c>button.icon.sm-hide>svg");
    private By markedFavSong=By.xpath("//h2[contains(text(),'${string}')]//ancestor::div[@class='head']//following-sibling::div//img");
    private By songTitle= By.cssSelector("#detail_info>.info>._a>h1");
    private By firstArtistLinkInArtistPage= By.cssSelector(".ls_wrap>li:nth-of-type(1)");
    private By artistName=By.cssSelector("#detail_info>.info>._a>h1");
    private By link_language=By.cssSelector(".rt.sm-hide>.lg.mr>svg");
    private By languageOptions=By.cssSelector("._inner.lang_pp>.acc_body>.scrollhost-container>#scrollpad>._box>.list>label");
    private By button_langUpdate=By.cssSelector(".bottom>button[class^='solid_btn']");
    private By link_settings=By.xpath("//span[contains(text(),'Settings')]");
    private By dd_profile =By.cssSelector(".rt.sm-hide>.lgdrop_pp");
    private By link_displayLang=By.cssSelector("#setting_tab_menu>li:nth-of-type(2)");
    private By settingsLanguage=By.cssSelector(".col>label");

    List<String> langName=new ArrayList<>();
    List<WebElement> selectedLang=new ArrayList<>();
    List<WebElement> nonSelectedLang=new ArrayList<>();
    List<WebElement> ll;
    public String songMarkedAsFav="";
    String selectedLanguage="";

    public boolean langSelectedInDisplayLangTab() throws InterruptedException {
        scrooling(settingsLanguage);
        wait.hardWait(3);
        List <WebElement> displayTabLang=driver.findElements(settingsLanguage);
        List<WebElement> displaySelectedLang=new ArrayList<>();
        for(int i=0;i<displayTabLang.size();i++)
        {

            if(displayTabLang.get(i).getAttribute("class").contains("selected"))
            {
                displaySelectedLang.add(displayTabLang.get(i));
            }

        }

        String tabLanguageSelectedShown=displaySelectedLang.get(0).getText().trim().toUpperCase();
        selectedLanguage = selectedLanguage.replaceAll("[^a-zA-Z]", "");
        System.out.println("tabLanguageSelectedShown inside langSelectedInDisplayLangTab method  :"+tabLanguageSelectedShown+": selectedLanguage :"+selectedLanguage);
        if(selectedLanguage.equals(tabLanguageSelectedShown))
        {
            return true;
        }

        return false;

    }

    public void displayLanTab()
    {
        wait.waitForVisibilityOfElement(dd_profile);
        click(link_settings);
        click(link_displayLang);

    }


    public boolean checkUpdateButton()
    {
        boolean langFlag=false;
        ll=driver.findElements(languageOptions);

        for(int i=0;i<ll.size();i++) {

            if(ll.get(i).getAttribute("class").contains("selected"))
            {
                selectedLang.add(ll.get(i));
            }
            else
            {
                nonSelectedLang.add(ll.get(i));
            }
        }

        wait.hardWait(2);

        for(int i=0;i<selectedLang.size();i++)
        {
            selectedLang.get(i).click();
            wait.hardWait(2);
        }

        for(int i=0;i<ll.size();i++) {
            langName.add(ll.get(i).getText());
        }

        String ss=driver.findElement(button_langUpdate).getAttribute("class");
        if(ss.contains("disabled_btn")) {
            langFlag = true;
        }

        return langFlag;


    }

    public boolean checkSelectedLanguage()
    {
        boolean flag=false;
        wait.hardWait(2);
        nonSelectedLang.get(0).click();
        String langSelected= nonSelectedLang.get(0).getText();
        System.out.println("langSelected inside checkSelectedLanguage:  "+langSelected);
        click(button_langUpdate);
        wait.hardWait(2);
        clickOnLanguage();

        ll.clear();
        selectedLang.clear();
        ll=driver.findElements(languageOptions);
        for(int i=0;i<ll.size();i++) {

            if(ll.get(i).getAttribute("class").contains("selected"))
            {
                selectedLang.add(ll.get(i));

            }

        }

        selectedLanguage=selectedLang.get(0).getText();
        System.out.println("selectedLanguage  :"+selectedLanguage);

        if(selectedLanguage.equals(langSelected))
        {
            flag=true;
        }

        return flag;
    }




    /*
       Below method clicks on language link in the home page
    */
    public void clickOnLanguage()
    {
        wait.hardWait(2);
        wait.waitForVisibilityOfElement(link_language);
        click(link_language);
    }

    /*
    Below method clicks on first trending song in the home page
    */
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
            wait.hardWait(3);
            System.out.println("Fav icon is after clicked  "+driver.findElement(favIcon).getAttribute("class").trim());

        }
        click(favIcon);
        wait.hardWait(2);
        songMarkedAsFav=generic.getText(songTitle).trim();
        System.out.println("songMarkedAsFav:"+songMarkedAsFav);
    }




    public boolean checkSongInsideFavouriteSection(String string) throws InterruptedException {
        boolean song=false;
        System.out.println("string  "+string);
        By element=parameterizedLocator(markedFavSong,string);
        scrooling(element);
        List <WebElement> ll= driver.findElements(element);
        System.out.println("size of the " +string+ "  song list: " + ll.size());
        wait.hardWait(2);
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
                    System.out.println((ll.get(i).getAttribute("title").trim()));
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


    public boolean validateLanguage(String options) {
        wait.hardWait(2);
        return generic.validateListOfValues(options, languageOptions);
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
