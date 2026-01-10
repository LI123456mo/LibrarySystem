package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import models.Books;
import models.User;

public class FileHandler {

    // Inside FileHandler.java

    // Inside FileHandler.java

public static void saveUsers(Map<String, User> usersMap) {
    try (FileWriter writer = new FileWriter("users.txt")) {
        for (User user : usersMap.values()) {
            // We save the ID and the Name
            String line = user.getUserId() + " , " + user.getUserName() + "\n";
            writer.write(line);
        }
        System.out.println("Users saved successfully to users.txt");
    } catch (IOException e) {
        System.out.println("Error saving users: " + e.getMessage());
    }
}

    public static void saveBooks(Map<String,Books> booksMap){
        try(FileWriter writer=new FileWriter("books.txt")){
            for(Books book: booksMap.values()){
                String line=book.getId()+" , "+book.getTittle()+" , "+book.getAuthor()+" , "+book.isBorrowed()+"\n";
                writer.write(line);
            }
        }catch(IOException e){
            System.out.println("Error saving data: "+e.getMessage());
        }
    }

    public static Map<String, User> loadUsers() {
    Map<String, User> loadedUsers = new HashMap<>();
    File file = new File("users.txt");

    if (!file.exists()) return loadedUsers;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" , ");
            if (data.length == 2) {
                String id = data[1].trim();   // Remember your User constructor order!
                String name = data[0].trim(); // Name first, then ID based on your User.java
                
                User user = new User(name, id);
                loadedUsers.put(id, user);
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading users: " + e.getMessage());
    }
    return loadedUsers;
}

    //LOAD: Text File->Map
    public static Map<String,Books> loadBooks(){
        Map<String,Books> loadedBooks=new HashMap<>();
        File file=new File("books.txt");

        if(!file.exists())return loadedBooks;
        try(BufferedReader  reader=new BufferedReader(new FileReader(file))){
            String line;
            while ((line=reader.readLine())!=null) {
                //splitting the line back into an array
                String[] data=line.split(" , ");
                if (data.length==4) {
                    String id=data[0].trim();
                    String tittle=data[1].trim();
                    String author=data[2].trim();
                    boolean isBorrowed=Boolean.parseBoolean(data[3].trim());

                    Books book=new Books(id,tittle,author);
                    book.setBorrowed(isBorrowed);
                    loadedBooks.put(id,book);
                }
            }
        }catch(IOException e){
            System.out.println("Load Error: "+e.getMessage());
        }
        return loadedBooks;
    }
}
