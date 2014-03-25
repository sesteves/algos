// You are given an array of n integers which can contain integers from 1 to n only . Some elements can be repeated multiple times and some other elements can be absent from the array . Write a running code on paper which takes O(1) space apart from the input array and O(n) time to print which elements are not present in the array and the count of every element which is there in the array along with the element number .

// O(n) time, O(1) space
public class Main {



  private static void getFrequency(int[] arr, int size) {

    int pos = 0;
    while(pos < size) {
      if(arr[pos] <= 0)  {
        pos++;
        continue;
      }

      int targetPos = arr[pos] - 1; 

      if(arr[targetPos] > 0) {        
        arr[pos] = arr[targetPos];
        arr[targetPos] = -1;
      } else {
        arr[targetPos]--;
        arr[pos] = 0;
        pos++;
      }
      
    }

  }

  public static void main(String[] args) {
    int[] arr = new int[] {6,4,1,4,3,2,5,2,1};

    for(int elem : arr)
      System.out.print(elem + " ");
    System.out.println();

    int size = arr.length;
    getFrequency(arr, size);
    for(int elem : arr) 
      System.out.println(elem + ",");
    System.out.println();
  }

}
