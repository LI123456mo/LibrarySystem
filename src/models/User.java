package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String userId;
    private List<Books> borrowedBooks;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        //Initialize list as empty so it is ready to hold books
        this.borrowedBooks = new ArrayList<>();
    }
    public String getUserName() {
        return userName;
    }
    public String getUserId() {
        return userId;
    }
    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void borrowBook(Books book){
        borrowedBooks.add(book);
    }
}
