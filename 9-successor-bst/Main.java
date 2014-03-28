// Given a bst and node, find the next successor node in-order.


public class Main {


  private static Node getSuccessor(Node node) {

    Node current = null;

    // 1st case: if node has right child the successor will be there
    if(node.rightChild != null) {
      current = node.rightChild;
     
      while(current.leftChild != null) { 
        current = current.leftChild;       
      }

    } else { // 2nd case: if node does not have the right child the successor node will be its next ancestor with higher value
      current = node.parent;
      while(current != null && current.value < node.value) {
        current = current.parent;
      }
    }
    return current;
  }


  public static void main(String[] args) {

/*
   10
  /  \
 7    12
/ \  /  \
3 8 11 14

*/

    Node root = new Node(10, null);
    Node node1 = new Node(7, root);
    Node node2 = new Node(12, root);
    Node node3 = new Node(3, node1);
    Node node4 = new Node(8, node1);
    Node node5 = new Node(11, node2);
    Node node6 = new Node(14, node2);

    root.leftChild = node1;
    root.rightChild = node2;
    root.leftChild.leftChild = node3;
    root.leftChild.rightChild = node4;
    root.rightChild.leftChild = node5;
    root.rightChild.rightChild = node6;

    Node successor = getSuccessor(node6);
    System.out.println("Node: " + node6.value + ", Successor: " + (successor != null ? successor.value : "Null"));
  }

  private static class Node {

    public Node leftChild, rightChild;
    public Node parent;
    public int value;

    public Node(int value, Node parent) {
      this.value = value;	
      this.parent = parent;
      this.leftChild = null;
      this.rightChild = null;
    }

  }

}

