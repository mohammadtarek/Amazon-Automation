# Test Automation Project

This repository contains the automation tasks for a hiring process, split into two parts:
1. **UI Automation**: Automated testing for Amazon's website using Selenium WebDriver, TestNG, Fluent Page Object Model (POM), and Data-Driven Testing (DDT).
2. **API Testing**: Automated testing for the REQRES APIs using Java RestAssured.

## Table of Contents
- Project Overview
- Installation
- Test Scenarios
- Running the Tests
- Error Handling
- Technologies Used

## Project Overview

### UI Automation for Amazon
This part of the project automates the following scenario on the Amazon Egypt website:
1. Open the Amazon homepage and log in.
2. Navigate to the "All" menu and click "Video Games," then select "All Video Games."
3. Apply filters for "Free Shipping" and "Condition: New."
4. Sort by "Price: High to Low."
5. Add all products with a cost below 15,000 EGP to the cart.
6. Ensure that all items are in the cart.
7. Add an address.
8. Verify the total amount.

The tests use Selenium WebDriver for UI testing, TestNG for test execution, and Maven for dependency management.

### API Testing for REQRES
This part of the project automates testing for the ReqRes API (https://reqres.in) with the following scenarios:
1. **Create a User**: Send a POST request to /api/users with a JSON payload containing user details.
2. **Retrieve a User**: Send a GET request to /api/users/{id}.
3. **Update a User**: Send a PUT request to /api/users/{id} with updated user details.

The tests use RestAssured for API testing, TestNG for test execution, and Maven for dependency management.

## Installation

To set up the project locally:

1. Clone the Repository:

2. **Dependencies**:
   - Java 11 or higher.
   - Maven for dependency management.
   - RestAssured, TestNG, and other dependencies are managed by Maven.

## Test Scenarios

### UI Automation Test Scenario

1. **Log in to Amazon**:
   - Navigate to the Amazon Egypt homepage and log in using valid credentials.

2. **Navigate to Video Games**:
   - Open the "All" menu from the left side and click on the "Video Games" category.
   - Choose "All Video Games."

3. **Apply Filters**:
   - Apply filters for "Free Shipping" and "Condition: New."

4. **Sort Products by Price**:
   - Sort products by "Price: High to Low."

5. **Add Products to Cart**:
   - Add all products with a cost below 15,000 EGP to the cart.

6. **Verify Cart and Address**:
   - Ensure all products are added to the cart.
   - Add an address.

7. **Verify Total Amount**:
   - Ensure the total amount is correct.

### API Test Scenarios

1. **Create a User**:
   - Send a POST request to /api/users with a JSON payload containing user details (name, job).
   - Validate the response to ensure the user is created successfully.

2. **Retrieve a User**:
   - Send a GET request to /api/users/{id} to fetch the user.
   - Validate that the response matches the user details.

3. **Update a User**:
   - Send a PUT request to /api/users/{id} with updated user details.
   - Validate that the changes are reflected in the response.

## Running the Tests

### For UI Tests:
1. Right-click on `gui-testng.xml` and click on **Run** to execute the UI automation tests.

### For API Tests:
1. Right-click on `api-testng.xml` and click on **Run** to execute the API tests.

## Error Handling

Error handling is implemented using:

- **Soft Assertions**: For validating conditions without interrupting the execution of the test (especially useful in UI tests).
- **Try-Catch Blocks**: To catch exceptions and log detailed error messages for debugging.
- **Timeouts**: Using Awaitility to wait for elements to be visible or for a condition to be met.
- **API Error Handling**: Ensures that the responses are validated for success or failure, and appropriate error messages are logged in case of failures (e.g., network issues, invalid requests).

## Technologies Used

- **Selenium WebDriver** for UI Automation
- **RestAssured** for API Testing
- **TestNG** for Test Execution
- **Maven** for Dependency Management
- **Java** as the programming language
- **Fluent Page Object Model (POM)** for UI automation
- **Data-Driven Testing (DDT)** for parameterization in test cases

