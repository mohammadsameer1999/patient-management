# Patient Service

A microservice for managing patient data and operations.

## Features

- Create new patients
- Retrieve patient information
- Update patient details
- Delete patient records
- Get all patients

## API Endpoints

### GET /patients
Retrieve all patients

### GET /patients/{id}
Get a specific patient by ID

### POST /patients
Create a new patient

### PUT /patients/{id}
Update patient information

### DELETE /patients/{id}
Delete a patient record

## Project Structure

```
patient-service/
├── src/
│   ├── controller/     # API controllers
│   ├── dto/            # Data Transfer Objects
│   ├── service/        # Business logic
│   └── model/          # Data models
└── patient-services/   # HTTP request examples
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven or Gradle

### Installation

1. Clone the repository
2. Navigate to the patient-service directory
3. Build the project:
   ```bash
   mvn clean install
   ```

### Running the Application

```bash
mvn spring-boot:run
```

The service will start on the default port (typically 8080).

## Testing

Run the HTTP requests in the `patient-services` directory to test the API endpoints.