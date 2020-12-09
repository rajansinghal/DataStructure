package com.practice.program.list;

public class ReverseList {

    // 1-> 2 -> 3 -> 4 -> 5 -> 6
    //o/p  6 -> 5 -> 4 -> 3 -> 2 -> 1

    public static void main(String[] args) {

        Node n5 = new Node(5,null);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        print(n1);
        System.out.println("-------------");
        reverse(n1);

    }

    public static void reverse(Node node ){
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        //return node;
        print(node);
    }

    public  static  void  print(Node n){

        while(n != null){
            System.out.println(n.value);
            n = n.next;
        }
    }
}

class  Node{
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}