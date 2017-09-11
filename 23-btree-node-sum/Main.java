// given BST, replace each node with the sum of the values of all nodes that are greater than that node.


import java.util.LinkedList;

public class Main {

  private static int sumNodes(Node node, int sum) {
    if(node == null) {
      return sum;
    }
    int sumRight = sumNodes(node.rchild, sum);    
    int sumLeft = sumNodes(node.lchild, sumRight + node.value);
    node.value = sumRight;
    return sumLeft;

  }

  private static void printNode(Node root) {
    System.out.println("Root: " + root.value);

    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while(!queue.isEmpty()) {
      Node node = queue.remove();

      if(node.lchild != null) {
        System.out.println("Node : " + node.lchild.value);
        queue.add(node.lchild);
      }
      if(node.rchild != null) {
        System.out.println("Node: " + node.rchild.value);
        queue.add(node.rchild);
      }
    }

  }

  public static void main(String[] args) {

    Node root = new Node(20,
                  new Node(16, new Node(12, null, new Node(14, new Node(13), new Node(15))),
                  new Node(18)),
                  new Node(25));

    sumNodes(root, 0);

    printNode(root);

  }

  static class Node {
    int value;
    Node lchild;
    Node rchild;

    public Node(int value, Node lchild, Node rchild) {
      this.value = value;
      this.lchild = lchild;
      this.rchild = rchild;
    }
    public Node(int value) {
      this.value = value;
    }
  }

}
