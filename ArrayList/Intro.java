package ArrayList;
import java.util.*;



public class Intro {
    public static void main(String args[]) {
        // Java Collection Framework
        // ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
         

        // Operations 

       // 1) Adding an element     O(1)  TC
        
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);

       list.add(1, 9); //   O(N) TC for this 

       System.out.println(list);


       // 2) get an element    O(1)  TC

       int element = list.get(2);
       System.out.println(element);


       // 3) Remove ana element   O(n) TC
       list.remove(2);   // resizing also done here
       System.out.println(list);


       // 4) set element at index   O(n) TC
       list.set(2, 10);
       System.out.println(list);


       // 5) Contains element   O(N)  TC
       System.out.println(list.contains(1));
       System.out.println(list.contains(11));



       // SIZE OF AN ARRAY LIST
        
       ArrayList<Integer> list5 = new ArrayList<>();
       list5.add(2);
       list5.add(9);
       list5.add(6);
       list5.add(8);
       System.out.println(list5.size());

       
       // Print the ArrayList

       for(int i=0; i<list5.size(); i++){
          System.out.print(list5.get(i) + " ");
       }
       System.out.println();




       // REVERSE PRINT   O(N)  TC

       for(int i = list5.size()-1; i>=0; i--){
         System.out.print(list5.get(i) + " ");
       }
       System.out.println();


       
       // FIND MAX IN ARRAYLIST

       int max = Integer.MIN_VALUE;
       for(int i =0; i<list5.size(); i++){
       // if(max <list5.get(i)){
          //  max = list5.get(i);
        //}
        //  OR
        max = Math.max(max, list5.get(i));
       }
       System.out.println(("max element = " + max));



       // SORTING AN ARRAYLIST   

       System.out.println(list5);
        Collections.sort(list5); // ascending order
        System.out.println(list5);
        

        // Descending order

        Collections.sort(list5, Collections.reverseOrder());
         System.out.println(list5);
    }

    
}
