
import java.util.*;

public class Main {



  private static List<Interval> merge_intervals(List<Interval> intervals) {

    List<Interval> result = new ArrayList<Interval>();

    for(int i = 0; i < intervals.size(); i++) {
    
      Interval int1 = intervals.get(i);
      boolean overlap = false;
      List<Integer> mylist = new ArrayList<Integer>();
      if(i != intervals.size() - 1)  
        for(int j = i + 1; j < intervals.size(); j++) {
          Interval int2 = intervals.get(j);
          if( int1.first >= int2.first && int1.first <= int2.last || int1.last >= int2.first && int1.last <= int2.last) {       
            mylist.add(int1.first);
            mylist.add(int2.first);
            mylist.add(int1.last);
            mylist.add(int2.last);
            overlap = true;
          } 
        }
      if(overlap) {
        Collections.sort(mylist);
        result.add(new Interval(mylist.get(0),mylist.get(mylist.size() - 1)));
      } else
        result.add(int1);
    }
    return result;

  }
  public static void main(String[] args) {

    List<Interval> input = new ArrayList<Interval>();
  // [(1,5),(8,9), (10,100), (20, 30), (50,60)
    input.add(new Interval(1,5));
    input.add(new Interval(8,9));
    input.add(new Interval(10,100));
    input.add(new Interval(20,30));
    input.add(new Interval(50,60));
    List<Interval> output  = merge_intervals(input);

    for(Interval interval : output)
      System.out.print(interval);
    System.out.println();
    
// [(1,5),(8,9), (10,100), (20, 30), (50,60)]

  }


  private static class Interval {

    public int first, last;

    public Interval(int first, int last) {
      this.first = first;
      this.last = last;
    }

    public String toString() {
      return "(" + first + "-" + last + ")";
    }
  }
}
