import java.util.*;

public class Main {

  private static List<String> getTopK(List<String> words, int k) {
    Map<String, Node> counts = new HashMap<String, Node>();

    Node head = null, tail = null;
    int listSize = 0;

    for(String word : words) {
      if(counts.containsKey(word)) {
        Node node = counts.get(word);
        node.value++;

        // if it is not on the list
        if(node != tail && node.previous == null && node.next == null) {
          if(listSize < k) { // append elmenet to the tail of the  list
            node.previous = tail;
            tail.next = node;
            tail = node;
            listSize++;
          } else if(node.value > tail.value) { // replace last node on the list by current node
            node.previous = tail.previous;
            tail.previous.next = node;
            tail.previous = null;
            tail = node;
          }
        }

        if(node.previous != null && node.value > node.previous.value) {

          // fix adjacent nodes' links
          node.previous.next = node.next;
          if(node.next != null) {
            node.next.previous = node.previous;
          } else {
            tail = node.previous;
          }
           
          // move node to correct position
          while(node.previous != null && node.value > node.previous.value) {
            node.next = node.previous;
            node.previous = node.previous.previous;
          }

          // fix adjacent nodes' links
          if(node.previous != null) {
            node.previous.next = node; 
          } else {
            head = node;
          }
          node.next.previous = node;
        }


     } else {
       Node node = new Node(word, 1);
       counts.put(word, node);

        // insert on heap max list
        if(listSize < k) {
          if(head == null) {
            head = node;
            tail = node;           
          } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
          }
          listSize++;
        }

      }
    }

    System.out.println("Top " + k + " words");
    List<String> result = new ArrayList<String>();
    for(int i = 0; i < k && head != null; i++) {
      result.add(head.word + " :: " + head.value);
      head = head.next;
    } 
    return result;
  }


  public static void main(String[] args) {

    List<String> words = new ArrayList<String>();
/*
    words.add("a");
    words.add("b");
    words.add("c");
    words.add("a");
    words.add("c");
*/

    System.out.println("Histogram");
    Map<String, Integer> histogram = new HashMap<String, Integer>();   
    Random rnd = new Random();
    String base = "abcdef";
    for(int i = 0; i < 100; i++) {
      String s = "" + base.charAt(rnd.nextInt(base.length()));
      words.add(s);
      if(histogram.containsKey(s)) {
        histogram.put(s, histogram.get(s) + 1);
      } else {
        histogram.put(s, 1);
      }
    }
 
    for(Map.Entry<String, Integer> entry : histogram.entrySet()) {
      System.out.println(entry.getKey() + " :: " + entry.getValue());
    }

    for(String s : getTopK(words, 100)) {
      System.out.println(s);
    }
  }

  private static class Node {
    String word;
    int value;
    Node next = null;
    Node previous = null;

    public Node(String word, int value) {
      this.value = value;
      this.word = word;
    }
 }

}
