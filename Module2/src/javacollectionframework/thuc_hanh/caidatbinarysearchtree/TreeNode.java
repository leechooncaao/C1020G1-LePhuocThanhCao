package javacollectionframework.thuc_hanh.caidatbinarysearchtree;


public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E data) {
        this.element = data;
    }
}
