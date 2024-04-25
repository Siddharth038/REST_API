# REST_API
Spring Boot app managing training centers. Features GET and POST API, MySQL integration, and validation. Ideal for training facility management.

# Training Center Management System

This is a simple Spring Boot application for managing training centers.

## Setup Instructions

### Prerequisites

- JDK (Java Development Kit)
- Maven
- MySQL Server
- Postman (for testing APIs)

### Steps

1. **Clone the Repository**: 
git clone https://github.com/Siddharth038/REST_API.git
cd REST_API

2. **Database Configuration and Application.properties**:
- Install MySQL Server if not already installed
  
spring.application.name=traini8
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/traini8_db
spring.datasource.username=root
spring.datasource.password=9758
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
server.port=8880

3. **Build the Project**:
mvn clean package


4. **Run the Application**:

5. **Testing APIs**:
- Open Postman.
- Use the following URLs to test the APIs:
  - GET: `http://localhost:8880/api/training-centers`
  - POST: `http://localhost:8880/api/training-centers/create`

## Using Postman

1. **GET Request**:
- Open Postman.
- Set the request type to `GET`.
- Enter the URL: `http://localhost:8880/api/training-centers`.
- Send the request.

2. **POST Request**:
- Open Postman.
- Set the request type to `POST`.
- Enter the URL: `http://localhost:8880/api/training-centers/create`.
- Add the request body as JSON with the required fields.
- Send the request.

## Database Schema

The application uses the following database schema:

### Table: training_centers

| Column Name      | Data Type       | Constraints      | Description                           |
|------------------|-----------------|------------------|---------------------------------------|
| id               | BIGINT          | PRIMARY KEY      | Unique identifier for the training center. |
| center_name      | VARCHAR(40)     | NOT NULL         | Name of the training center.          |
| center_code      | VARCHAR(12)     | NOT NULL         | Code of the training center.          |
| detailed_address | VARCHAR(255)    |                  | Detailed address of the training center. |
| city             | VARCHAR(255)    |                  | City where the training center is located. |
| state            | VARCHAR(255)    |                  | State where the training center is located. |
| pincode          | VARCHAR(10)     |                  | Pincode of the training center's location. |
| student_capacity | INT             | NOT NULL         | Maximum capacity of students at the training center. |
| courses_offered  | JSON or TEXT    |                  | Courses offered at the training center. |
| created_on       | BIGINT          |                  | Timestamp when the training center was created. |
| contact_email    | VARCHAR(255)    |                  | Email address of the contact person for the training center. |
| contact_phone    | VARCHAR(10)     |                  | Phone number of the contact person for the training center. |

### Table: address (Embedded in training_centers)

| Column Name      | Data Type       | Constraints      | Description                           |
|------------------|-----------------|------------------|---------------------------------------|
| detailed_address | VARCHAR(255)    |                  | Detailed address of the training center. |
| city             | VARCHAR(255)    |                  | City where the training center is located. |
| state            | VARCHAR(255)    |                  | State where the training center is located. |
| pincode          | VARCHAR(10)     |                  | Pincode of the training center's location. |
