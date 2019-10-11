package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A02_CreateAccount;
import com.flowers.utils.TestBase;

public class TC_Module02_CreateAccount extends TestBase {

	A02_CreateAccount CAAction = new A02_CreateAccount();

	@Test(priority = 1)
	public void verifyCreateAccountTestCase() throws Exception {
		CAAction.verifyCreateAccountTestCase();
	}

	@Test(priority = 2)
	public void verifySwitchWindow() throws Exception {
		CAAction.verifySwitchWindow();
	}

	@Test(priority = 3)
	public void verifyCreateAccountTitle() throws Exception {
		CAAction.verifyCreateAccountTitle();
	}

	@Test(priority = 4)
	public void verifyCreateAccountWithBlankFields() throws Exception {
		CAAction.verifyCreateAccountWithBlankFields();
	}

	@Test(priority = 5)
	public void verifyCreateAccountWithInvalidEmail() throws Exception {
		CAAction.verifyCreateAccountWithInvalidEmail();
	}

	@Test(priority = 6, enabled = false)
	public void verifyCreateAccountWithInvalidPassword() throws Exception {
		CAAction.verifyCreateAccountWithInvalidPassword();
	}

	@Test(priority = 7, enabled = false)
	public void verifyCreateAccount() throws Exception {
		CAAction.verifyCreateAccount();
	}
}