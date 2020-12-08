package javacollectionframework.thuc_hanh.caidatbinarysearchtree;

public class AbstractTree<E> implements Tree<E>{

    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public void traverseInOrder() {

    }

    @Override
    public int size() {
        return 0;
    }
}
