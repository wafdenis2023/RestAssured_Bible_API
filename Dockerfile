# Use an official Maven image with JDK 11 (or your required version)
FROM maven:3.8.5-openjdk-20-slim

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the project source
COPY src ./src

# Copy the rest of the project files
COPY . .

# Build the project
RUN mvn clean install

# Command to run tests
CMD ["mvn", "test"]
