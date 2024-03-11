/*Group 4*/
package Mymain;
 public class Ex6duplicate {
    public static void main(String[] args) {
        // define the input String 
     String inputString = "programing";
// ---------- call the removeDuplicates method and store the result
        String result = removeDuplicates(inputString);
        // display the original String and the result
        System.out.println("Original String: " + inputString);
        System.out.println("Result: " + result);
    }
    public static String removeDuplicates(String input) {
         StringBuilder result = new StringBuilder();
         for (char c : input.toCharArray()) {
             char lowercaseChar = Character.toLowerCase(c);
             int index = result.toString().toLowerCase().indexOf(lowercaseChar);
             if (index == -1) {
                 result.append(c);
             } else {
                 result.deleteCharAt(index);
             }
         }
         return result.toString();
     }

 }
    
    /* key point : the contains method is used to check if a character is already in the result String.
            The !(negation operator) : is used to invert the result of the contains method.
            The String.valueOf() method is used to convert a character to a String.
            The toString() method provides a flexible way to combine objects with consistent formatting.
             
    */ 
  
