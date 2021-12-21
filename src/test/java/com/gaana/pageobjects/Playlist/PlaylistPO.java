package com.gaana.pageobjects.Playlist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;

public class PlaylistPO extends BaseAutomation {

	GenericMethod generic = new GenericMethod();
	public static String playListName, firstTrendingSong = null;

	private By button_xpath = By.xpath("//button[contains(text(),'${heading}')]");
	private By createPlayListPopup = By.xpath("//h2[contains(text(),'Create New Playlist')]");
	private By createPlayListBtnDisabled = By.xpath("//button[contains(text(),'Create Playlist') and @disabled]");
	private By createPlaylistTextbox = By.xpath("//input[contains(@name,'playlistname')]");
	private By createPlaylistModalFormBtn = By
			.xpath("//section[contains(@class,'model _open')]//button[contains(text(),'Create Playlist')]");
	private By createdPlaylist = By.xpath("//div[@class='t_wrap']//a");
	private By createdPlaylistHeading = By.xpath("//section[contains(@class,'info')]//h1");
	//private By createdPlaylistTrackCount = By.xpath("//section[contains(@class,'info')]//span[2]");
	//private By threeDot = By.xpath("//div[contains(@class,'info')]//button[contains(@title,'More Options')]");
	private By createdPlaylistTrackCount = By.xpath("(//section[contains(@class,'info')]//span)[1]");
	private By threeDot = By.xpath("(//div[contains(@class,'info')]//button[contains(@title,'More Options')])[1]");
	private By editPlaylistLink = By.xpath("//span[contains(text(),'Edit Playlist')]");
	private By editPlaylistTextbox = By.xpath("//section[contains(@class,'info')]//input");
	private By saveBtn = By.xpath("//section[contains(@class,'info')]//button[contains(text(),'Save')]");
	private By deletePlaylistLink = By.xpath("//span[contains(text(),'Delete Playlist')]");
	private By deletePlaylistButton = By.xpath("//button[contains(text(),'Delete Playlist')]");
	private By firstTrendingSongHome = By
			.xpath("//a[contains(@title,'Trending Songs')]//ancestor::section//div[contains(@class,'t_wrap')]//a");
	private By addToPlaylistLink = By.xpath("//span[contains(text(),'Add to Playlist')]");
	private By addToExistingPlaylist = By.xpath("//div[contains(@class,'_inner cent-pp addtoPl_pp')]//strong");
	private By firstTrendingSongHeading = By.xpath("//section[contains(@class,'info')]//h1");
	private By addedSongPlaylistPage = By.xpath("//a[contains(@class,'_tra t_over')]//span[contains(@class,'t_over')]");
	private By selectAllButton = By.xpath("//div[contains(@class,'selectAll')]//button//label");
	private By deleteSelectedButtonDisabled = By
			.xpath("//section[contains(@class,'info')]//button[contains(text(),'Delete Selected') and @disabled]");
	private By deleteSelectedButtonEnabled = By
			.xpath("//section[contains(@class,'info')]//button[contains(text(),'Delete Selected') and not(@disabled)]");
	private By listTestPlaylist = By.xpath("//a[contains(@title,'${heading}')]");
	private By seeAllMyPlaylist = By.xpath("//a[contains(@title,'My Playlists')]");

	private By playlistValidateMsg = By.xpath("//span[@class='playlist_name validateTips']");
	private By playlistCreateSuccessMsg = By.xpath("//div[@class='event-notification']/div");
	private By createdFirstPlaylistName = By.xpath("(//div[@class='arwtork_label']/a)[1]");
	public By firstPlaylist = By.xpath("//div[@class='carousel padtp30 mymsc']//div[@class='hover-events-parent']");
	private By emptyPlaylistMsg = By.xpath("//ul[@class='content-container clearfix a-list artworkload']/div");
	private By editPlaylistValidationMsg = By.xpath("//span[@class='playlist_title validateTips']");
	private By playListNameHeader = By.xpath("//div[@class='_t1']/h1");
	public By playlistIcon = By.xpath("//div[@class='card_layout_data']");

	public void clickOnButton(String string) {
		generic.click(parameterizedLocator(button_xpath, string));
	}

	public boolean validatePresenceCreatePlaylistPopup() {
		boolean flag = false;
		wait.hardWait(2);
		flag = isDisplayed(createPlayListPopup) && isDisplayed(createPlayListBtnDisabled);
		return flag;
	}

	public void enterPlaylistName(String name) {
		playListName = name + generic.getTimeStamp();
		generic.EnterText(createPlaylistTextbox, playListName);
	}

	public void clickOnCPBtn() throws InterruptedException {
		try {
			generic.click(createPlaylistModalFormBtn);
		} catch (Exception e) {
			wait.hardWait(2);
			generic.click(createPlaylistModalFormBtn);
		}
	}

	public boolean validatePlaylistCreated() {
		wait.hardWait(2);
		if (getText(createdPlaylist).equalsIgnoreCase(playListName))
			return true;
		return false;
	}

