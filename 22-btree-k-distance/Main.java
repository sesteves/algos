// given a binary tree, a node and an integer k, return all nodes at distance k from the given node.

import java.util.LinkedList;

public class Main {

  private static void findKNodes(Node root, int targetValue, int k) {

    LinkedList<Node> queue = new LinkedList<Node>();  
  
    Node node = root;
    while(node != null) {

      if(node.value == targetValue) {
        System.out.println(queue.remove().value + " ");
        int kk = k;
        for(Node n : queue) {
          if(targetValue < n.value)
            n.lchild = null;
          else
            n.rchild = null;
          findKNodesDownwards(n, --kk);
        }
        findKNodesDownwards(node, k);
        break;

      } else {
        queue.add(node);
        if(queue.size() > k)
          queue.remove();
      }

      if(targetValue < node.value) {
        node = node.lchild;
      } else {
        node = node.rchild;
      }
    }
  }

  private static void findKNodesDownwards(Node node, int k) {
    if(k == 0) {
      System.out.println(node.value + " ");
      return;
    }

    if(node.lchild != null)
      findKNodesDownwards(node.lchild, k - 1);

    if(node.rchild != null)
      findKNodesDownwards(node.rchild, k - 1);
  }



  public static void main(String[] args) {
    Node root = new Node(20, 
                  new Node(15, new Node(12, null, new Node(14, new Node(13), new Node(15))),
                  new Node(18)),
                  new Node(25));
    int targetValue = 12;
    int k = 2;
    findKNodes(root, targetValue, k);

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

