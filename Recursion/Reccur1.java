package Recursion;

public class Reccur1 {

    // print DEC order
    public static void printDec(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        
        System.out.print(n+" ");
        printDec(n-1);
    }




    // print INC order
    
    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }



    // Factorial        O(N) TC

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int fNm1 = fact(n-1);
         return (n * fNm1);
    }



    // N natural number sum

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int snm1 = sum(n-1);
        return (n + snm1);
    }




    // Calculate nth term of fibonacci

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
            int fnm1 = fib(n-1);
            int fnm2 = fib(n-2);
            int fn = fnm1 + fnm2;
            return fn;
        }
    


    
        // Check array is sorted is not

     public static boolean issorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
             return false;
          }
          return issorted(arr, i+1);
     }



       // First Occurance

       public static int firstoccurance(int arr[], int i, int key){
         if(i == arr.length-1){
            return -1;
         }
        if(arr[i] == key){
            return i;
         }
         return firstoccurance(arr, i+1, key);
       }




       // Last occurance

       public static int lastoccurance(int arr[], int i, int key){
         if(i == arr.length){
            return -1;
         }
        int isfound = lastoccurance(arr, i+1, key);
         if(isfound == -1 && arr[i] == key){
            return i;
         }
            return isfound;
        }


        
        // print x^n

        public static int power(int x, int n){
            if(n == 0){
                return 1;
            }
            int xnm1 = power(x, n-1);
            int xn = x * xnm1;
            return xn;
        }




        // print x^n in optimised approach  O(LOG N)

        public static int optimisedpower(int a, int n) {
            if(n == 0){
                return 1;
            }
            int halfpower = optimisedpower(a, n/2);
             int halfPowersq = halfpower * halfpower;
             if(n % 2 != 0){
                halfPowersq = a * halfPowersq;
             }
             return halfPowersq;
        }


    public static void main(String[] args) {
       // int arr[] = {5, 5, 5, 5};
         System.out.println(optimisedpower(2, 10));
    }
}
