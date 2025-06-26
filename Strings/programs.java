package Strings;

public class programs {

    // 1) FIRST LETTER TO UPPER CASE

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
        // O(N)  TC






      // 2) STRING COMPRESSION 

       public static String compress(String str){
        String newStr = "";
        //aaabc
         for(int i=0; i<str.length(); i++){
            Integer count = 1;

            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
              count++;
              i++;  
             }

            // abc
            newStr += str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
         }
            return newStr;
       }

       // O(N)  TC



        
    
    public static void main(String[] args) {
        String str= "aaabbcccdd";
        System.out.println(compress(str));
    }
}
