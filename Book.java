public class Book {

    private String title;
    private String author;
    private int ISBN;
    private boolean availability;

    public Book(String title, String author, int ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String regex = "^[a-zA-Z]+$";
        if (title.matches(regex)) {
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String regex = "^[a-zA-Z]+$";
        if (author.matches(regex)) {
            this.author = author;
        }
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String showInformation(){
        if (availability){
            return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
        }else{
            return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
        }
    }

}
