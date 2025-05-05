public class Member {

    private String name;
    private int memberId;
    private Book[] borrowedBooks = new Book[1];

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String regex = "^[a-zA-Z]+$";
        if (name.matches(regex)) {
            this.name = name;
        }
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String memberInformation(){
        return "Name: " + name + ", Id: " + memberId;
    }

    public void borrowBook(Book book){
        if (isBorrowedBooksFull()){
            System.out.println("**You reached the max amount of borrowed books for Normal Member**");
        }else {
            if (isDuplicatedBook(book)) {
                System.out.println("You can borrow only one book with this ISBN: " + book.getISBN());
            }else{
                addBorrowBookToUser(book);
                showBorrowedBooks();
            }
        }
    }

    public boolean isDuplicatedBook(Book book){
        boolean isDuplicated = false;
        for (int i = 0; i < borrowedBooks.length ; i++) {
            if (borrowedBooks[i] != null){
                if (borrowedBooks[i].equals(book)){
                    isDuplicated = true;
                    break;
                }
            }
        }
        return isDuplicated;
    }

    public boolean isBorrowedBooksFull(){
        boolean isFull = true;
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void addBorrowBookToUser(Book book){
        for (int i = 0; i < borrowedBooks.length ; i++) {
            if (borrowedBooks[i] == null){
                book.setAvailability(false);
                borrowedBooks[i] = book;
                break;
            }
        }
    }

    public void showBorrowedBooks(){
        System.out.println("~~~~~~~~~~~~~~ " + name + " Borrowed Books ~~~~~~~~~~~~~~~~");
        for(Book items : borrowedBooks){
            if (items != null){
                System.out.println(items.showInformation());
            }
        }
        System.out.println();
    }

}
