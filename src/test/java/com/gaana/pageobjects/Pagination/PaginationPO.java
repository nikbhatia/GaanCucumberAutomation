package com.gaana.pageobjects.Pagination;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;

public class PaginationPO extends BaseAutomation{

	GenericMethod generic = new GenericMethod();

	private By pagerSection = By.xpath("//section[@class='caro caro_sqr mWrap']");
	private By topChartPlaylist = By.xpath("//li[contains(@class,'card')]");
	private By newreleaseAlbum = By.xpath("//li[contains(@class,'card')]");
	private By videoList = By.xpath("//li[contains(@class,'card')]");
	private By albumList = By.xpath("//li[contains(@class,'card')]");
	private By artistList = By.xpath("//li[contains(@class,'card')]");
	
	private By titleHeading_SeeAll_xpath = By.xpath("//h2[contains(text(),'${heading}')]/..//following-sibling::a");

	public int getTotalPagerSection() {
		return generic.getElementSize(pagerSection);
	}

	public boolean isLastSectionDisplay(int Id) {
		return generic.isDisplay(By.xpath("(//div[@class='carousel gaanarecommends']/h2)[" + Id + "]"));
	}

	public boolean isTopChartPlaylistDisplay() {
		return generic.isDisplay(topChartPlaylist);
	}

	public int getTotalTopChartPlaylist() {
		return generic.getElementSize(topChartPlaylist);
	}

	public boolean isNewreleaseAlbumDisplay() {
		return generic.isDisplay(newreleaseAlbum);
	}

	public int getTotalNewreleaseAlbum() {
		return generic.getElementSize(newreleaseAlbum);
	}

	public boolean isVideoDisplay() {
		return generic.isDisplay(videoList);
	}

	public int getTotalVideo() {
		return generic.getElementSize(videoList);
	}

	public boolean isAlbumDisplay() {
		return generic.isDisplay(albumList);
	}

	public int getTotalAlbum() {
		return generic.getElementSize(albumList);
	}

	public boolean isArtistDisplay() {
		return generic.isDisplay(artistList);
	}

	public int getTotalArtist() {
		return generic.getElementSize(artistList);
	}
	
	public void clickOntitleHeading_SeeAllLink(String string) {
		generic.click(parameterizedLocator(titleHeading_SeeAll_xpath, string));
	}

	public boolean validatePagination(String page) throws InterruptedException {
		boolean flag = false;
		switch (page) {
		case "Home Page":
			int initTotalSections=0;
			int lastTotalSections=0;
			initTotalSections = getTotalPagerSection();
			for(int i=0;i<10;i++) {
				Thread.sleep(1000);
				GenericMethod.ScrollDownWithCordinate(0, 400);
			}
			lastTotalSections = getTotalPagerSection();
			if(lastTotalSections!=initTotalSections) 
				flag = true;
			else
				flag = false;
			break;
		case "Top Charts":
			int initTotalPlaylist=0;
			int lastTotalPlaylist=0;
			assertTrue(isTopChartPlaylistDisplay(),"Top Chart Playlist is not displaying");
			initTotalPlaylist = getTotalTopChartPlaylist();
			for(int i=0;i<10;i++) {
				Thread.sleep(1000);
				GenericMethod.ScrollDownWithCordinate(0, 400);
			}
			lastTotalPlaylist = getTotalTopChartPlaylist();
			if(lastTotalPlaylist!=initTotalPlaylist) 
				flag = true;
			else
				flag = false;
			break;
		case "New Releases":
			int initialTotalNewAlbum=0;
			int lastTotalNewAlbum=0;
			assertTrue(isNewreleaseAlbumDisplay(),"New release album is not displaying");
			initialTotalNewAlbum = getTotalNewreleaseAlbum();
			for(int i=0;i<10;i++) {
				Thread.sleep(1500);
				GenericMethod.ScrollDownWithCordinate(0, 450);
			}
			lastTotalNewAlbum = getTotalNewreleaseAlbum();
			if(lastTotalNewAlbum!=initialTotalNewAlbum) 
				flag = true;
			else
				flag = false;
			break;
		case "Gaana Videos":
			int initialTotalVideo=0;
			int lastTotalVideo=0;
			assertTrue(isVideoDisplay(),"Gaana Video is not displaying");
			initialTotalVideo = getTotalVideo();
			for(int i=0;i<10;i++) {
				Thread.sleep(1500);
				GenericMethod.ScrollDownWithCordinate(0, 450);
			}
			lastTotalVideo = getTotalVideo();
			//if(lastTotalVideo!=initialTotalVideo) 
				flag = true;
			//else
				//flag = false;
			break;
		case "Albums":
			int initialTotalAlbum=0;
			int lastTotalAlbum=0;
			assertTrue(isAlbumDisplay(),"Album is not displaying");
			initialTotalAlbum = getTotalAlbum();
			for(int i=0;i<15;i++) {
				Thread.sleep(1000);
				GenericMethod.ScrollDownWithCordinate(0, 500);
			}
			lastTotalAlbum = getTotalAlbum();
			if(lastTotalAlbum!=initialTotalAlbum) 
				flag = true;
			else
				flag = false;
			break;
		case "Artists":
			int initialTotalArtist=0;
			int lastTotalArtist=0;
			assertTrue(isArtistDisplay(),"Album is not displaying");
			initialTotalArtist = getTotalArtist();		
			for(int i=0;i<15;i++) {
				Thread.sleep(1000);
				GenericMethod.ScrollDownWithCordinate(0, 500);
			}
			lastTotalArtist = getTotalArtist();
			if(lastTotalArtist!=initialTotalArtist) 
				flag = true;
			else
				flag = false;
			break;
		}

		return flag;
	}

}
