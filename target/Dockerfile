FROM openjdk:17

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the image
COPY target/quiz_soilmonitoring-0.0.1.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]