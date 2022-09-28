public class Node {

    private int id;
    private int x;
    private int y;
    boolean visited;

    public Node(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
        visited = false;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }

    public boolean isVisited(){
        return this.visited;
    }
}
