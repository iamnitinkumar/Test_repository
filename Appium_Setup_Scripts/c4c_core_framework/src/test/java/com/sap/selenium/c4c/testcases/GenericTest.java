package com.sap.selenium.c4c.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.selenium.c4c.components.AccessHelper;
import com.sap.selenium.c4c.components.PerformanceTest;
import com.sap.selenium.c4c.scripts.Account;

public class GenericTest extends PerformanceTest {

	@Before
	public void setUp() throws Exception {
		AccessHelper.login("English");
	}

	@After
	public void tearDown() throws Exception {
		AccessHelper.logout("English");
	}
	@Test
	public void test() throws Exception {
		
		
		Account account = new Account(driver);
		account.navigate("VISITS", "VISITS");
	}

}
