package BitManipulation;

public class BITOPERATIONS {
    
    // 1) GET ith BIT 

   public static int getIthBit(int n, int i){
    int bitMask = 1<<i;
    if((n & bitMask) == 0){
        return 0;
    } else {
        return 1;
    }
   }


    
     // 2) Set iTH BIT

     public static int setithbit(int n, int i){
        int bitmask = 1<<i;
        return n|bitmask;
     }



     // 3) Clear iTH bit
     
      public static int clearithbit(int n, int i){
        int bitmask = ~(1<<i);
        return (n & bitmask);
      }


    
      // 4) Update iTH bit

      public static int updateithbit(int n, int i, int newbit){
       // if(newbit == 0){
        //  return clearithbit(n, i);
       // } else{
       //   return setithbit(n, i);
       // }
              
       //          OR

          n = clearithbit(n, i);
         int bitmask = newbit<<i;
         return n | bitmask;
      }





      // 5) Clear last i bits

      public static int clearlastibits(int n, int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
      }




      // 6) Clear range of bits


      public static int clearrangeofbits(int n, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
      }

   public static void main(String[] args) {
    System.out.println(clearrangeofbits(10, 2, 4));
   }
}
