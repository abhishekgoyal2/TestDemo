TestDemo
TestdemoAPIframework

Sample demo Automation developed using BDD and Testng Abstract runner.
Project uses Gradle and Java, Gradle 7.4 version ,Java version 11.
--
Quick start

1)	Download the project code.
2)	Tests/Feature files are in src/test/resources/feature -- api or ui .
3)	For Api test add feature file to src/test/resources/feature/api - Add you feature file as per module.
4)	Currently for billing app there is demoabcbilling.feature file added.
5)	Under resource folder we are also having  util folder with type of file Json, ini file.
6)	Json file are having json body for request and Ini file have configuration file with api url and path will add env propeties later.

src/test/java :
1)	com.bh.assign >
2)	Base with UI/AP base classes
3)	Helper like API constant with token /file path.
4)	Model - to generate model of request response pojo classes
5)	Runner -Use runner test to run your test
6)	To Run specific test feature you can add the feature tag in runner class like  tags="@BillingDemo",
7)	Step definition file are name in com.bh.assign.stepdef . For API use API folder and create your step defintion.
8)	API base is having method for get,post,put,delete use theme in step definition also they are having the getting ini file and other some other generic validation function.


**Sample:**
1)	User src/test/java>Runner> RunnerTest.Java - Right click and Run using it or run using testng.xml with right click.
2)	To run using InteliJ - Navigate to Gradle daemon > Select Gradle settings> and Run test using Intellij.Click ok.
3)	Add you json file in json file folder path with in demobilling > file name
4)	To generate pojo class using json file navigate to https://www.jsonschema2pojo.org/
here give json .
i)	Past a valid response
ii)	Give package name and Class name to generate pojo class.
iii)	Click on zip file to downlaod the file and place it  corresponding model path
Refer screenshot
![image](https://user-images.githubusercontent.com/30175822/163767105-4c4ff740-1be5-41b9-87d7-53146616b6ee.png)
