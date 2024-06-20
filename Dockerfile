# Use an official OpenJDK runtime as a parent image
FROM openjdk:20-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the project
RUN mvn clean install

# Run the tests
CMD ["mvn", "test"]
