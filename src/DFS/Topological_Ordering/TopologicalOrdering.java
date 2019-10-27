package DFS.Topological_Ordering;

import java.util.Stack;

public class TopologicalOrdering {
    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    // visit all vertices
    public void dfs(Vertex vertex) {
        for (Vertex v : vertex.getNeighbourList()) {
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        stack.push(vertex);
    }

    // getter for stack
    public Stack<Vertex> getStack() {
        return this.stack;
    }
}
