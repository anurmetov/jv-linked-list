package core.basesyntax;

import java.util.List;

public class MyLinkedList<T> implements MyLinkedListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;


        public Node(Node<T> next, Node<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

    }

    @Override
    public void add(T value) {
        Node<T> newNode;
        if (size == 0) {
            newNode = head = tail = new Node<>(null, null, value);
        } else {
            newNode = new Node<>(null, tail, value);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> newNode;

        if (index == 0) {
            newNode = new Node<>(head, null, value);
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) { // вставка в кінець
            newNode = new Node<>(null, tail, value);
            tail.next = newNode;
            tail = newNode;
        } else { // вставка в середину
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode = new Node<>(current, current.prev, value);
            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;
    }

    @Override
    public void addAll(List<T> list) {
        if (list != null) {
            for (T element : list) {
                add(element);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    @Override
    public T set(T value, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        // TODO: Faxen hier lässt sich nicht tauschen sondern schiebt andere nach rechts

        Node<T> newNode;

        if (index == 0) {
            newNode = new Node<>(head.next, null, value);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) { // вставка в кінець
            newNode = new Node<>(null, tail.prev, value);
            tail.next = null;
            tail.prev = null;
        } else { // вставка в середину
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode = new Node<>(current, current.prev.next, value);
            current.prev.next = newNode;
            current.prev = null;
        }

        size++;


        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T object) {
        return false;
    }


    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