	public void clickOnCreatedPlaylist() throws InterruptedException {
		try {
			generic.click(createdPlaylist);
			Thread.sleep(2000);
		} catch (Exception e) {
			Thread.sleep(1000);
			generic.click(createdPlaylist);
		}
	}

	public boolean validatePlaylistCreatedHeading() {
		if (getText(createdPlaylistHeading).equalsIgnoreCase(playListName + " Songs"))
			return true;
		return false;
	}

	public boolean validatePlaylistCreatedTrackCount(String count) {
		if (getText(createdPlaylistTrackCount).contains(count))
			return true;
		return false;
	}

	public void clickOnThreeDot() {
		wait.hardWait(3);
		wait.waitForVisibilityOfElement(threeDot);
		jsUtil.clickByJS(threeDot);
	}

	public void clickOnEditPlaylist() {
		generic.click(editPlaylistLink);
	}

	public void clearPlaylistTextbox() {
		driver.findElement(editPlaylistTextbox).clear();
	}

	public void enterEditPlaylistName(String name) {
		playListName = name + generic.getTimeStamp();
		generic.EnterText(editPlaylistTextbox, playListName);
	}
	

	public void clickOnSaveButton() {
		wait.hardWait(3);
		jsUtil.clickByJS(saveBtn);
	}

	public void clickOnDeletePlaylist() {
		try {
			generic.click(deletePlaylistLink);
		} catch (Exception e) {
			clickOnThreeDot();
			generic.click(deletePlaylistLink);
		}
	}

	public void clickOnDeletePlaylistButton() {
		generic.click(deletePlaylistButton);
	}

	public void clickFirstTrendingSongHome() {
		generic.click(firstTrendingSongHome);
		firstTrendingSong = getText(firstTrendingSongHeading);
	}

	public void clickOnAddToPlaylist() {
		generic.click(addToPlaylistLink);
	}

	public boolean addSongToExistingPlaylist() {
		if (getText(addToExistingPlaylist).equalsIgnoreCase(playListName)) {
			generic.click(addToExistingPlaylist);
			return true;
		}
		return false;
	}

	public boolean validateTrendingSongAddedToPlaylist() {
		if (firstTrendingSong.contains(getText(addedSongPlaylistPage)))
			return true;
		return false;
	}

	public boolean validatePresenceDeleteSelectedDisabled() {
		boolean flag = false;
		flag = isDisplayed(deleteSelectedButtonDisabled);
		return flag;
	}

	public void clickOnSelectAll() {
		generic.click(selectAllButton);
	}

	public void clickOnDeleteSelected() {
		if (isDisplayed(deleteSelectedButtonEnabled))
			generic.click(deleteSelectedButtonEnabled);
		else
			Assert.fail("Delete Selected button is not enabled/clickable");
	}

	public boolean isPlaylistValidateMsgDisplay() {
		if (generic.isDisplay(playlistValidateMsg)) {
			return true;
		}
		return false;
	}

	public boolean isEmptyPlaylistMsgDisplay() {
		try {
			generic.isDisplay(emptyPlaylistMsg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getCreatePlaylistValidateMsg() {
		return generic.getText(playlistValidateMsg);
	}

	public String getSuccessMsg() {
		return generic.getText(playlistCreateSuccessMsg);
	}

	public String getFirstPlaylistName() {
		return generic.getText(createdFirstPlaylistName);
	}

	public void clickOnfirstPlaylist() throws InterruptedException {
		Thread.sleep(2000);
		generic.click(firstPlaylist);
	}

	public String getValidationMsg() {
		return generic.getText(editPlaylistValidationMsg);
	}

	public String getEditedPlaylistName() {
		return generic.getText(playListNameHeader);
	}

	public String getDatvaluePlaylist() {
		return driver.findElement(createdFirstPlaylistName).getAttribute("data-value");
	}

	public String getEmptyPlaylistMsg() {
		return generic.getText(emptyPlaylistMsg);
	}

	public void playlistCleanUp(String title) {

		generic.click(seeAllMyPlaylist);

		List<WebElement> testPlaylists = driver.findElements(parameterizedLocator(listTestPlaylist, title));
		int playlistCount = testPlaylists.size();

		for (int i = 0; i < playlistCount; i++) {
			testPlaylists = driver.findElements(parameterizedLocator(listTestPlaylist, title));
			generic.click(testPlaylists.get(0));
			clickOnThreeDot();
			clickOnDeletePlaylist();
			clickOnDeletePlaylistButton();
		}
	}
	
	public void retrySongDeletePlaylist() {
		if(!isDisplayed(createdPlaylistHeading)) {
			System.out.println("Song is not deleted from the playlist in first attempt...");
			driver.navigate().refresh();
			clickOnSelectAll();
			clickOnDeleteSelected();
			clickOnSaveButton();
		}
		
	}

}
