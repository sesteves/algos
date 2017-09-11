// a..z * ? 

public class Main {


  private static boolean match(String pattern, String text) {

   
    for(int i = 0; i < text.length(); i++) {

    
      if(pattern.charAt(0) == '*') {
        if(pattern.length() == 1 || match(pattern.substring(1), text.substring(i)))
          return true;
      }

      else if(pattern.length() > 1 && pattern.charAt(1) == '?') {
        if(pattern.length() == 2)
          return true;

        if(pattern.charAt(0) == text.charAt(i) && matchSequential(pattern.substring(2), text.substring(i + 1)))
            return true;        

        if(matchSequential(pattern.substring(2), text.substring(i)))
          return true;

      }

      else if(pattern.charAt(0) == text.charAt(i)) {      

        if(pattern.length() == 1 ||  matchSequential(pattern.substring(1), text.substring(i + 1)))
          return true;
      }

      
    }

    return false;
  }


  private static boolean matchSequential(String pattern, String text) {

//      System.out.println("Pattern: " + pattern + ", text: " + text);

     if(pattern.charAt(0) == '*') {
       if(pattern.length() == 1 || match(pattern.substring(1), text))
         return true;
     }

     else if(pattern.length() > 1 && pattern.charAt(1) == '?') {
        if(pattern.length() == 2)
          return true;

        if(pattern.charAt(0) == text.charAt(0) && matchSequential(pattern.substring(2), text.substring(1)))
            return true;       

        if(matchSequential(pattern.substring(2), text.substring(0)))
          return true;

      }

      else if(pattern.charAt(0) == text.charAt(0)) {
       if(pattern.length() == 1 || matchSequential(pattern.substring(1), text.substring(1)))
          return true;
      }

    return false;
  }




  public static void main(String[] args) {
      
    System.out.println("abc abc " + match("abc", "abc"));
    System.out.println("c abc " + match("c", "abc"));
    System.out.println("ab abc " + match("ab", "abc"));
//    System.out.println("abcd abc " + match("abcd", "abc"));
    System.out.println("a?c abc " + match("a?c", "abc"));
    System.out.println("a?c ac " + match("a?c", "ac"));
    System.out.println("a?ac aaac " + match("a?ac", "aaac"));

    System.out.println("a*bc abcd " + match("a*bc", "abcd"));
    System.out.println("a*e abcd " + match("a*e", "abcd"));
    System.out.println("aaa*aaabc* aaaaaaaabc " + match("aaa*aaabc*", "aaaaaaaabc"));
    System.out.println("bb?*d* bbbe " + match("bb?*d*", "bbbe"));


  }
}
