package User_defined_Methods.User;

public class EX5_remove_substring {
    static String removeSubstring(String str, String sub) {
        return str.replaceAll(sub, "");
    }

    public static void main(String[] args) {
        String sub = "kon";
        String str = "kon khmer tver ban ! ";
      String objString =  removeSubstring(str, sub);
      System.out.println("Orignal String: "+str);
      System.out.println("Modified String after removing substring: "+objString);
    }
}
