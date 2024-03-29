package BellmanFordAlgorithm;

import java.util.List;

public class BellmanFord {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

        sourceVertex.setMinDistance(0);

        for (int i = 0; i < vertexList.size() - 1; i++) { // V-1 iterations
            for (Edge edge : edgeList) {

                if (edge.getStartVertex().getMinDistance() == Integer.MAX_VALUE) {
                    continue;
                }

                int newDistance = edge.getStartVertex().getMinDistance() + edge.getWeight();

                if (newDistance < edge.getTargetVertex().getMinDistance()) {
                    edge.getTargetVertex().setMinDistance(newDistance);
                    edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
                }
            }
        }

        for (Edge edge : edgeList) { // Vth iteration
            if (edge.getStartVertex().getMinDistance() != Integer.MAX_VALUE) {
                if (hasCycle(edge)) {
                    System.out.println("Negative edge weight cycles detected!");
                    return;
                }
            }
        }

        if (targetVertex.getMinDistance() != Integer.MAX_VALUE) {
            System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getMinDistance());

            Vertex actualVErtex = targetVertex;
            while (actualVErtex.getPreviousVertex() != null) {
                System.out.print(actualVErtex + "-");
                actualVErtex = actualVErtex.getPreviousVertex();
            }
        } else {
            System.out.println("There is no path from source to target...");
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.getTargetVertex().getMinDistance() > edge.getStartVertex().getMinDistance() + edge.getWeight();
    }
}
