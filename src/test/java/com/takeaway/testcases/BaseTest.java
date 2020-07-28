package com.takeaway.testcases;

import static com.takeaway.utilities.ReadProperties.getValue;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.takeaway.client.ListClient;
import com.takeaway.constants.PropertyKeys;
import com.takeaway.response.model.CreateListResponse;

import io.restassured.RestAssured;

public class BaseTest {

	protected final Logger logger = LogManager.getLogger(getClass());
	protected ListClient listClient;
	protected CreateListResponse createdList;


    @BeforeSuite
    public void baseBeforeTest() {
    	RestAssured.baseURI = getValue(PropertyKeys.ROOT_URL) + getValue(PropertyKeys.API_VERSION);
    	
    }
    
    @BeforeClass
	 public void beforeListClass() {

	    	listClient = new ListClient();
    }

    @BeforeMethod
    public void logExecution(ITestResult result)
    {
    	logger.info("========= Execution of TestCase: [" + result.getMethod().getDescription() + "] " + "=========");
    }
    
    @AfterMethod
    public void logEndOfExecution(ITestResult result)
    {
    	logger.info("========= Ended Execution of TestCase: [" + result.getMethod().getDescription() + "] " + "=========");
    }
}
