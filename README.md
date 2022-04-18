# TestDemo
TestdemoAPIframework

Sample demo Automation developed using BDD and Testng Abstract runner.
Project uses Gradle and Java, Gradle 7.4 version ,Java version 11.

--
**Quick start**

Download the project code.

In IntelliJ IDEA, select File | Open... and point to the ./build.gradle file.

Tests/Feature files are in src/test/resources/feature -- api or ui .
For Api test add feature file to src/test/resources/feature/api - Add you feature file as per module.
Currently for billing app there is demoabcbilling.feature file added.
Under resource folder we are also having  util folder with type of file Json, ini file.
Json file are having json body for request and Ini file have configuration file with api url and path will add env propeties later.

src/test/java has :
com.bh.assign >
Base with UI/AP base classes
Helper like API constant with token /file path.
Model - to generate model of request response pojo classes
Runner -Use runner test to run your test
To Run specific test feature you can add the feature tag in runner class like  tags="@BillingDemo",
Step definition file are name in com.bh.assign.stepdef . For API use API folder and create your step defintion.
API base is having method for get,post,put,delete use theme in step definition also they are having the getting ini file and other some other generic validation function.


**Sample:**
User src/test/java>Runner> RunnerTest.Java - Right click and Run using it or run using testng.xml with right click.
To run using InteliJ - Navigate to Gradle daemon > Select Gradle settings> and Run test using Intellij.Click ok.
Add you json file in json file folder path with in demobilling > file name

To generate pojo class using json file navigate to https://www.jsonschema2pojo.org/
here give json .
1.Past a valid response
2.Give package name and Class name to generate pojo class.
3.Click on zip file to downlaod the file and place it  corresponding model path
Refer screenshot
![image](https://user-images.githubusercontent.com/30175822/163767105-4c4ff740-1be5-41b9-87d7-53146616b6ee.png)


