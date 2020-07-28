package com.takeaway.utilities;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class GenaeralUtility {
	
	 /**
     * Generate Report name with Time Stamp
     *
     * @return Report Name
     */
	public static String getReportName() {
		Date timeStamp=new Date();
		String reportName="AutomationReport_"+timeStamp.toString().replace(":", "_").replace(" ", "_") + ".html";
		return reportName;
	}
	
	 /**
     * Generate random name of specified length
     *
     * @param  length Length of Name
     * @return Report Name
     */
	public static String getRandomName(int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}

}
