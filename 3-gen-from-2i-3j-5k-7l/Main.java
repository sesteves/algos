import java.util.PriorityQueue;

public class Main {


  private static void generate(int n) {

    double value;
    for(int i = 1; i <= n; i++) {
      if(i == 1 || i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
        System.out.print(i + " ");
    }
  }

  private static void generate2(int n) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    queue.add(1);
    while(n-- != 0) {
      int value = queue.poll();
      System.out.print(value + " ");
      if(!queue.contains(value*2))
        queue.add(value*2);
      if(!queue.contains(value*3))
        queue.add(value*3);
      if(!queue.contains(value*5))
        queue.add(value*5);
      if(!queue.contains(value*7))
        queue.add(value*7);
    }
  }

  public static void main(String[] args) {

    generate(100);
    System.out.println();
    generate2(100);
    System.out.println();
  }
}
