public class LinkedList {

private Node head;

public void insertAtEnd(Info info) {

Node newNode = new Node();

newNode.setData(info);

if (head == null) {

head = newNode;

} else {

Node temp = head;

while (temp.getNext() != null) {

temp = temp.getNext();

}

temp.setNext(newNode);

}

}

public void print() {

Node temp = head;

while (temp != null) {

System.out.println(temp.getData());

temp = temp.getNext();

}

}

public void insertAnywhere(Info info, int position) {

if (position <= 0) {

System.out.println("Invalid position.");

return;

}

Node newNode = new Node();

newNode.setData(info);

if (position == 1) {

newNode.setNext(head);

head = newNode;

return;

}

Node current = head;

for (int i = 1; i < position - 1 && current != null; i++) {

current = current.getNext();

}

if (current == null) {

System.out.println("out of bounds.");

} else {

newNode.setNext(current.getNext());

current.setNext(newNode);

}

}

public int count() {

int count = 0;

Node current = head;

while (current != null) {

count++;

current = current.getNext();

}

return count;

}

public void search(String name) {

Node current = head;

while (current != null) {

if (current.getData().getName().equals(name)) {

System.out.println("Name: " + name + ", Number: " + current.getData().getNumber());

return;

}

current = current.getNext();

}

System.out.println("not there buddy");

}

public void delete(String name) {

if (head == null) {

System.out.println("empty.");

return;

}

if (head.getData().getName().equals(name)) {

head = head.getNext();

System.out.println("Delete: " + name);

return;

}

Node current = head;

while (current.getNext() != null && !current.getNext().getData().getName().equals(name)) {

current = current.getNext();

}

if (current.getNext() == null) {

System.out.println("empty.");

} else {

current.setNext(current.getNext().getNext());

System.out.println("Delete: " + name);

}

}

public void sort() {

if (head == null || head.getNext() == null) {

return;

}

boolean swapped;

do {

swapped = false;

Node current = head;

Node previous = null;

while (current.getNext() != null) {

if (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0) {


Node temp = current.getNext();

current.setNext(temp.getNext());

temp.setNext(current);

if (previous == null) {

head = temp;

} else {

previous.setNext(temp);

}

previous = temp;

swapped = true;

} else {

previous = current;

current = current.getNext();

}

}

} while (swapped);

}

public void edit(String name, String newName, int newNumber) {

Node current = head;

while (current != null) {

if (current.getData().getName().equals(name)) {

current.getData().setName(newName);

current.getData().setNumber(newNumber);

System.out.println("Edited: " + name);

return;

}

current = current.getNext();

}

System.out.println("Name not found.");

}

}
