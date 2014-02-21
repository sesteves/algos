import java.util.ArrayList;
import java.util.List;

public class Main {

  // second clean trial
  private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int i = 0, j = 0;
    while( i < a.size() || j < a.size()) {  
      while(i < a.size() && result.contains(a.get(i)))
        i++;
      while(j < b.size() && result.contains(b.get(j)))
        j++;  
      
      if(i < a.size()) {
        if(j < b.size()) {
          if(a.get(i) < b.get(i)) {
            result.add(a.get(i++));
          } else {
            result.add(b.get(j++));
          }
        } else {
          result.add(a.get(i++));
        }      
      } else if(j < b.size())
        result.add(b.get(j++));
  }
  return result;
}


private static ArrayList<Integer> merge2(ArrayList<Integer> a, ArrayList<Integer> b) {

  ArrayList<Integer> result = new ArrayList<Integer>();
  int i = 0, j = 0;

  while( i < a.size() || j < b.size()) {

    if(i < a.size() && !result.contains(a.get(i)) && a.get(i) < b.get(j)) {
      result.add(a.get(i++));
    } else if(!result.contains(b.get(j)) && j < b.size()) {
      result.add(b.get(j++));
    }

    while(i < a.size() && result.contains(a.get(i))) {
      i++;
    }
    while(j < b.size() && result.contains(b.get(j))) {
      j++;
    }
  }
  return result;
}


  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    ArrayList<Integer> b = new ArrayList<Integer>();
    a.add(1);
    a.add(2);
    a.add(4);
    b.add(3);
    b.add(3);
    b.add(3);
    ArrayList<Integer> res = merge(a,b);

    for(Integer i : res)
      System.out.println(i);
  }
}
