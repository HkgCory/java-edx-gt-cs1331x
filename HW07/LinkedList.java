import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public Node<T> getHead() {
    return this.head;
  }

  public Node<T> getTail() {
    return this.tail;
  }

  public int getSize() {
    return this.size;
  }

  public void addToFront(T data) {}

  @Override
  public void addAtIndex(T data, int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException(
        "Your index is out of the list bounds"
      );
    }
    if (data == null) {
      throw new IllegalArgumentException(
        "You cannot add null data to the list"
      );
    }

    if (index == 0) {
      Node<T> newNode = new Node<>(data, head);
      head = newNode;
      if (size == 0) {
        tail = head;
      }
    } else {
      Node<T> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      Node<T> newNode = new Node<>(data, current.getNext());
      current.setNext(newNode);
      if (index == size) {
        tail = newNode;
      }
    }
    size++;
  }

  @Override
  public T getAtIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException(
        "Your index is out of the list bounds"
      );
    }
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  @Override
  public T removeAtIndex(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Your index is out of bounds");
    }
    Node<T> removeNode;
    if (index == 0) {
      removeNode = head;
      head = head.getNext();
      if (size == 1) {
        tail = null;
      }
    } else {
      Node<T> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      removeNode = current.getNext();
      current.setNext(removeNode.getNext());
      if (index == size - 1) {
        tail = current;
      }
    }
    size--;
    return removeNode.getData();
  }

  @Override
  public T remove(T data) {
    if (data == null) {
      throw new IllegalArgumentException(
        "You cannot remove null data from the list."
      );
    }
    Node<T> current = head;
    if (current == null) {
      throw new NoSuchElementException("The data is not present in the list.");
    }
    if (current.getData().equals(data)) {
      return removeAtIndex(0);
    }
    while (
      current.getNext() != null && !current.getNext().getData().equals(data)
    ) {
      current = current.getNext();
    }
    if (current.getNext() == null) {
      throw new NoSuchElementException("The data is not present in the list.");
    }
    Node<T> removedNode = current.getNext();
    current.setNext(removedNode.getNext());
    if (removedNode == tail) {
      tail = current;
    }
    size--;
    return removedNode.getData();
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }
}
