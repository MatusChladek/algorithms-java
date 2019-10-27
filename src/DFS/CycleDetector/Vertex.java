package DFS.CycleDetector;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private boolean BeingVisited;
    private List<Vertex> adjacenciesList;

    public Vertex(String name){
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Vertex vertex){
        this.adjacenciesList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return BeingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        BeingVisited = beingVisited;
    }

    public List<Vertex> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Vertex> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }
}
