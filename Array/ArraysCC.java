package Array;
public class ArraysCC {
    
    /*  public static void update(int marks[], int nonchangeble  ) {  //  // Calling by reference
        nonchangeble = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

        public static void main(String[] args) {
        //int marks[] = new int[5];

        int marks[] = {97, 98, 99};
        int nonchangeble = 5;
        update(marks, nonchangeble); 
        System.out.println(nonchangeble);

        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i] + " ");
        }

    } */
    public static void main(String[] args) {
       
    }

   
    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
    }
}
 
