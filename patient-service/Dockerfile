# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk AS runner

WORKDIR /app

# Copy the built jar from builder
COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

# Correct ENTRYPOINT
ENTRYPOINT ["java", "-jar", "app.jar"]
