package models;
public class Books {
    private String id;
    private String tittle;
    private String author;
    private boolean isBorrowed;
    public Books(String id, String tittle, String author) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
        this.isBorrowed=false;
    }
    public String getId() {return id;}
    public String getTittle() {return tittle;}
    public boolean isBorrowed() {return isBorrowed;}
    public void setBorrowed(boolean borrowed){
        isBorrowed=borrowed;
    }
    public String getAuthor() {
        return author;
    }
    @Override
    public String toString(){
        String status=isBorrowed?"[Borrowed]":"[Available]";
        return id+" | "+tittle+" by "+author+" "+status;
    }
}
