// http://en.wikipedia.org/wiki/Exponentiation_by_squaring

public class Main {


private static double pow(int base, int e) {
  double res = 1;

  if(base == 1)
    return 1;

  int ee = e < 0 ? e * -1 : e; 
  for(int i = 0; i < ee /2; i++) {
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

  // only for cases where e is positive
  private static double powExpBySquaring(int base, int e) {

    if (e < 0) return powExpBySquaring(1/base, -e);
    if (e == 0) return 1;
    if (e == 1) return base;
    if (e % 2 == 0) return powExpBySquaring(base * base, e / 2);
    // if (e % 2 != 0) 
    return base * powExpBySquaring(base * base, (e - 1) / 2);

  }  

  public static void main(String[] args) {
    System.out.println(pow(-3,-5));
    System.out.println(powExpBySquaring(-3,-5));
  }

}
