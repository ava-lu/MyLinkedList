public class MyLinkedList {
  private int size;
  private Node start, end;
  public MyLinkedList() {
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean add(String value) {
    Node a = new Node(value);
    if (size==0) {
      start = a;
      end = a;
      return true;
    }
    else {
      end.setNext(a);
      a.setPrev(end);
      end = a;
      return true;
    }
  }
}
