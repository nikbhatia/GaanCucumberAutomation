package com.gaana.stepdefinitions.Genre;

import static org.testng.Assert.assertTrue;

import com.gaana.pageobjects.Genre.GenrePO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class GenreStepDef {

	GenrePO genrePO = (GenrePO) PageObjectWrapper.getObject(GenrePO.class);

	@Then("user clicks on character {string} on the genre page")
	public void user_clicks_on_character_on_the_genre_page(String string) {
		genrePO.clickOnGenreAlphabet(string);
	}

	@Then("user clicks on the first genre under character {string}")
	public void user_clicks_on_the_first_genre_under_character(String string) {
		genrePO.clickOnFirstGenreUnderAlphabet(string);
	}

	@Then("user verifies that the first genre page opens successfully")
	public void user_verifies_that_the_first_genre_page_opens_successfully() {
		assertTrue(genrePO.validateGenrePageHeading(),
				"Genre page for the first genre under the given alphabet didn't opened properly");
	}

	@Then("user verifies that the {string} are displayed on the genre page")
	public void user_verifies_that_the_are_displayed_on_the_genre_page(String string) {
		assertTrue(genrePO.validateHeadings2GenrePage(string), "Genre page doesn't have " + string + " sections");
	}

	@Then("user clicks on first {string} and verifies the song page is opening successfully")
	public void user_clicks_on_first_and_verifies_the_song_page_is_opening_successfully(String string) {
		genrePO.clickOnFirstGenreUnderHeading(string);
		assertTrue(genrePO.validateGenrePageHeading(), "Genre page for the first genre song didn't opened properly");
		genrePO.navigateBack();
	}

	@Then("user clicks on {string} link for the {string}")
	public void user_clicks_on_link_for_the(String string, String string2) {
		genrePO.clickOnViewAll(string2);
		assertTrue(genrePO.validatePageHeadingURL(string2),
				"Genre page of View All didn't opened properly for " + string2);
	}

	@Then("user clicks on first item on the genre list details page and verifies the page is opening successfully")
	public void user_clicks_on_first_item_on_the_genre_list_details_page_and_verifies_the_page_is_opening_successfully() {
		genrePO.clickOnFirstGenreViewAllHeading();
		assertTrue(genrePO.validateGenrePageHeading(), "Genre page for the first genre item under View All didn't opened properly");
		genrePO.navigateBack();
		genrePO.navigateBack();
	}

	@Then("user clicks on first {string} and verifies the album page is opening successfully")
	public void user_clicks_on_first_and_verifies_the_album_page_is_opening_successfully(String string) {
		genrePO.clickOnFirstGenreUnderHeading(string);
		assertTrue(genrePO.validateGenrePageHeading(), "Genre page for the first genre Album didn't opened properly");
		genrePO.navigateBack();
	}

	@Then("user clicks on first {string} and verifies the artist page is opening successfully")
	public void user_clicks_on_first_and_verifies_the_artist_page_is_opening_successfully(String string) {
		genrePO.clickOnFirstGenreUnderHeading(string);
		assertTrue(genrePO.validateGenrePageHeading(), "Genre page for the first genre Artist didn't opened properly");
		genrePO.navigateBack();
	}

}
