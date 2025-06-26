package Strings;

public class Strings {
    public static void printletters(String str){
        for(int i=0; i<str.length(); i++){
            System.out.println(str.charAt(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
       // char arr[] = {'a', 'b', 'c'};
       // String str = "abcd";
       // String str2 = new String("xyz");

        // STRINGS ARE IMMUTABLE

       // Scanner sc = new Scanner(System.in);
       // String name;
        //name = sc.next();
      //  name = sc.nextLine();
       // System.out.println(name);

      // String fullName = "Tony Stark";
       // System.out.println(fullName.length());

       //CONCATENATION
       
       String firstName = "Ankan";
       String lastName = "Basu";
       String fullName = firstName + " " + lastName;
        System.out.println(fullName.charAt(1));
      // printletters(fullName);

       // STRING COMPARISON

         String s1 = "Tony";
         String s2 = "Tony";
         String s3 = new String("Tony");

         
         // INTERNING CONCEPT

         if(s1 == s2){
            System.out.println("Strings are equal");
         }
         else{
            System.out.println("Strings are not equal");
         }
         if(s1 == s3){
            System.out.println("Strings are equal");
         }
         else{
            System.out.println("Strings are not equal");
         }
         if(s1.equals(s3)){
            System.out.println("Strings are equal");
         }
         else{
            System.out.println("Strings are not equal");
         }
    }
}
