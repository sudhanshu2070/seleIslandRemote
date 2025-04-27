# Selenium Spring App

A Spring Boot application that uses Selenium to fetch the title of a website via a REST API.

## Overview

This project demonstrates how to integrate **Selenium** with **Spring Boot** to create a RESTful API. The API allows users to pass a website URL as a query parameter and returns the page title of the provided website.

Key Features:
- Fetches the title of any valid website using Selenium.
- Handles invalid or missing URLs gracefully.
- Uses **WebDriverManager** to automatically manage browser drivers.
- Follows a clean, modular structure with separate layers for controllers, services, and utilities.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Project Structure](#project-structure)
3. [Setup Instructions](#setup-instructions)
4. [API Endpoints](#api-endpoints)
5. [Testing the API](#testing-the-api)
6. [Contributing](#contributing)
7. [License](#license)

---

## Prerequisites

Before running the project, ensure you have the following installed:
- **Java 17 or later**: Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).
- **Maven**: Install Maven from [Apache Maven](https://maven.apache.org/download.cgi).
- **Postman** (optional): For testing the API. Download from [Postman](https://www.postman.com/downloads/).

---

## Project Structure

The project follows a modular structure with separate layers for better maintainability:


---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/sudhanshu2070/seleIslandRemote.git
cd SeleniumSpringApp
```

### 2. Build the Project
Run the following command to build the project using Maven:
```bash
mvn clean install
```

### 3. Run the Application
Start the Spring Boot application:
````bash
mvn spring-boot:run
````

The application will start on port 8080 by default. You should see logs indicating that the server has started successfully:
Tomcat started on port 8080 (http) with context path '/'