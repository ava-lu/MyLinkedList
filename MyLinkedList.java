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
    if (size==0) {
      add(value);
    }
    else {
      Node adding = new Node(value);
      if (index==0) {
        start.setPrev(adding);
        adding.setNext(start);
        start = adding;
      }
      else if (index==size) {
        add(value);
      }
      else {
        Node current = getIndex(index);
        adding.setNext(current);
        adding.setPrev(current.getPrev());
        current.getPrev().setNext(adding);
        current.setPrev(adding);
      }
    }
    size++;
  }
  public String get(int index) {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException();
    }
    return getIndex(index).getData();
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
      for (int i=0; i<size; i++) {
        ans = ans + get(i);
        if (i!=size-1) ans = ans + ", ";
        else ans+= "]";
        }
      }
    if (size == 0) ans = "[]";
    return ans;
  }
  public String remove(int index) {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException();
    }
    Node temp = getIndex(index);
    if (size!=1) {
      if (index==0) {
        start = temp.getNext();
        start.setPrev(null);
      }
      else if (index==size-1) {
        end = temp.getPrev();
        end.setNext(null);
      }
      else {
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
      }
    }
    else {
      start = null;
      end = null;
    }
    size--;
    return temp.getData();
  }
  public void extend(MyLinkedList other) {
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    other.size = 0;
    other.start = null;
    other.end = null;
  }
}
