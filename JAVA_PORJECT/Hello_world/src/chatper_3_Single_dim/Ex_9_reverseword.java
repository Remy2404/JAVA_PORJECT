package chatper_3_Single_dim;
 /*
Reverse individual words in a string, where each word may 
be delimited by a dot, comma, space or 
tab, like www.google.com should become www.elgoog.moc
         */

         import java.util.Scanner;

         public class Ex_9_reverseword {
             public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                 System.out.print("Enter a string: ");
                 String input = scanner.nextLine();
         
                 String reversedString = reverseWords(input);
         
                 System.out.println("Reversed string: " + reversedString);
                 scanner.close();
             }
         // method reverseWords
             private static String reverseWords(String input) {
                //Splits the input string into an array of individual words.
                //"[,\\.\\s\\t]+": This is a regular expression that defines the delimiters to split on. It matches one or more occurrences of commas (,), dots (.), whitespace (\s), or tabs (\t).
                 String[] sub_words = input.split("[,\\.\\s\\t]+"); 
                 StringBuilder result = new StringBuilder();
                 for (String word : sub_words) {
                     StringBuilder reversedWord = new StringBuilder(word);
                     reversedWord.reverse();
                     result.append(reversedWord).append(".");
                 }
         
                 return result.substring(0, result.length() - 1); // Remove the extra dot at the end
             }
         }
