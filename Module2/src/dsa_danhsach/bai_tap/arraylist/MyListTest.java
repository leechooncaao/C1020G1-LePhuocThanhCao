package dsa_danhsach.bai_tap.arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        list.add(0,1);
        list.add(0,3);
        list.add(12);
        list.add(1,5);
        list.add(3,7);

        list.print();

        list.ensureCapacity(10);
        list.add(10);

        list.clear();
        list.print();

//        System.out.println(list.get(10));

//        var result = list.indexOf(2);
//        System.out.println(result);


//        var result = list.remove(2);
//        System.out.println(result);
//        list.print();
//
//        System.out.println(list.size());
//
//        var newItems = list.clone();
//        System.out.println(Arrays.toString(newItems));




    }
}
