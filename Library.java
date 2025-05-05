import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> booksArray = new ArrayList<Book>();
    private List<Member>memberssArray = new ArrayList<Member>();
    private Scanner scanner;

    public Library() {
    }

    public void addBook(Scanner scanner){
        scanner.nextLine();
        int bookType;
        do {
            System.out.println("----------------Add Book-------------------");
            System.out.println("Do you want to add a Book or Ebook?");
            System.out.println( "1: Book\n"+
                                "2: Ebook\n"+
                                "3: Exit");
            System.out.println("Write your selection: ");
            bookType = scanner.nextInt();
            scanner.nextLine();

            if (bookType == 1){
                addNormalBook(scanner);
            }
            else if (bookType == 2) {
                addEbook(scanner);
            }
            else if (bookType == 3) {
                break;
            }else{
                System.out.println("Please write a valid option option");
            }
        }while (bookType!=3);
    }

    public void registerMember(Scanner scanner){
        int optionMenu;
        scanner.nextLine();
        do {
            System.out.println("---------------------Add new member------------------------------");
            System.out.println("Do you want to add a normal member or Premium member?");
            System.out.println("1: Normal Member \n" +
                               "2: Premium Member\n" +
                               "3: Exit");
            optionMenu = scanner.nextInt();
            scanner.nextLine();

            if (optionMenu == 1){
                addNormalMember(scanner);
            }

            else if (optionMenu == 2) {
                addPremiumMember(scanner);
            }

        }while (optionMenu !=3);

    }

    public void addNormalBook(Scanner scanner){
        String titleAux = "";
        String authorAux = "";
        int ISBNAux = 0 ;
        boolean availabilityAux = true;

        System.out.println("-----------Add Normal Book---------------------");

            System.out.println("Write the ISBN:");
            ISBNAux = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Write the title of the Book:");
            titleAux = scanner.nextLine();
            System.out.println("Write the author name of the Book:");
            authorAux = scanner.nextLine();
            booksArray.add(new Book(titleAux,authorAux,ISBNAux,availabilityAux));


    }

    public void addEbook(Scanner scanner){
        String titleAux = "";
        String authorAux = "";
        int ISBNAux = 0 ;
        boolean availabilityAux = true;
        String fileFormatAux = "";
        float fileSizeAux;

        System.out.println("-----------Add EBook----------------------------");
            System.out.println("Write the title of the Book:");
            titleAux = scanner.nextLine();
            System.out.println("Write the author name of the Book:");
            authorAux = scanner.nextLine();
            System.out.println("Write the ISBN:");
            ISBNAux = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Write the File format:");
            fileFormatAux = scanner.nextLine();
            System.out.println("Write the File size:");
            fileSizeAux = scanner.nextFloat();
            scanner.nextLine();
            booksArray.add(new EBook(titleAux, authorAux, ISBNAux, availabilityAux, fileFormatAux, fileSizeAux));
    }

    public void addNormalMember(Scanner scanner){
        String nameAux = "";
        int idAux;
        System.out.println("--------------------Add Normal Member------------------");

        if (memberssArray.isEmpty()){
            System.out.println("Write the name of the user");
            nameAux = scanner.nextLine();
            System.out.println("Write the id of the user");
            idAux = scanner.nextInt();
            scanner.nextLine();
            memberssArray.add(new Member(nameAux,idAux));
        }
        else {
            System.out.println("Write the name of the user");
            nameAux = scanner.nextLine();
            System.out.println("Write the id of the user");
            idAux = scanner.nextInt();
            if (memberExist(idAux)){
                System.out.println("This user already exist");
            }else{
                scanner.nextLine();
                memberssArray.add(new Member(nameAux,idAux));
            }


        }
    }

    public void  addPremiumMember(Scanner scanner){

        System.out.println("--------------------Add Premium Member------------------");
        String nameAux = "";
        int idAux;
        if (memberssArray.isEmpty()){
            System.out.println("Write the name of the user");
            nameAux = scanner.nextLine();
            System.out.println("Write the id of the user");
            idAux = scanner.nextInt();
            scanner.nextLine();
            memberssArray.add(new PremiumMember(nameAux,idAux));
        }
        else {
            System.out.println("Write the name of the user");
            nameAux = scanner.nextLine();
            System.out.println("Write the id of the user");
            idAux = scanner.nextInt();
            if (memberExist(idAux)){
                System.out.println("This user already exist");
            }else{
                scanner.nextLine();
                memberssArray.add(new PremiumMember(nameAux,idAux));
            }


        }
    }

    public void memberBorrowBook(Scanner scanner){
        int memberIdAux ;
        int isbnAux;
        int memberIndex;
        int bookIndex;
        System.out.println("----------------------------Borrow book--------------------------------");
        System.out.println("Write the ID of the member who wants to borrow a book:");
        memberIdAux = scanner.nextInt();
        scanner.nextLine();
        if (!memberExist(memberIdAux)){
            System.out.println("This member doesn't exist ");
            System.out.println();
        }else{
            System.out.println("Write the ISBN of the book to Borrow:");
            isbnAux = scanner.nextInt();
            scanner.nextLine();
            if (!bookExist(isbnAux)){
                System.out.println("This book doesn't exist");
                System.out.println();
            }
            else {
                memberIndex = getMemberIndex(memberIdAux);
                bookIndex = getBookIndex(isbnAux);
                if (booksArray.get(bookIndex).isAvailability()){
                    booksArray.get(bookIndex).setAvailability(false);
                    memberssArray.get(memberIndex).borrowBook(booksArray.get(bookIndex));
                }else{
                    System.out.println("*This book is not available*");
                }

            }
        }
    }

    public int getMemberIndex(int memberId){
        int indexAux = 0;
        for (int i = 0; i <memberssArray.size() ; i++) {
            if (memberssArray.get(i).getMemberId() == memberId){
                indexAux = i;
                break;
            }
        }
        return indexAux;
    }

    public boolean memberExist(int id){
        boolean exist = false;
        for (Member items : memberssArray){
            if (items.getMemberId() == id){
                exist = true;
                break;
            }
        }
        if (exist){
            return true;
        }else{
            return false;
        }
    }

    public boolean bookExist(int isbn){
        boolean exist = false;
        for (Book items : booksArray){
            if (items.getISBN() == isbn){
                exist = true;
                break;
            }
        }
        if (exist){
            return true;
        }else{
            return false;
        }
    }

    public int getBookIndex(int isbn){
        int indexAux = 0;
        for (int i = 0; i <booksArray.size() ; i++) {
            if (booksArray.get(i).getISBN()== isbn){
                indexAux = i;
                break;
            }
        }
        return indexAux;
    }

    public void showBooks(){
        System.out.println("-----------------------------Available Books-----------------------------");
        for (Book items : booksArray){
            if (items.isAvailability()){
                System.out.println(items.showInformation());
            }

        }
    }

    public void showMembers(){
        System.out.println("-------------------------Members--------------------------");
        for (Member items:memberssArray){
            System.out.println(items.memberInformation());
        }
    }

}
