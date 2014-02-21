
public class Main {


private static double pow(int base, int e) {
  double res = 1;

  if(base == 1)
    return 1;

  for(int i = 0; i < e /2; i++) {
    res = res * base;
  }
  res *= res;
  if(e % 2 != 0)
    res *= base;

  if(e < 0) {
    res = 1 / res;   // 2^-2 = 1 / 2^2
  }
  return res;
}



  public static void main(String[] args) {
    System.out.println(pow(-3,5));
  }

}
