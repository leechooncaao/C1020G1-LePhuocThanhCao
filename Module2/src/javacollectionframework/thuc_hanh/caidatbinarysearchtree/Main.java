package javacollectionframework.thuc_hanh.caidatbinarysearchtree;

public class Main {
    public static void main(String[] args) {
        //create a BST
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.traverseInOrder();
        System.out.println("The number of nodes is: " + tree.size());
    }
}
