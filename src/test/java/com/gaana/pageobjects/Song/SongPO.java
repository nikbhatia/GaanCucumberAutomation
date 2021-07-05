package com.gaana.pageobjects.Song;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SongPO extends BaseAutomation {

    GenericMethod generic = new GenericMethod();

    private By firstTrendingSong = By.xpath("(//section[@class='caro caro_sqr mWrap']/div[@class='caro_container']/ul/li)[1]");
    private By Threeeedot = By.xpath("(//button[@id='playBtn1'])[1]/following::button[@title='More Options'][1]");
    private By threeDotIcon = By.xpath("(//div[@class='scrollhost-container'])[3]");
    private By threedotpopupelements = By.xpath("//div[contains(@class,'_txt t_over')]//span");


    public void clicktrendingfirstsong() throws InterruptedException {

        click(firstTrendingSong);
    }

    public void clickthreedot()  {
        wait.waitForVisibilityOfElement(Threeeedot);
        click(Threeeedot);
    }


    public ArrayList<String> getelementsfromthreedotpopup() throws InterruptedException
    {
        wait.hardWait(2);
        generic.isDisplay(threeDotIcon);
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



}
