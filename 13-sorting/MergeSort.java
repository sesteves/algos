public class MergeSort {


  private static int[] merge(int[] arr0, int[] arr1) {
    int total = arr0.length + arr1.length;
    int[] result = new int[total];

    int j=0, k=0;
    for(int i = 0; i < total; i++) {

 
      if(k == arr1.length) {
        result[i] = arr0[j++];
      } else if(j == arr0.length) {
        result[i] = arr1[k++];
      } else if(arr0[j] < arr1[k]) {
        result[i] = arr0[j++];
      } else {
        result[i] = arr1[k++];
      }
    }

    return result;
  }

  private static int[] merge(int[] arr, int start, int end) {
    System.out.println("start: " + start + " :: end: " + end);
    if(start >= end) {
      return new int[]{arr[start]}; 
    }
  
    int middle = start + (end - start) / 2;
    int[] firstHalf = merge(arr, start, middle);
    int[] secondHalf = merge(arr, middle + 1, end);
    return merge(firstHalf, secondHalf);
  }

  public static void main(String[] args) {
    int[] arr = {4,9,2,6,5,8};
    int[] result = merge(arr,0,arr.length-1);
    for(int i : result) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}
