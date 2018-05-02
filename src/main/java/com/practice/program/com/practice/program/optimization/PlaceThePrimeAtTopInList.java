package com.practice.program.com.practice.program.optimization;

/**
 * Created by rsinghal on 4/25/2018.
 */
public class PlaceThePrimeAtTopInList {

    public  static  void  main(String arr[]){

        Node n = new Node(4);
        Node n1 = new Node(6);
        Node n2 = new Node(5);
        Node n3 = new Node(2);
        Node n4 = new Node(8);

        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        sortByPrime(n);
    }

    private static  void sortByPrime(Node n){
        Node root = n;
        Node primeRoot = null;
        Node prv = null;
        while(n != null){

            if(!isPrime(n.value)) {
                prv = n;
                n = n.next;
            } else{

                if(primeRoot != null) {
                    primeRoot.next = new Node(n.value);
                }else {
                    primeRoot = new Node(n.value);
                }
                prv.next = n.next;
                n= prv.next;
            }
        }

        Node finalOutput = concatenateList(primeRoot, root);
        printList(finalOutput);
    }

    private static Node concatenateList(Node primeRoot, Node root){

        Node parent = primeRoot;
        while(primeRoot.next != null){
            primeRoot = primeRoot.next;
        }
        primeRoot.next = root;

        return  parent;
    }

    private static void printList(Node n){

        while(n.next != null){
            System.out.println(n.value);
            n = n.next;
        }

        System.out.println(n.value);
    }

    private static boolean isPrime(int num){
        int temp;
        boolean isPrime=true;
          //capture the input in an integer
        for(int i=2;i<=num/2;i++)
        {
            temp=num%i;
            if(temp==0)
            {
                isPrime=false;
                break;
            }
        }
        //If isPrime is true then the number is prime else not
        if(isPrime)
            return true;
        else
           return false;
    }
}

class Node{
    int value ;
    Node next;
    Node(int value){
        this.value = value;
    }
}
