// print out all possible combinations of sums to get to n
//Example
//N= 5
//1 + 1 + 1 +1 +1
//2 + 1 + 1 + 1
//3 + 1 +1
//2 + 2 + 1
//4 + 1
//3 + 2

public class Main {

  private static void getSum(String str, int n, int maxi) {

    if(n == 0) {
      System.out.println(str);
      return;
    }

    for(int i = 1; i <= n && i <= maxi; i++) {
      getSum((str == "" ? "" : (str + "+")) + i, n - i, i);
    }
  }

  public static void main(String[] args) {  
    int n = 10;
    getSum("", n, n);
  }

} 
