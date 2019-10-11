package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A03_SignIn;
import com.flowers.utils.TestBase;

public class TC_Module03_SignIn extends TestBase {

	A03_SignIn SIAction = new A03_SignIn();

	@Test(priority = 1)
	public void verifySignInTestCase() throws Exception {
		SIAction.verifySignInTestCase();
	}

	@Test(priority = 2)
	public void verifySwitchWindow() throws Exception {
		SIAction.verifySwitchWindow();
	}

	@Test(priority = 3)
	public void verifySignInTitle() throws Exception {
		SIAction.verifySignInTitle();
	}

	@Test(priority = 4)
	public void verifySignInWithBlankDataFields() throws Exception {
		SIAction.verifySignInWithBlankDataFields();
	}

	@Test(priority = 5)
	public void verifySignInWithBlankEmail() throws Exception {
		SIAction.verifySignInWithBlankEmail();
	}

	@Test(priority = 6)
	public void verifySignInWithBlankPassword() throws Exception {
		SIAction.verifySignInWithBlankPassword();
	}

	@Test(priority = 7)
	public void verifySignInWithInvalidData() throws Exception {
		SIAction.verifySignInWithInvalidData();
	}

	@Test(priority = 8)
	public void verifySignInWithInvalidEmail() throws Exception {
		SIAction.verifySignInWithInvalidEmail();
	}

	@Test(priority = 9)
	public void verifySignInWithInvalidPassword() throws Exception {
		SIAction.verifySignInWithInvalidPassword();
	}

	@Test(priority = 10)
	public void verifySignInWithValidData() throws Exception {
		SIAction.verifySignInWithValidData();
	}
}