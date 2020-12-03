package dsa_danhsach.bai_tap.linkedlist;

import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);


//        list.addLast(5);
//        list.addLast(6);
//        list.addLast(7);
//        list.addLast(8);

        list.add(12);

        list.print();

        System.out.println("size= " +list.size());

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(4));

        list.clear();
        list.print();

//        list.remove(Integer.valueOf(7));
//
//        list.print();

//        LinkedList<Integer> list1 = new LinkedList<>();
//
//        var result = list1.remove(1);
//        System.out.println(result);
    }
}
