package com.practice.program.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rsinghal on 12/4/2017.
 */
//https://www.java2blog.com/breadth-first-search-in-java/
public class BFS1 {

    private  NodeBFS startingNode;

    public BFS1(NodeBFS startingNode) {
       this.startingNode = startingNode;
    }

    public void traverseBFS(){

        Queue<NodeBFS> queue= new LinkedList<>();
        this.startingNode.setVisited(true);
        queue.add(this.startingNode);
        while(!queue.isEmpty()){

            NodeBFS nodeBFS = queue.remove();
            System.out.println(nodeBFS.getVal());

            for(NodeBFS n :nodeBFS.getNeighbours()){
                if(n!=null && ! n.isVisited()) {
                    n.setVisited(true);
                    queue.add(n);
                }

            }

        }

    }


    public static void main(String[] args) {

        NodeBFS node40 =new NodeBFS(40);
        NodeBFS node10 =new NodeBFS(10);
        NodeBFS node20 =new NodeBFS(20);
        NodeBFS node30 =new NodeBFS(30);
        NodeBFS node60 =new NodeBFS(60);
        NodeBFS node50 =new NodeBFS(50);
        NodeBFS node70 =new NodeBFS(70);

        node40.getNeighbours().add(node10);
        node40.getNeighbours().add(node20);
        node10.getNeighbours().add(node30);
        node20.getNeighbours().add(node10);
        node20.getNeighbours().add(node30);
        node20.getNeighbours().add(node60);
        node20.getNeighbours().add(node50);
        node30.getNeighbours().add(node60);
        node60.getNeighbours().add(node70);
        node50.getNeighbours().add(node70);

        BFS1 bfs = new BFS1(node40);
        bfs.traverseBFS();
    }
}

class NodeBFS{

    private int val;
    private List<NodeBFS> neighbours;
    private boolean visited;

    public NodeBFS(int val) {
        this.val = val;
        this.neighbours = new ArrayList<>();
    }

    public int getVal() {
        return val;
    }



    public List<NodeBFS> getNeighbours() {
        return neighbours;
    }



    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}