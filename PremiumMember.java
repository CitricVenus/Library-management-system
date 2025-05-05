public class PremiumMember extends Member{

    private Book [] borrowingMoreBooks = new Book[2];

    public PremiumMember(String name, int memberId) {
        super(name, memberId);

    }

    public String memberInformation(){
        return super.memberInformation() + " (Premium Member)";
    }

    public void borrowBook(Book book){
        if (isBorrowedBooksFull()){
            System.out.println("You reached the max amount of borrowed books for Premium Member");
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
        for (int i = 0; i < borrowingMoreBooks.length ; i++) {
            if (borrowingMoreBooks[i] != null){
                if (borrowingMoreBooks[i].equals(book)){
                    isDuplicated = true;
                    break;
                }

            }
        }
        return isDuplicated;
    }

    public boolean isBorrowedBooksFull(){
        boolean isFull = true;
        for (int i = 0; i < borrowingMoreBooks.length; i++) {
            if (borrowingMoreBooks[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void addBorrowBookToUser(Book book){
        for (int i = 0; i < borrowingMoreBooks.length ; i++) {
            if (borrowingMoreBooks[i] == null){
                book.setAvailability(false);
                borrowingMoreBooks[i] = book;
                break;
            }
        }
    }

    public void showBorrowedBooks(){
        System.out.println("~~~~~~~~~~~~~~ " + super.getName() + " Borrowed Books ~~~~~~~~~~~~~~~~");
        for(Book items : borrowingMoreBooks){
            if (items != null){
                System.out.println(items.showInformation());
            }
        }
        System.out.println();
    }
}
