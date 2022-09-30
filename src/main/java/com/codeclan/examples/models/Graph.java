package com.codeclan.examples.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import sun.awt.image.ImageWatched;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="graphs")
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @javax.persistence.Transient
    private List<LinkedList<Node>> adjacencyList;

    @javax.persistence.Transient
    private Stack<Node> path;

    //dont think I can store a stack
    @Column(name = "reverse_path")
    private Stack<Node> reversePath;

    @javax.persistence.Transient
    private Node endNode;

    @javax.persistence.Transient
    private Node nextNode;

    @javax.persistence.Transient
    private Boolean isFound;

    @OneToMany(mappedBy="graph")
    @JsonIgnoreProperties({"graph"})
    private List<Node> nodeArrayList;

    @OneToMany(mappedBy="graph")
    @JsonIgnoreProperties({"graph"})
    private List<Node> visitedNodes;

    public Graph() {
        adjacencyList = new ArrayList<>();
        path = new Stack<>();
        reversePath = new Stack<>();
        this.nodeArrayList = new ArrayList<>();
        endNode = new Node();;
        isFound = Boolean.FALSE;
        nextNode = new Node();
        visitedNodes = new LinkedList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAdjacencyListSize() {
        return adjacencyList.size();
    }

    public int getNodeArrayListSize() {
        return nodeArrayList.size();
    }

    public void addNodes() {
        for (Node node : nodeArrayList) {
            LinkedList<Node> currentList = new LinkedList<>();
            currentList.add(node);
            adjacencyList.add(currentList);
        }
    }

    public void findEdges() {
        for (Node nodeOne : nodeArrayList) {
            int tempX = nodeOne.getX();
            int tempY = nodeOne.getY();
            for (Node nodetwo : nodeArrayList) {
                if ((nodetwo.getY() == tempY + 1) && (nodetwo.getX() == tempX)) { //up
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getX() == tempX + 1) && (nodetwo.getY() == tempY)) { //right
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getY() == tempY - 1) && (nodetwo.getX() == tempX)) { //down
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getX() == tempX - 1) && (nodetwo.getY() == tempY)) { //left
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
            }
        }
    }

    public void addEdge(int source, int destination) {
        LinkedList<Node> currentList = adjacencyList.get(source);
        Node dstNode = adjacencyList.get(destination).get(0);
        currentList.add(dstNode);
    }


    public void print() {
        for (LinkedList<Node> currentList : adjacencyList) {
            for (Node node : currentList) {
                System.out.print(node.getId() + " -> ");
            }
            System.out.println("null");
        }
    }

    public void resetNodesVisited() {
        for (Node node : nodeArrayList) {
            node.unvisit();
        }
    }

    //    DFS
    public void DFS(Node node) {
        this.path.clear();
        this.resetNodesVisited();
        DFSHelper(node);
        System.out.print("The nodes it visited in order to reach the end");
        while(!visitedNodes.isEmpty()){
            int indexOfLastElement = visitedNodes.size() - 1;
            System.out.print(" " + visitedNodes.remove(indexOfLastElement).getId());
        }
        System.out.println("");
        System.out.print("Path is: ");
        while (!path.empty()) {
            reversePath.add(path.pop());
        }
        while (!reversePath.empty()) {
            System.out.print(" " + reversePath.pop().getId());
        }

    }

    public void DFSHelper(Node node) {
        boolean alreadyVisited = false;
        node.visit();
        if (!isFound){
            for( Node nodeLoop : path){
                if (nodeLoop.getId() == node.getId()) {
                    alreadyVisited = true;
                    break;
                }
            }
            if(!alreadyVisited){
                path.add(node);
                visitedNodes.add(node);
            }
        }
        if (node.getX() != endNode.getX() || node.getY() != endNode.getY()) {
            nextNode = (getUnvisitedNode(node));
            if (nextNode == null) {
                path.pop();
                path.pop();
                DFSHelper(path.peek());
            }
            if (nextNode != null){
                DFSHelper(nextNode);
            }
        } else if (node.getX() == endNode.getX() && node.getY() == endNode.getY()) {
            isFound = true;
        }
    }

    private Node getUnvisitedNode(Node node) {
        LinkedList<Node> allNeighbors = adjacencyList.get(node.getId());
        for (Node neighbor : allNeighbors) {
            if (!neighbor.isVisited()) {
                return neighbor;
            }
        }
        return null;
    }
}



