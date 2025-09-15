package core.basesyntax;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedListInterface<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50, 2);
        System.out.println(list);



        List<Integer> list1 = new LinkedList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(0, 50);
        System.out.println(list1);
    }
}
