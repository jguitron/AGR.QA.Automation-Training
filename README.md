![img.png](img.png)
### Introduction
Project name:           "AGR.QA.Automation".
Programming Language:   "Java",             Version - 1.8;
Build tool:             "Maven",            Version - 4.0;
Web App Testing:        "Selenium",         Version - 4.1.2;
WebDriver:              "WebDriverManager", Version - 5.1.0;
BDD implemented:        "Cucumber",         Version - 7.2.3;
Testing tool:           "JUnit",            Version - 4.13.2;

### Getting Started
This Selenium Automation Framework is capable to Automate, Execute and Generate Reports on local as well as on Server.
General idea of current framework using Cucumber BDD (Behavior Driven Development) to make steps clear, easy to read and understand for non-technical
people including Management team. We can add DB and API test cases accordingly within other packages.
Page Object Model is implemented as well within the framework to achieve easy access and maintenance of previously located WebElements.
There are examples of Commands given below how to trigger the Runner class locally or on server.

### Build and Test
Cucumber-Selenium-Maven-JUnit-4 framework is used for as BDD testing automation.

### Test Execution
To run locally and generate Cucumber-HTML reports: use this maven goal *mvn verify* command in terminal. HTML reports will be generated under:
Target/cucumber-html-reports/**.html

Additional running commands/options in terminal:
```
 mvn verify          --> initialization of test execution with Maven lifecycle! 
 mvn clean           --> command to clean Target folder 
 mvn clean verify    --> command to clean Target folder and Build. To get Updated Reports use this command!
```

### Running on Server (Azure Pipeline)
Run the project as a maven goal *verify*.
```
 clean verify        ---> set this as "Maven goal" within Agnet Pool Job in Azdo 
```

### Overriding Environment Variables and Tags:
We can pass a custom tag using terminal. Example tags are **@smoke**, **@regression**...
```
 mvn clean verify -Dcucumber.filter.tags="@smoke and not @regression"
```

We can pass multiple Tags as well with "OR", "AND" tags:
```
 "@smoke,regression"             --->  OR  = if seperated with COMMA
 "@smoke","@regression"          --->  AND = if passed in seperate QUOTES  
```

We can ignore/skip specific Tags with "~" before tag:
```
 "@smoke","~@regression"
```

### Overriding Browsers:
We can change browser value using command line argument "BROWSER":
```
 mvn verify -Dbrowser=safari
```

We can Override Platform (desktop, tablet, mobile) with below command:
```
 mvn clean verify -Dplatform=mobile
```

We can Override Browser, Platform and Tags all same time as well:
```
 mvn clean verify -Dbrowser=chrome -Dplatform=mobile -Dcucumber.filter.tags="@wip"
```

### GIT commands:
Clone repository:
```
git clone URL
```

Clone directly specific branch:
```
git clone -b <branchName> --single-branch <repourl>
```

