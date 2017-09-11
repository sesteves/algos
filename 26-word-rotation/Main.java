// Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).


public class Main {

  private static boolean isRotation(String word, String rotation) {
    String ref = word + word;
    return word.length() == rotation.length() && ref.contains(rotation);
  }

  public static void main(String[] args) {
    String word = "waterbottle", rotation = "erbottlewat", rotation2 = "erbottleeat";
    System.out.println(word + ", " + rotation + " : " + isRotation(word, rotation));
    System.out.println(word + ", " + rotation2 + " : " + isRotation(word, rotation2));
  }

}
