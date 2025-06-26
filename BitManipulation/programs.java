package BitManipulation;

public class programs {
    
 // 1) Check whether the number is a power of two

 public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}




  
  // 2) Count set bits in a number

  public static int countsetbits(int n){   // O(logn)
    int count = 0;
    while(n>0){
        if((n & 1) != 0){  //check our LSB
            count++;
        }
          n= n>>1;
    }
    return count;
  }



   
  
   // 3) FAST EXPONENTIATION


    public static int  fastexpo(int a, int n){
        int ans = 1;
        
        while(n>0){
         if((n & 1) !=0){ //check LSB
           ans = ans * a;
         }
         a = a * a;
         n = n>>1;
        }
        return ans;
    }



    //  MODULAR EXPONENTIATION




  public static void main(String[] args) {
    System.out.println(fastexpo(3, 5));
  }
}
