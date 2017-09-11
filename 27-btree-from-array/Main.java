// Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.

import java.util.LinkedList;

public class Main {


  private static Node createTree(int[] arr, int starti, int endi) {

    if(starti > endi)
      return null;

    int mid = starti + (endi - starti) / 2;
    Node node = new Node(arr[mid]);
    node.lchild = createTree(arr, starti, mid - 1);
    node.rchild = createTree(arr, mid + 1, endi);
    return node;
  }


  private static void printTree(Node root) {

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while(!queue.isEmpty()) {
      Node node = queue.remove();

      System.out.println(node.value);

      if(node.lchild != null) {
        queue.add(node.lchild);
      }
      if(node.rchild != null) {
        queue.add(node.rchild);
      }
    }

  }


  public static void main(String[] args) {    
    Node root = createTree(new int[]{1,2,3,4,5}, 0, 4);
    printTree(root);
  }

  static class Node {
    int value;
    Node lchild;
    Node rchild;

    public Node(int value) {
      this.value = value;
   }
  }
}
