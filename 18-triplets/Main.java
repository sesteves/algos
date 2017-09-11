


import java.util.*;


public class Main {



  private static List<List<Integer>> getAllTriplets(int[] arr, int idx) {

    int number = arr[idx];
    if(idx == arr.length - 1) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> subresult = new ArrayList<Integer>();
      subresult.add(number);
      result.add(subresult);
      return result;
    }    


    for(int i = idx + 1; i < arr.length; i++) {
      List<List<Integer>> result = getAllTriplets(arr, i);
      List<Integer> subresult = results.get(0);
      if(subresult.size() == 3) {
        List<Integer> newSubresult = new ArrayList<Integer>();
        newSubResult.add(subresult.get(1));
        newSubResult.add(subresult.get(2));
      } else {
        subresult.add(number);
      }


    }





  } 


  public static void main(String[] args) {

    List<Integer> list = new ArrayList<Integer>();
    list.add(9);
    list.add(8);
    list.add(10);
    list.add(7);

    List<List<Integer>> result = getAllTriplets(new int[]{9,8,10,7}, 0);

  }

}
