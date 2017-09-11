public class Main {


  private static String reverse(String str) {


    return null;
  }

  public static void main(String[] args) {
    String str = "abcdef";

    for(int off = 0; off < str.length(); ) {
      int codePoint = str.codePointAt(off);
      System.out.println("" + codePoint);
      off += Character.charCount(codePoint);
    }

  }

}
