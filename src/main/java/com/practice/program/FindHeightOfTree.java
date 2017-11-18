package com.practice.program;

/**
 * Created by rsinghal on 11/14/2017.
 */
public class FindHeightOfTree {


    public static void main(String arr[]){

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        d.setRight(f);

        System.out.println("height of tree is "  + new FindHeightOfTree().binaryDepth2(a));

    }


    public int binaryDepth(Node node, int d){
        int leftDepth = d, rightDepth = d;

        if(node.left != null){
            leftDepth = binaryDepth(node.left, d+1);
        }
        if(node.right != null){
            rightDepth = binaryDepth(node.right, d+1);
        }

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public int binaryDepth2(Node node){
        if(node == null)
            return 0;
        int left = binaryDepth2(node.left);
        int right = binaryDepth2(node.right);

        int x = left > right ? left+1 : right+1;
        return x;
    }
}
