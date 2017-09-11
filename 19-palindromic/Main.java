/* Write a function to compute the maximum length palindromic sub-sequence of an array.
A palindrome is a sequence which is equal to its reverse.
A sub-sequence of an array is a sequence which can be constructed by removing elements of the array.
Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's) */ 

public class Main {
	public static void main(String[] args) {	
		int arr[] = new int[] {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};	
		System.out.println(maxLengthPalindrome(arr, 0, arr.length-1));
	}

	public static int maxLengthPalindrome(int[] values, int i, int j) {
		//check if indexes cross each other
		//return 1 if index overlap for else condition below
		//return 0 if index i<j for condition if below
		if(j<=i) 
                  return j-i+1;
		if(values[i]==values[j]) 
                  return 2 + maxLengthPalindrome(values, i+1, j-1);
		else 
                  return Math.max(maxLengthPalindrome(values, i+1, j), maxLengthPalindrome(values, i, j-1));		
	}
}
