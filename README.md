# 📚 Java Library Management System

A robust backend application built with Java that simulates a real-world library environment. This project demonstrates core Object-Oriented Programming (OOP) principles and data persistence.

## 🚀 Features
- **Data Persistence**: Saves and loads both Books and Users using File I/O (`BufferedReader` and `FileWriter`).
- **Interactive CLI**: A user-friendly command-line menu for managing library operations.
- **Robustness**: Implements Exception Handling to prevent crashes from invalid user input.
- **Logic Engine**: Automated systems for borrowing and returning books, checking availability, and managing user lists.

## 🛠️ Technologies Used
- **Language**: Java 
- **Data Structures**: HashMaps, ArrayLists
- **Concepts**: Encapsulation, Persistence, Error Handling, File Handling

## 📁 Project Structure
- `models`: Contains `Books` and `User` classes.
- `services`: Contains the `LibraryServices` logic engine.
- `data`: Handles the `FileHandler` for saving/loading `.txt` files.
- `app`: The entry point (`Main`) with the CLI menu.

## ⚙️ How to Run
1. Clone the repository.
2. Compile the files: `javac app/Main.java`.
3. Run the application: `java app.Main`.