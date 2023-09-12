import java.util.Scanner;

public class Menu1 {

    public static void main(String[] args) {
        DoublyList myList = new DoublyList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Insert at end");
            System.out.println("2) Insert anywhere");
            System.out.println("3) Print");
            System.out.println("4) Count");
            System.out.println("5) Search");
            System.out.println("6) Delete");
            System.out.println("7) Sort");
            System.out.println("8) Edit");
            System.out.println("9) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number: ");
                    int number = scanner.nextInt();
                    myList.insertAtEnd(new Info(name, number));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String nameToInsert = scanner.nextLine();
                    System.out.print("Enter number: ");
                    int numberToInsert = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    myList.insertAnywhere(new Info(nameToInsert, numberToInsert), position);
                    break;
                case 3:
                    System.out.println("List:");
                    myList.print();
                    break;
                case 4:
                    int count = myList.count();
                    System.out.println("Number of nodes: " + count);
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    myList.search(nameToSearch);
                    break;
                case 6:
                    System.out.print("Enter name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    myList.delete(nameToDelete);
                    break;
                case 7:
                    myList.sort();
                    System.out.println("List sorted.");
                    break;
                case 8:
                    System.out.print("Enter name to edit: ");
                    String nameToEdit = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new number: ");
                    int newNumber = scanner.nextInt();
                    myList.edit(nameToEdit, newName, newNumber);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
