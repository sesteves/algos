// https://www.hackerrank.com/challenges/angry-children-2

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
  
    

  private static void getMinUnfairness(int[] arr, int N, int K, int idx, int sum) {
           
     for(int i = idx; i < N; i++) {
       int minUnfairness = getMinUnfairness(arr, N, K, idx + 1, sum + (arr[idx] - arr[idx - 1]));          
     }
                      
  }
    
    
   public static void solve(int[] arr, int N, int K) {

     int minUnfairness = Integer.MAX_VALUE;     
     for(int i = 0; i < N; i++) {
       int unfairness = getMinUnfairness(arr, N, K);            
       if(unfairness < minUnfairness) {

       }

     }    
   }

    public static void main(String[] args)  throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
         int K = Integer.parseInt(br.readLine());
         int [] arr = new int[N];
         for(int i = 0; i < N; i++)
          arr[i] = Integer.parseInt(br.readLine());
         solve(arr, N, K);
    }
}
