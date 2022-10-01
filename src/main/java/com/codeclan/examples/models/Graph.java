package com.codeclan.examples.models;

import java.util.*;



public class Graph {

    private ArrayList<LinkedList<Node>> adjacencyList;

    private Stack<Node> path;

    private Node startNode;

    private Node endNode;

    private Node nextNode;

    private Boolean isFound;

    private List<Node> nodeArrayList;

    private Stack<Node> visitedNodes;

    private ArrayList<Stack<Node>> result;


    public Graph(List<Node> nodeArrayList, Node startNode, Node endNode) {
        adjacencyList = new ArrayList<>();
        path = new Stack<>();
        this.nodeArrayList = nodeArrayList;
        this.endNode = endNode;
        this.startNode = startNode;
        isFound = Boolean.FALSE;
        nextNode = new Node();
        visitedNodes = new Stack<>();
        result = new ArrayList<Stack<Node>>();
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
    public ArrayList<Stack<Node>> DFS(Node node) {
        this.path.clear();
        this.resetNodesVisited();
        DFSHelper(node);
        this.resetNodesVisited();
        this.result.add(path);
        this.result.add(visitedNodes);
        return result;
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



