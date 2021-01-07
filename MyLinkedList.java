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
    }
    else {
      end.setNext(a);
      a.setPrev(end);
      end = a;
    }
    size++;
    return true;
  }
  private Node getIndex(int index) {
    Node ans = start;
    for (int i=0; i<index; i++) {
      ans = ans.getNext();
    }
    return ans;
  }
  public void add(int index, String value) {
    if (index<0 || index>size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = getIndex(index);
    Node adding = new Node(value);
    adding.setNext(current);
    adding.setPrev(current.getPrev());
    if (index==0) {
      start = current;
    }
    // else if (index==size) {
    //
    // }
    else {
      current.getPrev().setNext(adding);
      current.setPrev(adding);
    }
    size++;
  }
  public String get(int index) {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException();
    }
    String ans = "";
    Node temp = getIndex(index);
    ans = temp.getData();
    return ans;
  }
  public String set(int index, String value) {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException();
    }
    Node newnode = getIndex(index);
    String ans = newnode.getData();
    newnode.setData(value);
    return ans;
  }
  public String toString() {
    String ans = "[";
    if (size!=0) {
      Node current = start;
      while (current!=end) {
        ans = ans + current.getData() + ", ";
        current = current.getNext();
      }
    }
    else {
      ans = ans + "]";
    }
    return ans;
  }
}
