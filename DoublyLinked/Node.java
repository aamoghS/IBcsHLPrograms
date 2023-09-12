public class Node {
    private Info data;
    private Node next;
    private Node prev;

    public Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Node(Info data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Info getData() {
        return data;
    }

    public void setData(Info data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
