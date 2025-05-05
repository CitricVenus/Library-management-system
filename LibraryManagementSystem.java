import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("--------------------Welcome to Library Management-----------------------");
            System.out.println("What do you want to do?");
            System.out.println("1: Add book\n" +
                               "2: Register new user\n"+
                               "3: Borrow book\n" +
                               "4: Show available books\n" +
                               "5: Show registered members\n"+
                               "6: Exit");
            System.out.println("-------------------------------------------------------------------------");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    library.registerMember(scanner);
                    break;
                case 3:
                    library.memberBorrowBook(scanner);
                    break;
                case 4:
                    library.showBooks();
                    break;
                case 5:
                    library.showMembers();
                    break;
                case 6:
                    break;
            }

        }while(option!=6);

        scanner.close();
    }
}
