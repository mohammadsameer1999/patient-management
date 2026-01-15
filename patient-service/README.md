# Patient Service

A microservice for managing patient data and operations built with Spring Boot and PostgreSQL.

## Features

- Create new patients
- Retrieve patient information
- Update patient details
- Delete patient records
- Get all patients
- Docker containerization with multi-stage builds
- PostgreSQL database integration

## Technology Stack

- **Framework**: Spring Boot 4.0.1
- **Database**: PostgreSQL 15
- **Java Version**: 21
- **Build Tool**: Maven
- **Containerization**: Docker & Docker Compose
- **Documentation**: Swagger/OpenAPI

## Project Structure

```
patient-service/
├── src/main/java/com/pm/patient_service/
│   ├── controller/     # REST API controllers
│   ├── dto/            # Data Transfer Objects
│   ├── service/        # Business logic layer
│   ├── entity/         # JPA entities
│   └── validators/     # Validation groups
├── docker-compose.yml  # Multi-service setup
├── Dockerfile         # Multi-stage build
└── README.md
```

## Quick Start with Docker (Recommended)

### Prerequisites
- Docker
- Docker Compose

### Running with Docker Compose

1. Clone the repository
2. Navigate to the patient-service directory
3. Start all services:
   ```bash
   docker-compose up --build
   ```

This will start:
- **PostgreSQL database** on port 5432
- **Patient Service** on port 8081

### API Endpoints

Base URL: `http://localhost:8081/api/patient`

#### GET /api/patient/getAllPatient
Retrieve all patients

#### POST /api/patient/create-patient
Create a new patient

**Request Body:**
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main Street, New York, NY 10001",
  "dateOfBirth": "1990-05-15",
  "registeredDate": "2024-01-20"
}
```

#### PUT /api/patient/{id}
Update patient information

#### DELETE /api/patient/{id}
Delete a patient record

### Example API Usage

```bash
# Create a patient
curl -X POST http://localhost:8081/api/patient/create-patient \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "address": "123 Main Street, New York, NY 10001",
    "dateOfBirth": "1990-05-15",
    "registeredDate": "2024-01-20"
  }'

# Get all patients
curl http://localhost:8081/api/patient/getAllPatient
```

## Alternative: Running Locally

### Prerequisites
- Java 21
- Maven 3.9+
- PostgreSQL 15

### Setup

1. Clone the repository
2. Configure PostgreSQL database
3. Update `application.properties` with your database settings
4. Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Documentation

Access Swagger UI at: `http://localhost:8081/swagger-ui.html`

## Database Configuration

The application uses PostgreSQL with the following default Docker configuration:
- Database: `patient_db`
- Username: `admin_user`
- Password: `password`
- Port: `5432`

## Troubleshooting

### Connection Reset Errors
If you encounter `ECONNRESET` errors:
1. Ensure services are running: `docker-compose ps`
2. Check logs: `docker-compose logs patient-service`
3. Verify port mapping in docker-compose.yml

### 404 Errors
- Ensure you're using the correct endpoint: `/api/patient/...`
- Check that the service has fully started

### Database Connection Issues
- Verify PostgreSQL container is running
- Check database credentials in docker-compose.yml
- Wait for database initialization (may take 30-60 seconds on first run)