package com.practice.program.tree;

/**
 * Created by rsinghal on 11/14/2017.
 */
public class Node {

    public Node left;
    public int value;
    public Node right;

    public Node() {
    }

    public Node(int value) {
        this.left = null;
        this.value = value;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
