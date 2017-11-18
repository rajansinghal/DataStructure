package com.practice.program;

/**
 * Created by rsinghal on 11/15/2017.
 */
public class TraversalInBT {

    public void postorder(Node root) {
        if(root !=  null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.value);
        }
    }

    public void inorder(Node root) {
        if(root !=  null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if(root !=  null) {
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static  void main(String arr[]){
        Node a = new Node(20);
        Node b = new Node(15);
        Node c = new Node(25);
        Node d = new Node(12);
        Node e = new Node(18);
        Node f = new Node(22);
        Node g = new Node(28);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);

        new TraversalInBT().postorder(a);
        System.out.println("--------------------");
        new TraversalInBT().preorder(a);
        System.out.println("--------------------");
        new TraversalInBT().inorder(a);

    }

}
