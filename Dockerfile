# Use an official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code into the container
COPY pom.xml .
COPY src ./src

# Run the Maven build command to create the JAR file
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/React-Sneakers-final-project-0.0.1-SNAPSHOT.jar .

# Specify the command to run the JAR file
CMD ["java", "-jar", "React-Sneakers-final-project-0.0.1-SNAPSHOT.jar"]
