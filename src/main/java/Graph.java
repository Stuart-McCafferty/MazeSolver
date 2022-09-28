import java.util.*;

public class Graph {

    ArrayList<LinkedList<Node>> adjacencyList;
    Stack<Node> path;
    ArrayList<Node> nodeArrayList;
    private Node startNode;
    private Node endNode;
    public Graph(ArrayList<Node> nodeArrayList, Node startNode, Node endNode){
        adjacencyList = new ArrayList<>();
        path = new Stack<>();
        this.nodeArrayList = nodeArrayList;
        this.startNode  = startNode;
        this.endNode = endNode;
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
                if ((nodetwo.getX() == tempX - 1) && (nodetwo.getY() == tempY)){ //left
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getX() == tempX + 1) && (nodetwo.getY() == tempY)){ //right
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getY() == tempY - 1) && (nodetwo.getX() == tempX)){ //down
                    addEdge(nodeOne.getId(), nodetwo.getId());
                }
                if ((nodetwo.getY() == tempY + 1) && (nodetwo.getX() == tempX)){ //up
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
            System.out.println("null");
        }
    }

    public void resetNodesVisited(){
        for(Node node : nodeArrayList){
            node.unvisit();
        }
    }

//    DFS
    public void DFS(Node node) {
        node.visit();
        System.out.println(node.getId() + " Visited ");

        LinkedList<Node> allNeighbors = adjacencyList.get(node.getId());
        if (allNeighbors == null)
            return;


        for (Node neighbor : allNeighbors) {
            System.out.println(allNeighbors);
            if (!neighbor.isVisited()) {
                System.out.println("Calling DFS");
                DFS(neighbor);
            }
        }
    }
}
