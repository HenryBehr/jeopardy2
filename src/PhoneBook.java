import javax.swing.*;
import java.io.*;

class PhoneBook {
    static PhoneEntry[] phoneBook;    //declare an array


    PhoneBook()    // constructor for the phone book
    {
        phoneBook = new PhoneEntry[50];

        phoneBook[0] = new PhoneEntry("Donny", "Brook", "(418)665-1223");
        phoneBook[1] = new PhoneEntry("Frank", "Enstein", "(860)399-3044");
        phoneBook[2] = new PhoneEntry("Evan", "Keel", "(815)439-9271");
        phoneBook[3] = new PhoneEntry("Ali", "Katt", "(312)223-1937");
        phoneBook[4] = new PhoneEntry("Jo", "King", "(913)883-2874");
    }

    public PhoneEntry search(String firstName, String lastName) {
        for (int j = 0; j < phoneBook.length; j++) {
            if (phoneBook[j] != null) {
                if (phoneBook[j].firstName.equalsIgnoreCase(firstName) && phoneBook[j].lastName.equalsIgnoreCase(lastName))
                    return phoneBook[j];
            }
        }
        return null;
    }

    public static void displayAll() {
        for (int j = 0; j < phoneBook.length; j++) {
            if (phoneBook[j] != null) System.out.println(phoneBook[j].firstName + " " + phoneBook[j].lastName);
        }
        System.out.println();
    }

    public void addName(String fn, String ln, String p) {
        PhoneEntry temp = new PhoneEntry(fn, ln, p);
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i] == null) {
                phoneBook[i] = temp;
                break;
            }
        }
    }

    public void deleteName(String fn, String ln) {
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].firstName.equalsIgnoreCase(fn) && phoneBook[i].lastName.equalsIgnoreCase(ln)) {
                phoneBook[i] = null;
                break;
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length - 1; j++) {
                if (phoneBook[j] != null && phoneBook[j + 1] != null) {
                    if (phoneBook[j].lastName.compareToIgnoreCase(phoneBook[j + 1].lastName) > 0) {
                        PhoneEntry temp = phoneBook[j];
                        phoneBook[j] = phoneBook[j + 1];
                        phoneBook[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void saveToFile() {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt"));
            outputStream.println("your text here");
            outputStream.close();
        } catch (Exception e){
            System.out.println("File failure");
        }

    }
}