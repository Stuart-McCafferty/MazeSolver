import java.util.*;

public class Graph {

    ArrayList<LinkedList<Node>> adjacencyList;
    Stack<Node> path;
    ArrayList<Node> nodeArrayList;
    private Node startNode;
    private Node endNode;
    private Node nextNode;
    private Boolean isFound;
    private Boolean allVisited;

    public Graph(ArrayList<Node> nodeArrayList, Node startNode, Node endNode) {
        adjacencyList = new ArrayList<>();
        path = new Stack<>();
        this.nodeArrayList = nodeArrayList;
        this.startNode = startNode;
        this.endNode = endNode;
        isFound = Boolean.FALSE;
        allVisited = Boolean.FALSE;
        nextNode = new Node();
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
        while (!path.empty()) {
            System.out.println(path.pop().getId());
        }
    }

    public void DFSHelper(Node node) {
        node.visit();
        if (!isFound){
            path.add(node);
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
        //PROBLEM
        //Want path to show  the route from start to end
        // At the moment it shows every node is visits before the ned
        // I want to be able to take (pop()?) nodes off when it "backtracks"
        //May need to redesign the search as a stack
        //pushes node onto stack - checks if node = endNode
        //If not add one of its unvisited nodes
        //if all neighbours are visited pop() node (repeat)

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



