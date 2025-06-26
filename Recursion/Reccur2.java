package Recursion;

public class Reccur2{

 
  //1) Tilling Problem

 public static int tilingProblem(int n){ // 2 x n (floor size)
        //base case
        if(n == 0 || n==1) {
            return 1;
        }
    //work
        //vertical choice
        int fnm1 = tilingProblem(n-1);

        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totways = fnm1 + fnm2;
        return totways;
 }




   //2) Remove Duplicates in a string

     public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
            if(idx == str.length()){
                System.out.println(newStr);
                return;
            }

            // work
            char currChar = str.charAt(idx);
            if(map[currChar-'a'] == true){
                // duplicate
                removeDuplicates(str, idx+1, newStr, map);
            } else{
                map[currChar-'a'] = true;
                 removeDuplicates(str, idx+1, newStr.append(currChar), map);
            }
     }



       // 3) Friends pairing


     public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        // choice
        // single
        //int fnm1 = friendsPairing(n-1);

        // pair
      //  int fnm2 = friendsPairing(n-2);
       // int pairWays = (n-1) * fnm2;

        // tot ways
       // int totways = fnm1 + pairWays;
       // return totways;

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
     }







     // 4) Binary Strings problem
     
      public static void printBinstrings(int n, int lastplace, String str){
          //base case

          if(n == 0){
            System.out.println(str);
            return;
          }
        // work
      //  if(lastplace == 0){
            //sit 0 on chair n
       //     printBinstrings(n-1, 0, str.append("0"));
       //      printBinstrings(n-1, 1, str.append("1"));
       // }  else {
       //   printBinstrings(n-1, 0, str.append("0"));
       // }
            
       printBinstrings(n-1, 0, str+"0");
       if(lastplace == 0){
        printBinstrings(n-1, 1, str+"1");
          
       }
      }
     public static void main(String[] args) {
          //  String str = "appnnacollege";
        // System.out.println(tilingProblem(3));
      //  removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
     // System.out.println(friendsPairing(3));

     printBinstrings(3, 0, "");
     }
}
