
# Bible API Automation

## Description
This project automates testing for the Bible API using Rest Assured, Java, and JUnit. It is designed to be simple, scalable, and reusable. The project includes tests for various endpoints provided by the Bible API and ensures that the API functions as expected.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── utils
│   │   │       └── ApiUtils.java
│   ├── test
│   │   ├── java
│   │   │   ├── tests
│   │   │   │   ├── BiblesTest.java
│   │   │   │   ├── BooksTest.java
│   │   │   └── BaseTest.java
│   └── resources
├── .github
│   └── workflows
│       └── main.yml
├── Dockerfile
├── pom.xml
└── README.md
```

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
- **Bible API**: https://api.scripture.api.bible/v1/

## How to Run the Project

### Prerequisites
- JDK 11 or higher
- Maven
- Docker (optional, for running tests in a container)
- GitHub account with repository access

### Setup
1. Clone the Repository:
    ```bash
    git clone https://github.com/your-username/bible-api-automation.git
    cd bible-api-automation
    ```

2. Set Up the API Key:
   Open `ApiUtils.java`. Replace the placeholder API key with your actual API key:
    ```java
    private static final String API_KEY = "your_actual_api_key_here";
    ```

3. Run Tests Locally:
    ```bash
    mvn clean test
    ```

### Running Tests with Docker

1. Build the Docker Image:
    ```bash
    docker build -t bible-api-automation .
    ```

2. Run the Docker Container:
    ```bash
    docker run -e API_KEY=your_actual_api_key_here bible-api-automation
    ```

### GitHub Actions
The project includes a GitHub Actions workflow (`.github/workflows/main.yml`) that automates the test execution process.

1. Set Up Secrets:
    - Go to your GitHub repository settings.
    - Navigate to `Secrets and variables` > `Actions` > `New repository secret`.
    - Add your API key as a secret named `API_KEY`.

2. Trigger the Workflow:
    - The workflow runs automatically on push and pull request events.

## Test Cases

### Bibles Endpoint
1. **Valid API Key**: Verify that the `/bibles` endpoint returns a 200 status code and contains valid data.
2. **Invalid API Key**: Verify that the `/bibles` endpoint returns a 500 status code with an appropriate error message.
3. **No API Key**: Verify that the `/bibles` endpoint returns a 401 status code with an appropriate error message.

### Books Endpoint
1. **Valid API Key**: Verify that the `/bibles/{bibleId}/books` endpoint returns a 200 status code and contains valid data for a given Bible ID.
2. **Invalid API Key**: Verify that the `/bibles/{bibleId}/books` endpoint returns a 500 status code with an appropriate error message.
3. **No API Key**: Verify that the `/bibles/{bibleId}/bookss` endpoint returns a 401 status code with an appropriate error message.
```

### Short Explanation of the provided solution
1. **Automation: Reduces manual effort and enhances test coverage by automating repetitive API testing tasks.
2. **Consistency: Ensures consistent test execution and validation of API responses across different environments
3. **Integration: Integrates seamlessly with Continuous Integration/Continuous Deployment (CI/CD) pipelines for automated testing in development workflows.
