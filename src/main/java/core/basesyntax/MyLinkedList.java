package core.basesyntax;

import java.util.List;

public class MyLinkedList<T> implements MyLinkedListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;
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
        if (size == 0) {
            head = tail = new Node<>(null, null, value);
        } else {
            current = new Node<>(null, tail, value);
            tail.next = current;
            tail = current;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {

        // Doesnt work
        if (index == 0) {
            head = tail = new Node<>(null, null, value);
        } else {
            current = new Node<>(tail.next, tail, value);
            current.prev.next = current;
            tail.prev = current;
        }
        size++;

    }

    @Override
    public void addAll(List<T> list) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) current;
    }

    @Override
    public T set(T value, int index) {
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
        while (head != null) {
            result.append(head.value);
            if (head.next != null) {
                result.append(", ");
            }
            head = head.next;
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
