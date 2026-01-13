package services;

import java.util.HashMap;
import java.util.Map;

import models.Books;
import models.User;

public class LibraryServices {
    private Map<String,Books> books=new HashMap<>();
    private Map<String,User> users=new HashMap<>();

    //add books in the library
    public void addBooks(Books book){
        books.put(book.getId(),book);
    }
    //add users
    public void addUsers(User user){
        users.put(user.getUserId(),user);
    }

    //Borrowing books
    public void borrowBook(String userId,String bookId){
        //Find the user and books in our map
        User user=users.get(userId);
        Books book=books.get(bookId);

        //check if they both exist
        if (user==null || book==null) {
            System.out.println("Error:User or book not Found");
            return;
        }
        //check if the book is borrowed
        if (book.isBorrowed()) {
            System.out.println("Sorry, " + book.getTittle() + " is already borrowed.");
        }else{
            book.setBorrowed(true);
            user.borrowBook(book);
            System.out.println(user.getUserName() + " successfully borrowed " + book.getTittle());
        }
    }

    public void returnBook(String userId,String bookId){
        User user=users.get(userId);
        Books book=books.get(bookId);
        if (user!=null && book!=null) {
            book.setBorrowed(false);
            user.getBorrowedBooks().remove(book);
            System.out.println(user.getUserName()+" Succesfully returned "+ book.getTittle());
            return;
        }
        System.out.println("Error:User / book not found");
    }

    //This helps the FileHandler save the books.Since it needs to see the books in the libraryServive
    // b4 it  saves it
    public Map<String,Books> getAllBooks(){
        return this.books;
    }

    public Map<String, User> getAllUsers() {
      return this.users;
    }
}
