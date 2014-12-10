/*
Given a set of (a,b) value pairs
 (1,5),(5,20), (2,10),(1,45)
return the union and merge the ones that overlap 
*/
import java.util.*;


public class Main {

  private static List<Integer[]> merge(List<Integer[]> list) {

    List<Integer[]> result = new ArrayList<Integer[]>();

    // order pairs by first element
    Collections.sort(list, new Comparator<Integer[]>() {  

      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[0].compareTo(o2[0]);
      }

    });

    //   
    Integer[] basePair = list.get(0);
    for(int i = 1; i < list.size(); i++) {
      
      // check if base intercepts
      if(basePair[1] >= list.get(i)[0]) {
        if(basePair[1] < list.get(i)[1])
          basePair[1] = list.get(i)[1];
      } else {
        result.add(basePair);
        basePair = list.get(i);
      }
    }
    result.add(basePair);
    return result;
  }


  public static void main(String[] args) {

    List<Integer[]> list = new ArrayList<Integer[]>();
    list.add(new Integer[] {1, 5});
    list.add(new Integer[] {5, 20});
    list.add(new Integer[] {2, 10});
    list.add(new Integer[] {1, 45});
    List<Integer[]> result = merge(list);

    for(Integer[] pair  : result) {
      System.out.print("(" + pair[0] + "," + pair[1] + ")");
    }
    System.out.println();
  }

}
