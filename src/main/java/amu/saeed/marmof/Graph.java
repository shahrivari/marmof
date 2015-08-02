package amu.saeed.marmof;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by saeed on 5/7/15.
 */
public interface Graph {
    boolean areNeighbor(int v, int w);

    public int[] getNeighbors(int v);

    public void printInfo();

    public int vertexCount();

    public int edgeCount();

    public Set<Integer> getVertices();

    public List<Edge> getEdges();

    public int getDegree(int vertex);

    public SubGraphStructure getSubGraph(int[] vertex_set);

    public long getSubGraphAsLong(int[] vertex_set);

    public boolean hasEdge(int v, int w);

    public void printToFile(String path) throws IOException;

    public final static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}