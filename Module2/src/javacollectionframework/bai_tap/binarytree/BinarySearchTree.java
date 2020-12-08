package javacollectionframework.bai_tap.binarytree;

import java.util.NoSuchElementException;

public class BinarySearchTree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
            return;
        }

        var current = root;
        while (true){
            if(node.value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else {
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    // root -> left -> right
    private void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    // left -> right -> root
    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public boolean contains(int value){
        var current = root;
        while (current != null){
            if(value == current.value){
                return true;
            }else if(value < current.value)
                current = current.leftChild;
            else current = current.rightChild;
        }

        return false;
    }

    public void remove(int value){
        if(!contains(value))
            throw new NoSuchElementException();



    }


}
