package Test.Person;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;

public class SalesOrderGenrations extends BaseClass  {
	String substring;
	@Test(description = "Verify Book unit button able to click after entering all the mandatory details.")
	public void T001() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		String searchButton1 = adminLead.asserationForSerach();
		Assert.assertEquals(searchButton1, "Search...");
		substring = adminLead.searchLeadAndUpdateIt(lead);
		System.out.println(substring + "{{{{{{{");
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(3) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		String codeNone = leads.mobileNumberCode();
		Assert.assertEquals(codeNone, "--None--");
		leads.withoutSangType("Mobile Country Code, --None--", "United Arab Emirates(+971)");
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		String imagePresent = logoutUserFromSandBox.logoValidation();
		Assert.assertEquals(imagePresent, "User");
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(ExcleReader.excleReader("Login", 2, 1), ExcleReader.excleReader("Login", 3, 1));
		String searchButton2 = adminLead.asserationForSerach();
		Assert.assertEquals(searchButton1, "Search...");
		adminLead.serchAndUpdateItData(lead);
		leads.leadStatusUpdate();
		String valueBeforSelectionLeadStatus = leads.inprocessLeadUpdate();
		Assert.assertEquals(valueBeforSelectionLeadStatus, "In Progress Lead");
		leads.qulifiedLeadUpdate2();
		String status = leads.leadStatusCheckItsConverted();
		Assert.assertEquals(status, "Converted Lead");
		adminLead.globalSearchLeadName(substring);
		System.out.println(substring + "{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
		leads.clickOnTheAccountLinkAfterGobalSearch();
		unitSel.accountClcikInOpp();
		String gender = unitSel.genderSelection();
		Assert.assertEquals(gender, "--None--");
		leads.withoutSangType("Gender, --None--", "Male");
		unitSel.addDetailsInAccounts("01/05/1789", "Date of Birth", "PersonBirthdate");
		leads.corrporateWelthName("Marital Status, --None--", "Single", "Marital Status");
		leads.corrporateWelthName("Residential Address same as Permanent?, --None--", "Yes",
				"Residential Address same as Permanent?");
		unitSel.addDetailsInAccounts("N/A", "Passport Type", "PassportType__pc");
		unitSel.addDetailsInAccounts("N/A", "Place of Issue", "PlaceofIssue__pc");
		unitSel.addDetailsInAccounts("01/05/1989", "Passport Issue Date", "PassportIssueDate__pc");
		unitSel.addDetailsInAccounts("01/05/1990", "Passport Expiry Date", "PassportExpiryDate__pc");
		unitSel.addDetailsInAccounts("N/A", "Passport Number", "PassportNumber__pc");
		leads.corrporateWelthName("Employment Status, --None--", "Unemployed", "Employment Status");
		unitSel.addressUpdate("N/A");
		unitSel.textAreaAddressInput("N/A");
		unitSel.setValuesInInputAddress("N/A", "postalCode");
		unitSel.setValuesInInputAddress("N/A", "city");
		String relationshipText = unitSel.saveInfo();
		Assert.assertEquals(relationshipText, "Relationships");
		unitSel.relationship();
		unitSel.uploadDocuments("National ID Back Copy", "3");
		unitSel.uploadDocuments("National ID Front Copy", "4");
		unitSel.uploadDocuments("Passport Copy", "6");
		unitSel.uploadDocuments("Signed KYC Form", "7");
		adminLead.globalSearchLeadName(substring);
		unitSel.detailsInOpporties();
		Assert.assertEquals(unitSel.salesTypesText(), true);
		unitSel.dropdownFromDetailsHandle("Sale Type, --None--", "Land");
		unitSel.dropdownFromDetailsHandle("Deal Type, --None--", "Bulk");
		unitSel.dropdownFromDetailsHandle("Booking Type, --None--", "Online");
		unitSel.dropdownFromDetailsHandle("Agent Type, --None--", "Direct");
		unitSel.dropdownFromDetailsHandle("Delivery Method, --None--", "Email");
		unitSel.saveButton();
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		boolean exlmetoryMark = leads.unitSearch();
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify if \"payment and offer selection\" is visible after user click on book Unit(s).",dependsOnMethods="T001")
	public void T002() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.payMeantAndOffers();
		logoutUserFromSandBox.logoutUser();
		
	}
	@Test(description = "Verify if new field\"Mortgage bank\" appears after selecting Yes in mortgage applicable fields.",dependsOnMethods="T001")
	public void T004() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.mortageDisplayed();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description = "Verify if \"Customer contact details are verfied\" checkbox and \"Win Reason\" dropdown is mandatory for Booking unit.",dependsOnMethods="T001")
	public void T005() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.winReason();
		logoutUserFromSandBox.logoutUser();
	}
	
	@Test(description="Verify user able to book unit after the all meditory feild are updated",dependsOnMethods="T001")
	public void T003() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify if Sales Order is created when user completes the Unit Booking process.",dependsOnMethods="T001")
	public void T006() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.dropDownSelectionUnit();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user click on the 'Proceed' button without select offer then error is displayed",dependsOnMethods="T001")
	public void T007() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.errorWithoutOffer(), true);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only  'Win Reason' without 'Customer Contact Details are Verified' then book unit button is not enable",dependsOnMethods="T001")
	public void T008() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.checkBoxNotSelections(), false);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only 'Customer Contact Details are Verified' without  'Win Reason'  then book unit button is not enable",dependsOnMethods="T001")
	public void T009() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.withoutWinReson(), false);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only 'Customer Contact Details are Verified' without  'Win Reason'  then book unit button is not enable",dependsOnMethods="T001")
	public void T0010() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.enableBookUnitWithoutMortage(), true);
		logoutUserFromSandBox.logoutUser();
	}
}
