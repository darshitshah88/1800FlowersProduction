package com.flowers.testcases;

import org.testng.annotations.Test;

import com.flowers.action.A01_Home;
import com.flowers.utils.TestBase;

public class TC_Module01_Home extends TestBase {

	A01_Home HAction = new A01_Home();

	@Test(priority = 1)
	public void verifyHomeTestCase() throws Exception {
		HAction.verifyHomeTestCase();
	}

	@Test(priority = 2)
	public void verifyBrowserLaunched() throws Exception {
		HAction.verifyBrowserLaunched();
	}

	@Test(priority = 3)
	public void verifyHomeTitle() throws Exception {
		HAction.verifyHomeTitle();
	}

	@Test(priority = 4)
	public void verifyDisplayLogo() throws Exception {
		HAction.verifyDisplayLogo();
	}

	@Test(priority = 5, enabled = false)
	public void verifyGDPRNotice() throws Exception {
		HAction.verifyGDPRNotice();
	}

	@Test(priority = 6)
	public void verifyMouseHover() throws Exception {
		HAction.verifyMouseHover();
	}
}