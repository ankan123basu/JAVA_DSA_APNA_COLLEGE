package linkedlist;

public class Doublell {
       
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtIndex(int data, int idx) {
    if (idx < 0 || idx > size) {
        throw new IndexOutOfBoundsException("Invalid index");
    }

    if (idx == 0) {
        addFirst(data);
        return;
    }

    if (idx == size) {
        addLast(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;
    int i = 0;

    while (i < idx - 1) {
        temp = temp.next;
        i++;
    }
    newNode.next = temp.next;
    temp.next.prev = newNode;

    temp.next = newNode;
    newNode.prev = temp;

    size++;
}

     
    // remove
    public int removeFirst() {
        if(head == null){ // check if list is empty
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }

         if(size == 1){ // check if there is only one element
            int val = head.data;
            head = null;
            tail = null;
            size--;
            return val;
         }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }


    public void removeLast() {
        if(head == null){ // check if list is empty
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head == tail){  // check if there is only one element
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void removeAtIndex(int idx) {
        if(idx == 0){
            removeFirst();
            return;
        }
        if(idx == size-1){
            removeLast();
            return;
        }
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            i++;
            temp = temp.next;
        }
        size--;
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }


    // print
    public void print() {
        Node temp = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    static public void main(String[] args) {
        Doublell dll = new Doublell();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.print();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.print();
    }
}
