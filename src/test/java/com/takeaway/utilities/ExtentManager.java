package com.takeaway.utilities;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import static com.takeaway.utilities.GenaeralUtility.getReportName;

public class ExtentManager {
	
	protected static ExtentSparkReporter extentReporter;
    protected static ExtentReports extent;
    
    /**
     * Create the instance of Extent Report
     *
     * @return ExtentReports
     */
    public static ExtentReports createExtentInstance()
    {
    	String reportFileName = getReportName();
    	String directory = System.getProperty("user.dir") + "/TestReports/";
    	new File(directory).mkdirs();
    	String filePath = directory + reportFileName;
    	extentReporter = new ExtentSparkReporter(filePath);
    	extentReporter.loadXMLConfig("src/test/resources/html-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(extentReporter);
        extent.setSystemInfo("Company", "takeaway.com");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester ", System.getProperty("user.name"));
        return extent;
    }

}
