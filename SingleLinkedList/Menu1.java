import java.util.Scanner;

public class Menu1 {

public static void main(String[] args) {

LinkedList linkedList = new LinkedList();

Scanner sc = new Scanner(System.in);

int x = 0;

while (x != 9) {

System.out.println("1) Insert at end\r\n" +

"2) Insert anywhere\r\n" +

"3) Print\r\n" +

"4) Count\r\n" +

"5) Search\r\n" +

"6) Delete\r\n" +

"7) Sort\r\n" +

"8) Edit\r\n" +

"9) Exit");


x = sc.nextInt();

sc.nextLine();

switch (x) {

case 1:

System.out.print("Enter name: ");

String name = sc.nextLine();

System.out.print("Enter number: ");

int number = sc.nextInt();

linkedList.insertAtEnd(new Info(name, number));

break;

case 2:

System.out.print("Enter name: ");

String name2 = sc.nextLine();

System.out.print("Enter number: ");

int number2 = sc.nextInt();

System.out.print("Enter position: ");

int position = sc.nextInt();

linkedList.insertAnywhere(new Info(name2, number2), position);

break;

case 3:

linkedList.print();

break;

case 4:

System.out.println("Total elements: " + linkedList.count());

break;

case 5:

System.out.print("Enter name to search: ");

String searchName = sc.nextLine();

linkedList.search(searchName);

break;

case 6:

System.out.print("Enter name to delete: ");

String deleteName = sc.nextLine();

linkedList.delete(deleteName);

break;

case 7:

linkedList.sort();

System.out.println("List sorted.");

break;

case 8:

System.out.print("Enter name to edit: ");

String editName = sc.nextLine();

System.out.print("Enter new name: ");

String newName = sc.nextLine();

System.out.print("Enter new number: ");

int newNumber = sc.nextInt();

linkedList.edit(editName, newName, newNumber);

break;

case 9:

System.out.println("Exit");

x = 9;

break;

default:

System.out.println("No");

}

}

}

}
