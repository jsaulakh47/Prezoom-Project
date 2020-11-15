#Prezoom Project

## Tools and technologies used

#### Maven
Maven is a build automation tools which is mainly used for Java bases project. Maven can help to build the whole application with just one command instead of manually writing long scripts for building the projects. It is also used for dependency management. Dependencies are nothing but third party libraries which are used in the application. If Maven is not used and any library or JAR is updated, then we have to manually update its JAR file in the project. However, with the help of Maven, it is very easy to update the dependencies i.e. we can just update the version number of the dependency in pom.xml. It dynamically downloads the libraries and plugins from the Maven Central Repository. Maven can also be used with other programming languages such as C#, Scala, and Ruby.

Project Object Model (pom.xml) file is the heart of any maven project. It contains dependencies, plugins, goals to be executed, source directory for code, etc., which is used by Maven to build the application. When we want to build the project using Maven, we supply Maven with the pom.xml file, which needs to be used to execute all the commands.

Maven is useful in the following scenarios:
1. If there are too many dependencies to be handled in the project.
2. When the libraries/JARs being used are updated frequently.
3. Continuous integration, continuous deployment and testing is handled by Maven.
4. Building the application package (JAR, WAR, ZIP etc.) and generating the documentation from source code is very easy using Maven.

#### JUnit
JUnit is an testing framework for Java applications. We need to create unit test case files in order to do unit testing. Unit test case code can help us ensure that the application logic is working as per our expectations.
Testing can of two types as following:
1. **Manual Testing**: It means doing the tests on application manually, without use of any testing script code. It is less reliable, prone to human errors, and time consuming process.
2. **Automation Testing**: It means writing the automated test scripts to test the application logic. It is more reliable and faster as compared manual testing.

JUnit is very much useful due to following reasons:
1. It helps us to identify bugs in our business logic code, which makes our application reliable.
2. Using JUnit will help us save time by not doing the testing manually.
3. JUnit is helpful in test-driven environment.
4. It helps to develop reliable, readable, and bug-free code, which boosts the confidence of developers using the software development.

Following are the some the annotations in Junit testing:
1. **@Test**: It indicates the method is test method.
2. **@Test(timeout=1000)**: It indicates that the test should fail if it is taking more than 1 second (1000 milliseconds) to run.
3. **@BeforeClass**: It indicates that the method will be called before starting any test case.
4. **@Before**: It indicates that the method will be called before each test.
5. **@After**: It indicates that the method will be called after each test.
6. **@AfterClass**: It indicates that the method will be called after completing any test case.


#### JavaFX

#### Test Driven Development

## Maven Setup on various OS

#### Windows

#### Linux

#### MacOS


## How to setup and run application

#### Maven Lifecycle


# Installation

## Download maven 3.6.3
wget https://www-us.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp

## Untar to /opt
tar xf /tmp/apache-maven-*.tar.gz -C /opt

## Install the alternative version for the mvn in your system
sudo update-alternatives --install /usr/bin/mvn mvn /opt/apache-maven-3.6.3/bin/mvn 363

## Check if your configuration is ok. You may use your current or the 3.6.3 whenever you wish, running the command below.

sudo update-alternatives --config mvn

## install javaFX
sudo apt-get install openjfx