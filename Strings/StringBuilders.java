package Strings;

public class StringBuilders {
   public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("");
    for(char ch='a'; ch<='z'; ch++){
       sb.append(ch); 
    }
    System.out.println(sb.length());
   } 
}

// O(26) TC

//O(26*n^2) if we used += in case of append
