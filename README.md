# Library Reservation System

A backend project built with **Spring Boot** for managing book reservations. This project provides RESTful APIs for handling core functionalities such as registering books and students, creating reservations, and managing data validations.

## Features

- **Student Management**: Register students with details such as name and email (validated).
- **Book Management**: Register books with ISBN, title, author, and availability status.
- **Reservation System**: Create reservations for books by linking students and books with reservation and due dates.
- **Validation**: Ensures that all required fields (e.g., ISBN, email) are provided and correctly formatted.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **Java 11**
- **Maven** for dependency management

## Endpoints

### Students
- **POST /api/alunos** - Register a new student
  ```json
  {
      "matricula": "12345",
      "nome": "João Silva",
      "email": "joao.silva@example.com"
  }
  ```

- **GET /api/alunos** - Retrieve all registered students

### Books
- **POST /api/livros** - Register a new book
  ```json
  {
      "ISBN": "1234567890",
      "titulo": "Java Programming",
      "autor": "Autor X",
      "disponivel": true
  }
  ```

- **GET /api/livros** - Retrieve all registered books

### Reservations
- **POST /api/reservas** - Create a new reservation
  ```json
  {
      "matriculaAluno": "12345",
      "isbnLivro": "1234567890"
  }
  ```

- **GET /api/reservas** - Retrieve all reservations
