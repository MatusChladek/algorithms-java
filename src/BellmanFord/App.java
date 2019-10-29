package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        List<Vertex> vertexList = new ArrayList<Vertex>();

        vertexList.add(new Vertex("a"));
        vertexList.add(new Vertex("b"));
        vertexList.add(new Vertex("c"));

        List<Edge> edgeList = new ArrayList<Edge>();

        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(-1, vertexList.get(0), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));

        BellmanFord bellmanFord = new BellmanFord(edgeList, vertexList);

        bellmanFord.bellmanFord(vertexList.get(0));
        bellmanFord.shortestPathTo(vertexList.get(2));

    }
}