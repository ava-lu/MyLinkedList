public class Node {
  public Node(String value) {
    data = "";
  }
  private String data;
  private Node next, prev;
  public String getData() {
    return data;
  }
  public void setData(String str) {
    data = str;
  }
  public Node getNext() {
    return next;
  }
  public void setNext(Node n) {
    next = n;
  }
  public Node getPrev() {
    return prev;
  }
  public void setPrev(Node p) {
    prev = p;
  }
}
