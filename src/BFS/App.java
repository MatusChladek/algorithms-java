package BFS;

public class App {
    public static void main(String[] args){

        BFS bfs = new BFS();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);
        vertex2.addNeighbourVertex(vertex3);

        // vertex1 is the root
        bfs.bfs(vertex1);


    }
}
