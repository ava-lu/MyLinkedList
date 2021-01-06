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
}
