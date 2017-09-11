// a..z * ? 

public class SimpleMatch {


  private static boolean match(String pattern, String text) {

    int i = 0;
    for(int j = 0; j < text.length(); j++) {

      if(pattern.charAt(i) == text.charAt(j)) {
        if(++i == pattern.length())
          return true; 
      } else {
        i = 0;
      }
      
    }

    return false;
  }

  public static void main(String[] args) {
      
    System.out.println("abc abc " + match("abc", "abc"));
    System.out.println("c abc " + match("c", "abc"));
    System.out.println("ab abc " + match("ab", "abc"));
    System.out.println("abcd abc " + match("abcd", "abc"));
//    System.out.println("a?c abc " + match("a?c", "abc"));
//    System.out.println("a?c ac " + match("a?c", "ac"));
 
//    System.out.println("a*bc abcd " + match("a*bc", "abcd"));

  }
}
