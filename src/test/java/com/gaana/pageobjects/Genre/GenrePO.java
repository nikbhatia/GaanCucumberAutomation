package com.gaana.pageobjects.Genre;

import org.openqa.selenium.By;

import com.gaana.automation.util.GenericMethod;
import com.gaana.test.base.BaseAutomation;

public class GenrePO extends BaseAutomation {

	private By alphabetGenre = By.xpath("//div[contains(@class,'alph_short')]//a[text()='${heading}']");
	private By firstGenreBelowCharacter = By.xpath("//div[contains(@alt,'${heading}')]//following-sibling::div//a");
	private By genreHeadingH1 = By.xpath("//h1");
	private By genreHeadingH2 = By.xpath("//h2");
	private By firstGenreBelowHeading = By
			.xpath("//h2[text()='${heading}']//..//following-sibling::div[@class='lry_ul']//a");
	private By viewAllHeading = By.xpath("//h2[text()='${heading}']//following-sibling::a");
	private By firstItemGenreViewAll = By.xpath("//div[@class='lry_ul']//a");

	GenericMethod generic = new GenericMethod();
	static String genreName;

	public void clickOnGenreAlphabet(String alpha) {
		wait.hardWait(2);
		generic.click(parameterizedLocator(alphabetGenre, alpha));
	}

	public void clickOnFirstGenreUnderAlphabet(String alpha) {
		wait.hardWait(2);
		genreName = getText(parameterizedLocator(firstGenreBelowCharacter, alpha));
		System.out.println("Genre name is " + genreName);
		generic.click(parameterizedLocator(firstGenreBelowCharacter, alpha));

	}

	public boolean validateGenrePageHeading() {
		wait.hardWait(2);
		if (getText(genreHeadingH1).contains(genreName))
			return true;
		return false;
	}

	public boolean validateHeadings2GenrePage(String options) {
		wait.hardWait(2);
		return generic.validateListOfValues(options, genreHeadingH2);
	}

	public void clickOnFirstGenreUnderHeading(String heading2) {
		wait.hardWait(2);
		genreName = getText(parameterizedLocator(firstGenreBelowHeading, heading2));
		System.out.println("Genre name is " + genreName);
		generic.click(parameterizedLocator(firstGenreBelowHeading, heading2));
	}

	public void navigateBack() {
		wait.hardWait(2);
		driver.navigate().back();
		
	}

	public void clickOnViewAll(String heading) {
		generic.click(parameterizedLocator(viewAllHeading, heading));
	}

	public boolean validatePageHeadingURL(String heading) {
		wait.hardWait(2);
		String currentURL = driver.getCurrentUrl().trim();
		if (currentURL.contains(heading.toLowerCase()))
			return true;
		return false;
	}
	
	public void clickOnFirstGenreViewAllHeading() {
		wait.hardWait(2);
		genreName = getText(firstItemGenreViewAll);
		System.out.println("Genre name is " + genreName);
		generic.click(firstItemGenreViewAll);
	}

}
