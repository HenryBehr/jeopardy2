import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class PhoneBookTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();


        while (true) {
            System.out.println("Enter 1 to display all");
            System.out.println("Enter 2 for search");
            System.out.println("Enter 3 to add contact");
            System.out.println("Enter 4 to delete contact");
            System.out.println("Enter 5 to sort");
            System.out.println("Enter 6 to save file");
            System.out.println("Enter 10 to quit");
            int choice = scanner.nextInt();

            if (choice == 1) pb.displayAll();

            if (choice == 2) {
                scanner = new Scanner(System.in);
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                PhoneEntry entry = pb.search(firstName, lastName);
                if (entry != null) System.out.println(entry.firstName + " " + entry.lastName + ": " + entry.phone);
                else
                    System.out.println("Name not found");
            }

            if (choice == 3) {
                scanner = new Scanner(System.in);
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.nextLine();
                pb.addName(firstName, lastName, phoneNumber);
            }

            if (choice == 4) {
                scanner = new Scanner(System.in);
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();
                pb.deleteName(firstName, lastName);
            }

            if (choice == 5) pb.bubbleSort();

            if (choice == 6) pb.saveToFile();

            if (choice == 10) System.exit(0);

        }
    }
}
