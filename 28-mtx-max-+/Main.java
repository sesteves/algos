// Given a binary N X N matrix, return the size of the largest '+' of ones. 


public class Main {

  enum Direction {
    UP, LEFT, DOWN, RIGHT
  }

  private static int getOnesInDirection(int[][] mtx, int i, int j, int xlim, int ylim, Direction direction) {
    int ii = i;
    int jj = j;
    int count = 0;

    switch(direction) {
      case UP:
        while(--jj >= 0 && mtx[ii][jj] != 0)
          count++;
        break;
      case LEFT:
         while(--ii >= 0 && mtx[ii][jj] != 0)
          count++;
        break;
      case DOWN:
          while(++jj < ylim && mtx[ii][jj] != 0)
          count++;
        break;
     case RIGHT:
         while(++ii < xlim && mtx[ii][jj] != 0)
          count++;
        break;
    }
    return count;
  }

  private static int getLargestPlus(int[][] mtx, int xlim, int ylim) {
    int max = 0;

    for(int i = 0; i < xlim; i++) {
      for(int j = 0; j < ylim; j++) {
        if(mtx[i][j] == 0)
          continue;

        int min = Math.min(getOnesInDirection(mtx, i, j, xlim, ylim, Direction.UP), 
                  Math.min(getOnesInDirection(mtx, i, j, xlim, ylim, Direction.LEFT), 
                  Math.min(getOnesInDirection(mtx, i, j, xlim, ylim, Direction.DOWN), 
                           getOnesInDirection(mtx, i, j, xlim, ylim, Direction.RIGHT))));
        int size = 4 * min + 1;
        if(size > max) {
          max = size;
        }
      }
    }

    return max;
  }

  public static void main(String[] args) {

    int[][] mtx = new int[][]{{0,0,0,0},
                              {1,1,0,1},
                              {1,1,1,1},
                              {1,1,1,0}};

    System.out.println(getLargestPlus(mtx, 4, 4));
  }

}
