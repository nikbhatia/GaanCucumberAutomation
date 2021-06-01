package com.gaana.stepdefinitions.Pagination;

import static org.testng.Assert.assertTrue;

import com.gaana.automation.util.GenericClassMethod;
import com.gaana.pageobjects.Pagination.PaginationPO;
import com.gaana.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class PaginationStepDef {
	
	PaginationPO paginationPO = (PaginationPO) PageObjectWrapper.getObject(PaginationPO.class);
	GenericClassMethod genericClass = new GenericClassMethod();
	
	
	@Then("user verifies pagination of the {string}")
	public void user_verifies_pagination_of_the(String page) throws InterruptedException {
		assertTrue(paginationPO.validatePagination(page), page+" pagination is not working properly.");
	}
	
	@Then("user clicks on {string} link from home page")
	public void user_clicks_on_link_from_home_page(String titleHeading) throws InterruptedException {
		genericClass.clickOnGaanaLogo();
		paginationPO.clickOntitleHeading_SeeAllLink(titleHeading);
	}

}
