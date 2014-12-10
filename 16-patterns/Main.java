import java.util.*;

public class Main {


  private static boolean hasRepeatedSequence(String str) {

    Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
    Set<Character> set = new HashSet<Character>(); 

    for(char c : str.toCharArray()) {

      if(map.containsKey(c)) {             
        for(Map.Entry<Character, List<Character>> entry : map.entrySet()) {
          if(set.contains(entry.getKey()) && entry.getValue().contains(c))
              return true;            
        }        
        set.add(c);        
      } else {

        for(Map.Entry<Character, List<Character>> entry : map.entrySet())
            entry.getValue().add(c);       
        map.put(c, new ArrayList<Character>());
      }

    }
/*
    for(Map.Entry<Character, List<Character>> entry : map.entrySet()) {
      System.out.print(entry.getKey() + " : ");
      for(char c : entry.getValue())
        System.out.print(c + " ");
      System.out.println();
    }
*/  
    return false;
  }
  


  public static void main(String[] args) {

    String[] strs = {"abab", "abba", "acbdaghfb", "abcdacb"};
    for(String str : strs)
      System.out.println(str + " : " + hasRepeatedSequence(str));

  }

}
