package ArrayList;

import java.util.ArrayList;

public class programs {

    //1)  SWAP 2 N0

    public static void swap(ArrayList<Integer> height, int idx1, int idx2){
        height.set(idx1, height.get(idx2)); // indx2 value gets copied to indx1
        height.set(idx2, height.get(idx1));
    }

    //public static void main(String[] args) {
       // ArrayList<Integer> height = new ArrayList<>();
      //  height.add(2);
      //  height.add(9);
      //  height.add(6);
     //   height.add(8);

        // int idx1 = 1, idx2 = 3;
      //  System.out.println(height);
      //  swap(height, idx1, idx2);
      //  System.out.println(height);
    

   // }





     //2) CONTAINER WITH MOST WATER   O(N^2) TC


       public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        
        //brute force approach

           for(int i=0; i<height.size(); i++){
             for(int j=i+1; j<height.size(); j++){
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
             }
           }
           return maxWater;
       }




        // TWO POINTER APPROACH      O(N)  TC


        public static int storetheWater(ArrayList<Integer> height){
            int maxwater = 0;
            int lp = 0;
            int rp = height.size()-1;

            while(lp<rp){
                int ht = Math.min(height.get(lp), height.get(rp));
                int width = rp - lp;
                int currwater = ht * width;
                maxwater = Math.max(maxwater, currwater);

                    if(height.get(lp) < height.get(rp)) {
                        lp++;
                    }else{
                        rp--;
                    }
            }
            return maxwater;



        }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1 8 6 2 5 4 8 3 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storetheWater(height));
    }

    }

