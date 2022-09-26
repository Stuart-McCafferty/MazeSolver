import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {

    ArrayList<LinkedList<Node>> adjacencyList;
    ArrayList<Node> nodeArrayList;
    //start node
    //end node
    public Graph(ArrayList<Node> nodeArrayList){
        this.nodeArrayList = nodeArrayList;
        adjacencyList = new ArrayList<>();
    }

    public int getAdjacencyListSize() {
        return adjacencyList.size();
    }

    public int getNodeArrayListSize() {
        return nodeArrayList.size();
    }

    public void addNodes(){
        for (Node node : nodeArrayList) {
            LinkedList<Node> currentList = new LinkedList<>();
            currentList.add(node);
            adjacencyList.add(currentList);
        }
    }

    public void findEdges(){
        for (Node nodeOne : nodeArrayList){
            int tempX = nodeOne.getX();
            int tempY = nodeOne.getY();
            for (Node nodetwo: nodeArrayList){
                if ((nodetwo.getX() == tempX - 1) && (nodetwo.getY() == tempY)){
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getX() == tempX + 1) && (nodetwo.getY() == tempY)){
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getY() == tempY - 1) && (nodetwo.getX() == tempX)){
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getY() == tempY + 1) && (nodetwo.getX() == tempX)){
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
            }
        }
    }

    public void addEdge(int source, int destination){
        LinkedList<Node> currentList = adjacencyList.get(source);
        Node dstNode = adjacencyList.get(destination).get(0);
        currentList.add(dstNode);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentList = adjacencyList.get(src);
        Node dstNode = adjacencyList.get(dst).get(0);

        for(Node node : currentList) {
            if(node == dstNode) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for(LinkedList<Node> currentList : adjacencyList) {
            for(Node node : currentList) {
                System.out.print(node.getId() + " -> ");
            }
            System.out.println();
        }
    }

    //DFS
    public void DFS(int v){
        boolean[] isVisited = new boolean[vertices];

        DFSHelper(v, isVisited);
    }

    public void DFSHelper(int v, boolean[] isVisited){
        isVisited[v] = true;

        }





}
