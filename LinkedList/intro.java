package linkedlist;

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

      //                 or  
      /* 

        public void deleteNthfromend2(int n){
            Node fast = head;
            Node slow = head;
    
            // Move fast pointer n steps ahead
            for(int i = 0; i < n; i++){
                fast = fast.next;
            }
    
            // If fast is null, it means we need to remove the head
            if(fast == null){
                head = head.next;
                return;
            }
    
            // Move both pointers until fast reaches the end
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            // Now slow is at the node before the one we want to delete
            slow.next = slow.next.next; // skip the node to be deleted
        }  */


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

     public  static boolean isCycle(){
         Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next; // move slow by 1
                fast = fast.next.next; // move fast by 2
                if(slow == fast){
                    return true; // Cycle detected
                }
     }
            return false; // No cycle detected
     }
         
     public static void removeCycle(){
        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
            if(slow == fast){
                cycle = true; // Cycle detected
                break;
            }
        }
        if(cycle == false){
            return; // No cycle to remove
        }
         
        // find meeting point
        slow = head; // reset slow to head
        Node prev = null; // to keep track of the previous node
        while(slow != fast){
            slow = slow.next; // move slow by 1
            prev = fast; // keep track of the previous node
            fast = fast.next; // move fast by 1
        }

        // remove cycle
        prev.next = null; // set the next of the previous node to null to break the cycle
     }




        
     private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
        }
        return slow; // slow will be the last node of the first half
     }
       

     private Node merge(Node h1, Node h2){
        Node mergedLL = new Node(-1); // dummy node
        Node temp = mergedLL; // pointer to build the new list
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                temp.next = h1; // link the smaller node
                h1 = h1.next; // move to the next node in h1
            } else {
                temp.next = h2; // link the smaller node
                h2 = h2.next; // move to the next node in h2
            }
            temp = temp.next; // move temp to the last node in merged list
        }

        while(h1 != null){ // if h1 has remaining nodes
            temp.next = h1; // link the remaining nodes
            h1 = h1.next; // move to the next node in h1
            temp = temp.next; // move temp to the last node in merged list
        }
        while(h2 != null){ // if h2 has remaining nodes
            temp.next = h2; // link the remaining nodes
            h2 = h2.next; // move to the next node in h2
            temp = temp.next; // move temp to the last node in merged list
        }
        return mergedLL.next; // return the next of dummy node, which is the head of the merged list
     }



     public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head; // base case, if list is empty or has one node
        }
        // find mid
        Node mid = getMid(head);

        // left and right ms
         Node rightHead = mid.next;
        mid.next = null; // break the list into two halves

        Node newLeft = mergeSort(head); // left half
        Node newRight = mergeSort(rightHead); // right half

        return merge(newLeft, newRight);
     }


     public void zigzag(){
        // find mid
         Node slow = head;
         Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next; // move slow by 1
                fast = fast.next.next; // move fast by 2
            }
            Node mid = slow;

        // reverse 2nd half
      Node prev = null;
      Node curr = mid.next;
      mid.next = null; // break the list into two halves
      Node next;
      while(curr != null){
            next = curr.next; // store next node
            curr.next = prev; // reverse the link
            prev = curr; // move prev to current
            curr = next; // move curr to next
        }

        Node left = head;
        Node right = prev; // this is the head of the reversed second half
        Node nextLeft, nextRight;

        // Alternate merging
        while(left != null && right != null){
            nextLeft = left.next;
            left.next=right;
            nextRight = right.next;
            right.next = nextLeft;
            left = nextLeft; // move left to next left
            right = nextRight; // move right to next right
        }
     }


    public static void main(String[] args) {
      /*   intro ll = new intro();
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
     head = new Node(1);
    Node temp = new Node(2);
    head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1->2->3->2
        
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());


        intro ll = new intro();
       ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        // 4->3->2->1->null

        ll.print();
        
        // Sort the linked list
        ll.head = ll.mergeSort(ll.head);
        ll.print(); 
        */

        intro ll = new intro();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
       // 1->2->3->4->5
        ll.print();
        
        ll.zigzag();
        ll.print();
    }
    }
