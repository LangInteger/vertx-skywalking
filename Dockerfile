FROM openjdk:11-jre

# Copy your Java application JAR file into the container
COPY build/libs/vertx-skywalking-1.0-SNAPSHOT-fat.jar /app/your-app.jar

# Set the working directory
WORKDIR /app

# Command to run the Java application
CMD ["java", "-jar", "your-app.jar"]