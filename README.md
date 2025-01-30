# attendance-system
# Backend Setup for Authentication System with Spring Boot

Prerequisites
Before starting, ensure you have the following tools installed:

Java 21: You need Java 21 installed on your system. 

Maven: Make sure Apache Maven is installed.


VS Code: Install Visual Studio Code from here.

Spring Boot Initializer Plugin for VS Code: To simplify Spring Boot project creation, you can use the Spring Boot Initializr plugin for VS Code.

Open VS Code.
Go to the Extensions panel (or press Ctrl+Shift+X).
Search for Spring Boot Initializr and install it.

## Step 1: Install Maven

Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Users\piranavan\Music\grade6wiki\apache-maven-3.9.9
Java version: 21, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-21
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"


## Step 2: Create Spring Boot Project Using VS Code

## Step 3 : Add Dependencies to pom.xml such as jaxb-api,jjwt

## Step :Set Up Basic File Structure

Step 5: Add CORS Configuration in AuthController
add your frontend port no like
 @CrossOrigin(origins = "http://127.0.0.1:5500")

## Step: Application Properties add properties
        server.port=8080
        spring.main.allow-bean-definition-overriding=true

## Step: Running the Application
mvn clean install :-Build the Project
mvn spring-boot:run :- Run the Application

* ## Step:- Add credentials in user.txt in resources file such as*
**********************************************************************************************************************
Piranavan,Pirana2000
user123,user@2000

**********************************************************************************************************************

Step 9:-check Restapi with postman 
method:-POST
Restapi:-http://localhost:8080/api/login


# Frontend
## Files Overview
The index.js file handles the login functionality and home page
## home.js
Bootstrap: For responsive and mobile-first web design.
Font Awesome: For providing high-quality icons.
markdown
## login.js (Login Form, Validations, and API Calls)

For Run the Application add Live server Extension in vs code

LOGIN CREDENTIALS

 "username": "Piranavan",
 "password": "Pirana2000" 

 OR 

"username": "user123",
"password": "user@2000"





