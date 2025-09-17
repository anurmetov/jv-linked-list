package core.basesyntax;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {




        List<Integer> list1 = new LinkedList<>();
        list1.add(10);
        list1.add(20);
        list1.add(20);
        list1.add(0, 50);
        System.out.println(list1);

        MyLinkedListInterface<Integer> list = new MyLinkedList<>();
        list.addAll(list1);
        System.out.println(list);
        list.set(0, 3);
        System.out.println(list);
    }
}
