package amu.saeed.marmof;

import amu.saeed.marmof.Graph.Edge;

import java.util.Collections;
import java.util.List;

public class RandomGraphGenerator {
    private final static int QE_COUNT = 1;

    public static Graph generateRandomGraph(Graph graph) {
        /**
         * ALGORITHM:------------------------------------
         *  for QE times do :
         *
         * 		Select two edges having no common vertices:
         * 		(A->B),
         * 		(C->D)
         * 		------
         * 		result:
         * 		(A->D),
         * 		(C->B)
         * -----------------------------------------------
         */
        List<Edge> edges = graph.getEdges();
        Collections.shuffle(edges);
        for (int i = 0; i < QE_COUNT * edges.size(); i += 2)
            switchTwoEdge(edges, i, i + 1);
        return HashGraph.buildFromEdges(edges);
    }

    private static void switchTwoEdge(List<Edge> edges, int i, int j) {
        Edge edge1 = edges.get(i);
        Edge edge2 = edges.get(j);
        int a = edge1.src;
        int b = edge1.dest;
        int c = edge2.src;
        int d = edge2.dest;
        if (a == c) {
            /**
             * a-->b
             * [a]-->d
             */
            Edge e2 = new Edge(b, d);
            edges.set(j, e2);
        } else if (a == d) {
            /**
             * a-->b
             * c-->[a]
             */
            Edge e2 = new Edge(c, b);
            edges.set(j, e2);
        } else if (b == c) {
            /**
             * a-->b
             * [b]-->d
             */
            Edge e1 = new Edge(a, d);
            edges.set(i, e1);
        } else if (b == d) {
            /**
             * a-->b
             * c-->[b]
             */
            Edge e1 = new Edge(a, c);
            edges.set(i, e1);
        } else {
            /**
             * a-->b
             * c-->d
             */
            Edge e1 = new Edge(a, d);
            Edge e2 = new Edge(c, b);
            edges.set(i, e1);
            edges.set(j, e2);
        }
    }
}

