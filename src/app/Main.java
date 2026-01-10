package app;

import java.util.Map;
import java.util.Scanner;

import data.FileHandler;
import models.Books;
import models.User;
import services.LibraryServices;

public class Main {
    public static void main(String[] args) {
        LibraryServices library=new LibraryServices();
        Scanner sc=new Scanner(System.in);

        Map<String, User> savedUsers = FileHandler.loadUsers();
        for (User u : savedUsers.values()) {
            library.addUsers(u);
        }

        //Auto load: The memory
        Map<String,Books> savedBooks=FileHandler.loadBooks();
        for(Books b:savedBooks.values()){
            library.addBooks(b);
        }
        System.out.println("=== WELCOME TO THE LIBRARY SYSTEM ===");
        
        boolean running=true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit & Save");
            System.out.print("Choose an option: ");

            try {
                // Read the whole line and convert to number to avoid Scanner bugs
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Library Inventory ---");
                        if (library.getAllBooks().isEmpty()) {
                            System.out.println("The library is currently empty.");
                        } else {
                            library.getAllBooks().values().forEach(System.out::println);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBooks(new Books(id, title, author));
                        System.out.println("Book added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter User ID: ");
                        String uId = sc.nextLine();
                        System.out.print("Enter Book ID to borrow: ");
                        String bId = sc.nextLine();
                        
                        // Check if user exists, if not, create one
                        if (library.getAllUsers().get(uId) == null) {
                            library.addUsers(new User("Bro Developer", uId));
                        }
                        
                        library.borrowBook(uId, bId);
                        break;

                    case 4:
                        System.out.print("Enter User ID: ");
                        String retUId = sc.nextLine();
                        System.out.print("Enter Book ID to return: ");
                        String retBId = sc.nextLine();
                        library.returnBook(retUId, retBId);
                        break;

                    case 5:
                        // Save everything before closing
                        System.out.println("Saving data...");
                        FileHandler.saveBooks(library.getAllBooks());
                        FileHandler.saveUsers(library.getAllUsers());
                        System.out.println("All data synced. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("⚠️ Invalid option. Please choose 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Please enter a valid number (1-5), not letters.");
            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            }
        }
        sc.close();
    }
}