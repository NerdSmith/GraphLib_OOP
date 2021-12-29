package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;
import ru.vsu.cs.edge.WeightedEdge;

public class BaseWeightedDirectedGraph<V>
        extends AbstractWeightedDirectedGraph<V>
        implements WeightedDirectedGraph<V> {

    @Override
    public double weight(V vertex1, V vertex2) {
        return getEdge(vertex1, vertex2).weight();
    }

    @Override
    public void addEdge(V vertex1, V vertex2, double weight) {
        Edge<V> weightedEdge = new WeightedEdge<>(weight);
        addEdge(vertex1, vertex2, weightedEdge);
    }
}
