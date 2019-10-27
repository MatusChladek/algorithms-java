package DFS.CycleDetector;

import java.util.List;

public class CycleDetection {
    public void detectCycle(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                dfs(v);
            }

        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);
        System.out.println("DFS on vertex " + vertex);

        for (Vertex v : vertex.getAdjacenciesList()) {
            System.out.println("Visiting neighbours of vertex " + v);

            if (!v.isBeingVisited()) {
                System.out.println("There is a cycle!!!");
                return;
            }

            if (!v.isVisited()) {
                System.out.println("Visiting vertex " + v + "recursively");
                v.setVisited(true);
                dfs(v);
            }
        }

        System.out.println("Set vertex "+ vertex + " BeingVisited and Visited");
        vertex.setBeingVisited(true);
        vertex.setVisited(true);
    }
}
