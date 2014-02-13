

import java.util.Random;

public class Main {

  private final static int POTS = 30;
  private final static int MAX_COINS = 10;

  private static int getMoves(int[] pots, int left, int right, boolean myTurn) {

    if(left == right)    
      return myTurn ? pots[left] : -1 * pots[left]; 

    int coins = myTurn? pots[left] : -1 * pots[left];   
    int leftValue = coins + getMoves(pots, left + 1, right, !myTurn);
    
    coins = myTurn? pots[right] : -1 * pots[right];   
    int rightValue = coins + getMoves(pots, left, right - 1, !myTurn);

    if(left == 0 && right == pots.length -1)
      System.out.println(leftValue > rightValue? "Left" : "Right");

    return Math.max(leftValue, rightValue);
  }

  public static void main(String[] args) {

    Random rnd = new Random();
    int[] pots = new int[POTS];
    for(int i = 0; i < POTS; i++)
      pots[i] = rnd.nextInt(MAX_COINS) + 1;

    System.out.print("Pots: ");
    for(int pot : pots) 
      System.out.print(pot + " ");
    System.out.println();

    int value = getMoves(pots, 0, pots.length - 1, true);
    System.out.println("Points: " + value);
  }

}
