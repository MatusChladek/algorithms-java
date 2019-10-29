package BellmanFord;

import java.util.List;

public class BellmanFord {
    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) { // V-1 iterations we relax all the edges
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        for (int i = 0; i < vertexList.size() - 1; ++i) {
            for (Edge edge : edgeList) {
                Vertex start = edge.getStartVertex();
                Vertex target = edge.getTargetVertex();

                if (start.getDistance() == Double.MAX_VALUE) {
                    continue;
                }

                double newDistance = start.getDistance() + edge.getWeight();

                if (newDistance < target.getDistance()) {
                    target.setDistance(newDistance);
                    target.setPreviousVertex(start);
                }
            }
            for (Edge edge : edgeList) { // Vth iteration
                if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {

                    if (hasCycle(edge)) {
                        System.out.println("There has been a negative cycle detected..");
                        return;
                    }
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public void shortestPathTo(Vertex targetVertex){
        if(targetVertex.getDistance() == Double.MAX_VALUE){
            System.out.println("There is no path from source to target");
        }
        Vertex actualVertex = targetVertex;

        while(actualVertex.getPreviousVertex() != null){
            System.out.println(actualVertex+" - ");
            actualVertex = actualVertex.getPreviousVertex();
        }
    }
}
