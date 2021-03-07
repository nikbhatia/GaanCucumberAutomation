package com.gaana.automation.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.gaana.pageobjects.Login.LoginPO;
import com.gaana.test.base.BaseAutomation;


public class GenericClassMethod extends BaseAutomation{
	static GenericMethod generic = new GenericMethod();
	LoginPO loginpage = new LoginPO();

	private static By playAllBtn = By.xpath("(//a[@id='p-list-play_all'])[1]");
	private static By pauseIcon = By.xpath("//a[@title='Pause']");
	private static By startTimer = By.xpath("//div[@class='timer time mq']");
	private static By loginPopUpCrossBtn = By.xpath("//a[@class='popup-close']");
	private static By songQueueList = By.xpath("//ul[@id='player_queue']/li");
	private static By videoAds = By.xpath("//video[@id='vdplayer']");
	private static By crossVideo = By.xpath("//div[@id='videoPopupClosebtn']");
	private static By nextSongButton = By.xpath("//a[@title='Next Song']");
	private static By playerPauseIcon = By.xpath("//*[@id='mp']/div[3]/div/div[3]/div/a[2]//*[@class='pausesvg']");
	//	private static By playerPIcon = By.xpath("//*[@id='mp']/div[3]/div/div[3]/div/a[2]//*[@class='pausesvg']");
	private By loginImage = By.xpath("//a[@class='login-img']");


	public static void clickOnPlayAll() throws InterruptedException {
		Thread.sleep(1500);
		if(generic.isTextVisisble("play all")) {
			try {
				generic.click(playAllBtn);
			} catch (Exception e) {
				if(generic.isTextVisisble("play all")) {
					generic.click(playAllBtn);
				}
			}

		}
	}
	public static void clickOnNextSong() {
		generic.click(nextSongButton);
	}
	public static boolean isPauseBtnDisplay() {
		if(generic.isDisplay(pauseIcon)) {
			if(!(driver.findElements(pauseIcon).size()==0)) {
				return true;
			}
		}
		System.out.println("pause button is not displaying");
		return false;
	}
	public static boolean isPlayerPauseDisplay() {
		generic.WaitFor_visibility(playerPauseIcon);
		if(generic.isDisplay(playerPauseIcon)) {
			if(!(driver.findElements(playerPauseIcon).size()==0)) {
				return true;
			}
		}
		System.out.println("pause button is not displaying");
		return false;
	}
	public static boolean isSongTimerStart() throws InterruptedException {
		int i=10;
		String time ="";
		try {
			time = generic.getText(startTimer);
		} catch (Exception e) {
			if(generic.isDisplay(videoAds)) {
				generic.click(crossVideo);
				time = generic.getText(startTimer);
			}
		}		
		Thread.sleep(2000);
		System.out.println("time:"+time);
		while(time.equals("00:00") && i>0) {
			Thread.sleep(2000);
			i--;
			time = generic.getText(startTimer);
		}
		String afterTime = generic.getText(startTimer);
		System.out.println("afterTime:"+afterTime);
		if(!afterTime.equals("00:00")) {
			return true;
		}
		System.out.println("Timer not started");
		return false;
	}

	public static boolean isSongPlaying() throws InterruptedException {
		if(isPauseBtnDisplay() && isSongTimerStart()) {
			return true;
		}
		return false;
	}
	public static boolean isAkamaiSongPlaying() throws InterruptedException {
		if(isSongPlaying()) {
			return true;
		}else {
			clickOnPause();
			System.out.println("song is not playing directly, clicking play again");
			if(isSongPlaying()) {
				return true;
			}
		}
		return false;
	}

	public static void clickOnLoginPopupClose() throws InterruptedException {
		generic.click(loginPopUpCrossBtn);
		Thread.sleep(1000);
		generic.click(loginPopUpCrossBtn);
	}
	public static boolean isAllSongListedInQueue() {
		if(generic.getElementSize(songQueueList)>0) {
			return true;
		}
		return false;
	}
	public static void clickOnPause() {
		generic.click(pauseIcon);
	}
	public boolean isUserImageDisplay() {
		return generic.isDisplay(loginImage);

	}
}
