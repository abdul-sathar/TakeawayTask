# Takeaway Automation Framework
API Test Automation framework is developed to automate tests that cover basic functionality for Lists CRUD operations in Movie Database API.

Framework is designed using following Tech Stack: 
1. ***Java*** as language, 
2. ***Maven*** as build management tool,
3. ***Rest-Assured*** to handle RESTful APIs, 
4. ***TestNG*** as Unit Testing Framework, 
5. ***Extent Reports*** as Reporting tool,
6. ***Log4j2*** as Logging tool.

***Important Note:*** 
- Framework is designed to perform parallel execution using TestNG on Class level.
- Automation Report file get generated with time stamp.
- Framework logs every step.

--------------------------------------------------------------------------------------------
Getting the code:
--------------------------------------------------------------------------------------------
`git clone https://github.com/abdul-sathar/TakeawayTask.git` (Clone the test suite)

--------------------------------------------------------------------------------------------
Configuration:
--------------------------------------------------------------------------------------------
In the file ***`config.properties`*** , below properties can be configured

- root_url = https://api.themoviedb.org/
- api_version = 4
- api_key = provide_api_key
- invalid_access_token = eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
- access_token = please_provide_write_access_token

--------------------------------------------------------------------------------------------
Running the test suite:
--------------------------------------------------------------------------------------------
***Pre-condition:***  make sure you have enter valid write access token in ***`config.properties` ***

1. Clone the repository.

2. Navigate to 'TakeawayTask' folder by  `cd TakeawayTask` 

3. Execute the tests by  `mvn clean test` 


--------------------------------------------------------------------------------------------
Additional Info:
--------------------------------------------------------------------------------------------
* Tests can be found in `/src/test/java/com/takeaway/testcases/` folder
* Utility methods can be found in `/src/test/java/com/takeaway/utilities/` folder
* Rest Assured Utility can be found in `/src/test/java/com/takeaway/utilities/` folder
* Configuration properties can be found in `/src/test/resources/config.properties` file
* Logs can be found in `/log/` folder
* Automation Report can be found in `/TestReports/AutomationReport_with_TimeStamp.html` file

--------------------------------------------------------------------------------------------
### Contact
--------------------------------------------------------------------------------------------
* abdul.sathar2612@gmail.com