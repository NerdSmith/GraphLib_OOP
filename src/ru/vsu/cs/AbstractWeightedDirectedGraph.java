package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;

public abstract class AbstractWeightedDirectedGraph<V>
        extends AbstractWeightedGraph<V>
        implements WeightedDirectedGraph<V> {


    @Override
    public void addEdge(V vertex1, V vertex2) {
        this.addEdge(vertex1, vertex2, DEFAULT_EDGE_WEIGHT);
    }

    @Override
    public void addEdge(V vertex1, V vertex2, Edge<V> edge) {
        if (getEdge(vertex1, vertex2) == null) {
            edgeCount++;
        }
        addEdgeFromTo(vertex1, vertex2, edge);
    }
}
