public class QuickSort {


  private static int[] quickSort(int[] arr, int start, int end) {
    int i = start, j = end;
    int pivot = arr[start + (end - start) / 2];

    while(i <= j) {

      while(arr[i] < pivot)
        i++;
      while(arr[j] > pivot)
        j--;
      
      if(i <= j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }

      if(start < j)
        quickSort(arr, start, j);
      if(i < end)
        quickSort(arr, i, end);
    }
    return arr;
 }

  public static void main(String[] args) {
    int[] arr = {4,9,2,6,5,8};
    int[] result = quickSort(arr,0,arr.length-1);
    for(int i : result) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}
