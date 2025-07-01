package linkedlist;

public class Circularll {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    // Add at beginning
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // circular link
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head; // maintain circular link
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // circular link
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head; // maintain circular link
    }

    // Remove first
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        size--;
        if (head == tail) {
            head = tail = null;
            return val;
        }
        head = head.next;
        tail.next = head;
        return val;
    }

    // Remove last
    public int removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        size--;
        if (head == tail) {
            head = tail = null;
            return val; 
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = head; // maintain circular link
        return val;
    }

    // Print list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        while (temp != head) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("(back to head)");
        }
    

    // Get current size
    public int getSize() {
        return size;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Circularll cll = new Circularll();

        cll.addFirst(10);
        cll.addLast(20);
        cll.addLast(30);
        cll.addFirst(5);

        cll.printList(); // 5 -> 10 -> 20 -> 30 -> (back to head)

        cll.removeFirst();
        cll.printList(); // 10 -> 20 -> 30 -> (back to head)

        cll.removeLast();
        cll.printList(); // 10 -> 20 -> (back to head)

        System.out.println("Size: " + cll.getSize()); // Size: 2
    }
}
