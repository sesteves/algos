// Given a set of values 0-9, return all permutations of that set of length n. Example: n=2, set ={2,3,4} Return: {2,2}, {3,3}, {4,4}, {2,3}, {3,2}, {3,4}, {4,3}, {2,4}, {4,2}

import java.util.List;
import java.util.ArrayList;

public class Main {

  private static void permutations(List<Integer> set, int n) {

    int nPermut = (int) Math.pow((double)set.size(), (double)n);

    for(int i = 0; i < nPermut; i++) {
      int number = i;
      for(int j = 0; j < n; j++) {
        int index = number % set.size();
        System.out.print(set.get(index) + ",");
        number /= set.size();
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    List<Integer> set = new ArrayList<Integer>();
    set.add(2);
    set.add(3);
    set.add(4);
    permutations(set, 2);
  }

}
