# MapSync UI Automation for QI

								=======================
								Framework Architecture:
								=======================

Project - Maven
Framework - Page Object Model using Page Factory in Selenium.
Language - Java
WebDriver - 3.141 version
Browsers - chrome/firefox/IE
OS - Windows/Linux/Mac
Test Executions - TestNG (or) maven test
Screenshots - {rootfolder}\target\surefire-reports\Screenshots\passed & {rootfolder}\target\surefire-reports\Screenshots\failed
Logger - Log4j - {rootfolder}/target/Log.log
Reports - testng reports - {rootfolder}\target\surefire-reports\index.html, {rootfolder}\target\surefire-reports\emailable-report.html
ReportNG reports -  {rootfolder}\target\surefire-reports\html\index.html
Editor - Eclipse

=================
Folder Structure
=================
src/main/java - Individual pages are classified in to their corresponding packages and written inside java file
				Framework related codes

src/main/resources - contains application config properties,driver folder containing different driver files based on OS and log4j.xml file

src/test/java - TestNG test class files

src/test/resources - contains TestNG.xml file in SuiteFiles and testdata inside testdataconfig properties file

target/Log.log - contains test execution log informations

Screenshots - contains test execution passed/failed screenshots if executed as TestNG tests

pom.xml - contains dependencies,plugins,etc

===========
Executions:
===========
Change the src/main/resources/configfile/config.properties
======
Local
======
mode = local
browser = chrome
os = Windows
headless = no

==========
Saucelabs
=========
mode = saucelabs
browser = chrome
os = Windows 10
version=latest


=======
TestNG
=======
For running test:
 Right click on src/test/resources/suitexmlfiles/<Any .xml file> and Run As-> TestNG Suite
	(OR)
 Right click on pom.xml and Run As-> Maven test with property variable as -DsuiteXmlFile="Regression.xml"

Reports - testng reports - {rootfolder}\target\surefire-reports\index.html, {rootfolder}\target\surefire-reports\emailable-report.html
	      ReportNG reports -  {rootfolder}\target\surefire-reports\html\index.html
Screenshots - {rootfolder}\target\surefire-reports\Screenshots\passed & {rootfolder}\target\surefire-reports\Screenshots\failed
Logger - {rootfolder}/target/Log.log
