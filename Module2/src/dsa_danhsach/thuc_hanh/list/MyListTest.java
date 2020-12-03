package dsa_danhsach.thuc_hanh.list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("element 3: " + list.get(3));
        System.out.println("element 1: " + list.get(1));
        System.out.println("element 2: " + list.get(2));

        list.get(-1);
        System.out.println("element -1: " + list.get(-1));
    }
}
