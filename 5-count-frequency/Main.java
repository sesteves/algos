import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {

  private static void countFreq(List<Integer> list) {

    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    for(Integer i : list) {
      Integer counter;

      if(map.containsKey(i))
        map.put(i,map.get(i) + 1);
      else
        map.put(i, 1);
    }

    for(Integer key : map.keySet()) {
      System.out.println("key: " + key + ", value: " + map.get(key));

    }
 }


  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(3);
    list.add(3);
    list.add(4);
    countFreq(list);
  }

}
