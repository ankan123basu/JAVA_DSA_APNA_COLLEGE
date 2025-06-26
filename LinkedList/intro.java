package LinkedList;

public class intro {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        size++;

         //step 1 = create new node
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        // step 2 = new  node next = head
        newNode.next = head; // link

        // step 3 = head = newNode
        head = newNode;
    }




    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
         if(head == null){
            head = tail = newNode;
            return;
         }
        tail.next = newNode;
         tail = newNode;

    }



    public void print() {
        if(head == null){
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }



    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while(i <idx -1){
            temp = temp.next;
            i++;
        }
        // i = idx-1   temp == prev
        newNode.next = temp.next;
        temp.next = newNode;

    }


    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
               int val = head.data;
               head = tail = null;
               size =0;
               return val;
        }
        int val = head.data;
        head =head.next;
        size--;
        return val;
    }


    public int removelast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        // prev: i = size -2
        Node prev = head;
        for(int i =0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }




      public int iterativeSearch(int key){
            Node temp = head;
            int i =0;
            while(temp != null){
                if(temp.data == key){
                    return i;
                }
                temp = temp.next;
                i++;
            }
            //key not found
            return -1;
      }

      public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx +1;
      }
      public int recSearch(int key){
        return helper(head, key);

      }


      public void reverse(){  // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
      }

      public void deleteNthfromend(int n){
        int sz = 0;
        Node temp = head;
        while(temp!= null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){    // if n is equal to size, remove first
            head = head.next; // remove first
            return;
        }
        int i = 1;
        Node prev = head;
        while(i < sz - n){ // sz - n - 1 is the index of the node before the one we want to delete
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; // skip the node to be deleted
      }

    // Slow fast approach
       public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
        }
        return slow; // slow will be at the mid node
       }
       
       public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true; // empty or single node is a palindrome
        }
        // Step 1 - Find mid
        Node midNode = findMid(head);

        // Step 2 - Reverse the second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // This is the head of the reversed second half
        Node left = head;

       // Step 3 = check left half and right half
       while(right != null){
            if(left.data != right.data){
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // It is a palindrome

       }
         


    public static void main(String[] args) {
        intro ll = new intro();
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.add(2, 9);
        ll.print();
     //   ll.removeFirst();
    //    ll.print();
    //    ll.removelast();
   //     ll.print();
    //    System.out.println(ll.iterativeSearch(3));
  //      System.out.println(ll.recSearch(4));
 //       ll.reverse();
 //       ll.print();
     //   System.out.println(ll.size);
        ll.deleteNthfromend(3);
        ll.print();
        System.out.println(ll.isPalindrome());
        
    }
}
