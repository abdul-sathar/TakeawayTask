package com.takeaway.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "updateList")
    public static Object[][] validData() 
    {
        return new Object[][] { 
        	{"new description", "new Name"}    	
        };
    }

}
