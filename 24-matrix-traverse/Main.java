// Traverse a given 2D matrix from given source to destination in such way that every cell should be visited exactly one time (we have to cover all cells of matrix exactly once and have to reach at destination).

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

  // a linkedhashmap could be used here instead of lock, count, path
  private static void traverse(int xlim, int ylim, int sourceX, int sourceY, int destX, int destY, boolean[] lock, int count, String path) {

    lock = lock.clone();
    int cell = sourceY * xlim + sourceX;
    lock[cell] = true;
    count++;
    path = new String(path +  "->" + sourceX + "," + sourceY); 

    if(sourceX == destX && sourceY == destY) {
      if(count == xlim * ylim)
        System.out.println("Found path: " + path);
      else
        return;
    }

    // up
    if(sourceY - 1 >= 0 && !lock[cell - 4]) {
      traverse(xlim, ylim, sourceX, sourceY - 1, destX, destY, lock, count, path);
    }

    // left
    if(sourceX - 1 >= 0 && !lock[cell - 1])
      traverse(xlim, ylim, sourceX - 1, sourceY, destX, destY, lock, count, path); 

    // down
    if(sourceY + 1 < ylim && !lock[cell + 4])
      traverse(xlim, ylim, sourceX, sourceY + 1, destX, destY, lock, count, path); 

    // right
    if(sourceX + 1 < xlim && !lock[cell + 1])
      traverse(xlim, ylim, sourceX + 1, sourceY, destX, destY, lock, count, path); 
  }

  private static Map<Integer, String> traverse2(int xlim, int ylim, int sourceX, int sourceY, int destX, int destY, LinkedHashMap<Integer, String> path) {

    if(sourceX < 0 || sourceX >= xlim || sourceY < 0 || sourceY >= ylim) {
      return null;
    }
    int cell = sourceY * xlim + sourceX; 

    // cell was already visited
    if(path.containsKey(cell))
      return null;

    path = new LinkedHashMap<Integer, String>(path);
    path.put(cell, sourceX + "," + sourceY);

    // printMap(path);

    if(sourceX == destX && sourceY == destY) {
      if(path.size() == xlim * ylim)
        return path;
      else
        return null;
    }

    Map<Integer, String> res;
    if((res = traverse2(xlim, ylim, sourceX, sourceY - 1, destX, destY, path)) != null) return res;
    if((res = traverse2(xlim, ylim, sourceX - 1, sourceY, destX, destY, path)) != null) return res;
    if((res = traverse2(xlim, ylim, sourceX, sourceY + 1, destX, destY, path)) != null) return res;
    if((res = traverse2(xlim, ylim, sourceX + 1, sourceY, destX, destY, path)) != null) return res;
    return null;
  }

  private static void printMap(Map<Integer, String> path) {
    if(path == null) {
      System.out.println("Nothing to print!");
      return;
    }
    for(String str : path.values()) {
      System.out.print("->" + str);
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int xlim = 4, ylim = 4;
    boolean[] lock = new boolean[xlim * ylim];
    traverse(xlim, ylim, 0, 0, 0, 3, lock, 0, "");
    System.out.println();
    traverse(xlim, ylim, 1, 0, 3, 3, lock, 0, "");
    System.out.println();

    printMap(traverse2(xlim, ylim, 0, 0, 0, 3, new LinkedHashMap<Integer, String>()));
    System.out.println();
    printMap(traverse2(xlim, ylim, 1, 0, 3, 3, new LinkedHashMap<Integer, String>()));

  }

}
