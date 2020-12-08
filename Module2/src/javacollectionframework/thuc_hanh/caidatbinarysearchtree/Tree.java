package javacollectionframework.thuc_hanh.caidatbinarysearchtree;

public interface Tree<E> {
    boolean insert(E e);

    void traverseInOrder();

    int size();
}
