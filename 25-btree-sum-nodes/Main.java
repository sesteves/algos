// A node of a binary tree has two pointers left and right and two data fields- left count and right count. left count specifies the number of nodes in left of the node and right specifies the number of nodes in right of the node. Write an algorithm to populate the data fields of all the nodes of the tree.

import java.util.LinkedList;

public class Main {

  private static int sum(Node node) {
    if(node == null)
      return 0;

    int countL = sum(node.lchild);
    int countR = sum(node.rchild);

    node.lcount = countL;
    node.rcount = countR;

    return countL + countR + 1;
  } 

  private static void printNode(Node root) {

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while(!queue.isEmpty()) {
      Node node = queue.remove();

      System.out.println(node.lcount +  "," + node.rcount);

      if(node.lchild != null) {
        queue.add(node.lchild);
      }
      if(node.rchild != null) {
        queue.add(node.rchild);
      }
    }

  }

  public static void main(String[] args) {
    Node root = new Node(new Node(new Node(null, new Node(new Node(), new Node())), null ), 
      new Node(null, new Node(new Node(), new Node())));

    sum(root);
    printNode(root);
  }

  static class Node {
    Node lchild;
    Node rchild;
    int lcount;
    int rcount;

    public Node() {
    }

    public Node(Node lchild, Node rchild) {
      this.lchild = lchild;
      this.rchild = rchild;
    }

  }
}
