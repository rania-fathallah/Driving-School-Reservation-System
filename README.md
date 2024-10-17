
# Driving School Reservation System

## Description
This project is a console-based Java application for managing a driving school reservation system, developed as part of a second-year engineering course. The application allows users to reserve driving lessons or exams, manage student information, and view available cars and mentors. It provides basic CRUD (Create, Read, Update, Delete) functionality to manage reservations and track driving school resources. By using MongoDB for data persistence, the application enables efficient management of driving lessons, exams, students, and vehicles.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- MongoDB server installed and running
- MongoDB Java Driver (added as a dependency in the project)

## Features

- **Student Management**: 
  - Add new students
  - Remove existing students
  - Update student payment status
  - Search for specific students
  - Print the entire list of students

- **Engineer Management**:
  - Add engineers
  - Remove engineers
  - Retrieve engineer information
  - Print the entire list of engineers

- **Vehicle Management**:
  - Add new vehicles
  - Remove existing vehicles
  - Retrieve vehicle information
  - Print the entire list of vehicles

- **Session Management**:
  - Add new driving sessions
  - Print the list of sessions associated with a specific student

- **Exam Management**:
  - Add new driving exams
  - Retrieve exam details

## Project Structure

```
.
├── codecs
│   ├── AppointmentCodec.java
│   ├── EngineerCodec.java
│   ├── ExamCodec.java
│   ├── SessionCodec.java
│   ├── StudentCodec.java
│   └── VehicleCodec.java
├── controlers
│   ├── AppointmentControler.java
│   ├── EngineerControler.java
│   ├── ExamControler.java
│   ├── SessionControler.java
│   ├── StudentControler.java
│   └── VehicleControler.java
├── dao
│   ├── Engineerdao.java
│   ├── Examdao.java
│   ├── Sessiondao.java
│   ├── Studentdao.java
│   └── Vehicledao.java
├── entities
│   ├── Appointment.java
│   ├── CodeExam.java
│   ├── DrivingExam.java
│   ├── Engineer.java
│   ├── Motorcycle.java
│   ├── Student.java
│   ├── Vehicle.java
│   ├── Car.java
│   ├── CodeSession.java
│   ├── DrivingSession.java
│   ├── Exam.java
│   └── Session.java
├── exceptions
├── input
│   ├── AppointmentInput.java
│   ├── EngineerInput.java
│   ├── ExamInput.java
│   ├── SessionInput.java
│   ├── StudentInput.java
│   └── VehicleInput.java
├── mainApplication
│   ├── EngineerStart.java
│   ├── ExamStart.java
│   ├── SessionStart.java
│   ├── Start.java
│   ├── StudentStart.java
│   └── VehicleStart.java
└── output
```

### Running the Application

To run the application, navigate to the `mainApplication` directory and execute the `Start` class.

```bash
javac mainApplication/Start.java
java mainApplication.Start
```

### Usage

Once the application starts, you will be presented with a menu to choose from various functionalities such as managing students, engineers, vehicles, lessons, and exams.
