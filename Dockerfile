FROM openjdk:11-jre

# Copy your Java application JAR file into the container
COPY build/libs/vertx-skywalking-1.0-SNAPSHOT-fat.jar /app/your-app.jar
# Copy skywalking agent
ADD skywalking-agent /app/skywalking-agent

# Set the working directory
WORKDIR /app

ENV SW_AGENT_COLLECTOR_BACKEND_SERVICES='oap:11800'
ENV SW_AGENT_NAME="vertx_service"
# Command to run the Java application
CMD ["java", "-javaagent:skywalking-agent/skywalking-agent.jar", "-jar", "your-app.jar"]