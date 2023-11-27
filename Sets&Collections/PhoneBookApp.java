import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookApp {
    private TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addEntry(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

    public void viewEntries() {
        System.out.println("Phone Book Entries:");
        for (Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBookApp phoneBookApp = new PhoneBookApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Remove Entry");
            System.out.println("3. View Entries");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
    try {
        Scanner fileScanner1 = new Scanner(new File("Names.txt")).useDelimiter(",");
        Scanner fileScanner2 = new Scanner(new File("Number.txt")).useDelimiter(",");

        System.out.println("Reading entries from both files simultaneously:");

        // Continue reading until both files have no more lines
        while (fileScanner1.hasNext() && fileScanner2.hasNext()) {
            // Reading from the first file
            String name1 = fileScanner1.next().trim();

            // Reading from the second file
            String phoneNumber1 = fileScanner2.next().trim();

            phoneBookApp.addEntry(name1, phoneNumber1);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }
    break;

                
                case 2:
                    System.out.print("Enter Name to Remove: ");
                    String nameToRemove = scanner.nextLine();
                    phoneBookApp.removeEntry(nameToRemove);
                    System.out.println("Entry removed successfully.");
                    break;
                case 3:
                    phoneBookApp.viewEntries();
                    break;
                case 4:
                    System.out.println("Exiting Phone Book App.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

