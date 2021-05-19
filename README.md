# Automation-Challenge
ATOS Test Automation Challenge

### The main Frameworks included in the project:
* Selenium Webdriver
* Rest-Assured
* TestNG
* Allure Report
* Extent Reports
* Apachi POI

### Design implementation:
* Page Object Model (POM) design pattern
* Data Driven framework
* Fluent design approach (method chaining)
* Have a supporting Utilities package in *src/main/java* file path, named ***"Utils"*** that includes utility classes and many wrapper methods which services as the core engine for the project 

### How to see the execution and the test report from the GitHub Actions:
* Click on the *"Actions"* tab ![image](https://user-images.githubusercontent.com/46620378/118896490-a4c23500-b908-11eb-956a-b7cbf872274d.png)
* Click on the latest workflow run link ![image](https://user-images.githubusercontent.com/46620378/118896548-c8857b00-b908-11eb-904e-aeb829eb2b55.png)
* Click on "Test on Ubuntu" and open "Run tests - Chrome Headless" to see the execution logs ![image](https://user-images.githubusercontent.com/46620378/118896588-dd620e80-b908-11eb-955e-a55fedb62600.png) ![image](https://user-images.githubusercontent.com/46620378/118896671-0a162600-b909-11eb-8fbe-6249f02fcc9f.png)
* And you can check the execution report by clicking on "ExtentReports HTML Test Report" in the *Artifacts* section (Just download, unzip and open it) ![image](https://user-images.githubusercontent.com/46620378/118896714-23b76d80-b909-11eb-953f-01887908a744.png)

### How to execute the test cases locally:
* Import or clone the maven project on any java IDE (Eclipse or IntelliJ for example)
* A properties file ***"automationChallenge.properties"*** can be found it *src/main/resources* file path including all the configurations needed in the execution (make sure that the "execution.type" property is "Local" if you need to execute locally)
* Can find the test cases in the *src/test/java* folder inside the *phptravels.gui.tests* package
* Can find the test suite xml file in the *src/test/resources* folder inside the *TestSuites* folder
![image](https://user-images.githubusercontent.com/46620378/118897002-c96adc80-b909-11eb-835d-e90dc4f3954c.png)
* To start executing the test classes, you can right click on the *phptravels.xml* folder and then click "Run As" > "TestNG Suite" ![image](https://user-images.githubusercontent.com/46620378/118897487-b4427d80-b90a-11eb-81a3-8394da6dd653.png)
* After executing, you can easily generate the ***Allure Report*** by opening a commandline terminal on the project root path and type `mvn allure:serve` (needs to be able to execute mvn commands); Or you can find the Extent Report ***ExtentReports.html*** in the project root path for the latest execution ![image](https://user-images.githubusercontent.com/46620378/118897604-ece25700-b90a-11eb-8b8f-823efd3869b0.png)

