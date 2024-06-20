# Bible API Automation

## Description

This project automates testing for the Bible API using Rest Assured, Java, and JUnit. It is designed to be simple, scalable, and reusable. The project includes tests for various endpoints provided by the Bible API and ensures that the API functions as expected.

## Project Structure
├── src
│ ├── main
│ │ ├── java
│ │ │ └── utils
│ │ │ └── ApiUtils.java
│ ├── test
│ │ ├── java
│ │ │ ├── tests
│ │ │ │ ├── BiblesTest.java
│ │ │ │ └── BooksTest.java
│ │ │ └── BaseTest.java
│ └── resources
├── .github
│ └── workflows
│ └── main.yml
├── Dockerfile
├── pom.xml
└── README.md


## Key Directories and Files

- **src/main/java/utils/ApiUtils.java**: Contains reusable utility methods for making API requests.
- **src/test/java/tests**: Contains the test classes for different API endpoints.
    - **BiblesTest.java**: Tests for the `/bibles` endpoint.
    - **BooksTest.java**: Tests for the `/bibles/{bibleId}/books` endpoint.
- **BaseTest.java**: Contains common setup and teardown methods for the tests.
- **.github/workflows/main.yml**: GitHub Actions workflow for running tests.
- **Dockerfile**: Docker configuration for running the tests in a container.
- **pom.xml**: Maven configuration file.

## Tools and Technologies

- **Java**: Programming language used for writing the tests.
- **Maven**: Build and dependency management tool.
- **JUnit**: Testing framework.
- **Rest Assured**: Java library for testing REST APIs.
- **GitHub Actions**: CI/CD tool for automating the test execution.
- **Docker**: Containerization tool to run tests in an isolated environment.

## Automated Website

- **Bible API**: [https://api.scripture.api.bible/v1/](https://api.scripture.api.bible/v1/)

## How to Run the Project

### Prerequisites

- JDK 11 or higher
- Maven
- Docker (optional, for running tests in a container)
- GitHub account with repository access

### Setup

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/your-username/bible-api-automation.git
   cd bible-api-automation

2. Set Up the API Key:

    Open ApiUtils.java.
    Replace the placeholder API key with your actual API key:
   private static final String API_KEY = "9bbcfb59117ffd862fa4120c2b7f7128";
3. Run Tests Locally: mvn clean test

### Running Tests with Docker
    Build the Docker Image: docker build -t bible-api-automation .
    docker build -t bible-api-automation .

### Run the Docker Container:
    docker run -it bible-api-automation

    GitHub Actions
The project includes a GitHub Actions workflow (.github/workflows/main.yml) that automates the test execution process.

Set Up Secrets:

Go to your GitHub repository settings.
Navigate to Secrets and variables > Actions > New repository secret.
Add your API key as a secret named API_KEY.
Trigger the Workflow:

The workflow runs automatically on push and pull request events.

Test Cases
Bibles Endpoint
Valid API Key: Verify that the /bibles endpoint returns a 200 status code and contains valid data.
Invalid API Key: Verify that the /bibles endpoint returns a 500 status code with an appropriate error message.
No API Key: Verify that the /bibles endpoint returns a 401 status code with an appropriate error message.
Books Endpoint
Valid API Key: Verify that the /bibles/{bibleId}/books endpoint returns a 200 status code and contains valid data for a given Bible ID.




