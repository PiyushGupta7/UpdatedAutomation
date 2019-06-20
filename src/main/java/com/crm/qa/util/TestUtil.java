package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	
	public void SwitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

}
