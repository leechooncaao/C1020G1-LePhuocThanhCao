package javacollectionframework.bai_tap.binarytree;

import com.sun.javadoc.SeeTag;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);

        //

//        tree.traversePreOrder();
//        System.out.println();
//        tree.traversePostOrder();

        System.out.println(tree.contains(10));


    }
}
