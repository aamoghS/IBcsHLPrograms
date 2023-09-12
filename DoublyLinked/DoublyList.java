public class DoublyList {
    private Node head;
    private Node tail;

    // Constructor
    public DoublyList() 
    {
        head = null;
        tail = null;
    }

    // Node class with data, next, and previous references (as shown previously)

    // Method to insert at the end
    public void insertAtEnd(Info info) {
        Node newNode = new Node(info);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void insertAnywhere(Info info, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
    
        Node newNode = new Node(info);
    
        if (position == 1) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
            return;
        }
    
        int count = 1;
        Node current = head;
    
        while (count < position - 1 && current != null) {
            current = current.getNext();
            count++;
        }
    
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
    
        newNode.setPrev(current);
        newNode.setNext(current.getNext());
    
        if (current.getNext() != null) {
            current.getNext().setPrev(newNode);
        }
    
        current.setNext(newNode);
    
        if (newNode.getNext() == null) {
            tail = newNode;
        }
    }
    

    // Method to print the elements of the list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Method to count the number of elements in the list
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    //
    public void search(String name) {
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equals(name)) {
                System.out.println("Name: " + name + ", Number: " + current.getData().getNumber());
                return;
            }
            current = current.getNext();
        }
        System.out.println("Name not found.");
    }

    public void delete(String name) {
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }
    
        Node current = head;
    
        while (current != null) {
            if (current.getData().getName().equals(name)) {
                if (current == head) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.getPrev();
                    tail.setNext(null);
                } else {
                    Node prevNode = current.getPrev();
                    Node nextNode = current.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                }
                
                System.out.println("Deleted: " + name);
                return;
            }
            current = current.getNext();
        }
    
        System.out.println("Name not found.");
    }
    

    public void sort() {
        if (head == null || head.getNext() == null) {
            // List is empty or has only one node, no need to sort
            return;
        }
    
        boolean swapped;
        Node end = null;
    
        do {
            swapped = false;
            Node current = head;
    
            while (current.getNext() != end) {
                if (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0) {
                    // Swap the nodes' data
                    String tempName = current.getData().getName();
                    int tempNumber = current.getData().getNumber();
    
                    current.getData().setName(current.getNext().getData().getName());
                    current.getData().setNumber(current.getNext().getData().getNumber());
    
                    current.getNext().getData().setName(tempName);
                    current.getNext().getData().setNumber(tempNumber);
    
                    swapped = true;
                }
                current = current.getNext();
            }
            end = current; // Mark the last sorted node
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
