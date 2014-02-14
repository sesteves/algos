import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final int MAX = 10;
  private static final int MAX_NR = 5;


  private static int getBestAlign2(int[] array) { // O(n)
    int s = 0;
    for (int i = 0; i < array.length; i++) {
        s = (s + array[i]) % array.length; // avoid overflow issues at slight cost of performance.
                                   // assumes % returns 0 to n-1.
    }
    return s== 0 ? array.length : array.length - 1;
  }

  private static int getBestAlign(int[] array) {
    // count number of elments that are equal - time: O(n)
    Integer value, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxCount = Integer.MIN_VALUE;
    for(int elem : array) {
      if(elem > max)
        max = elem;
      if(elem < min)
        min = elem;
    }

    // check each candidate - time O(nk) where k is the number of possible candidates 
    for(int candidate = min + 1; candidate < max; candidate++) {
      int sum = 0;
      for(int elem : array)
        sum += candidate - elem;
      if(sum == 0) { 
        System.out.println("Candidate: " + candidate);
        return array.length;
      }
    }
    return array.length - 1;
  }
  

  public static void main(String[] args) {
    Random rnd = new Random();

    int[] arr = new int[MAX];
    for(int i = 0; i < MAX; i++)
      arr[i] = rnd.nextInt(MAX_NR);    

    // arr = new int[] {2,1};

    for(int elem : arr)
     System.out.print(elem + " ");

    int bestAlign = getBestAlign(arr);
    System.out.println("Best align: " + bestAlign);
    bestAlign = getBestAlign2(arr);
    System.out.println("Best align2: " + bestAlign);

  }

}
