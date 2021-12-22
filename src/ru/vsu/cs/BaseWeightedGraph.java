package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;
import ru.vsu.cs.edge.WeightedEdge;

import java.util.HashMap;

public class BaseWeightedGraph<V> extends AbstractWeightedGraph<V> implements WeightedGraph<V> {

    public BaseWeightedGraph() {
        this.matrix = new HashMap<>();
    }

    @Override
    public void addEdge(V vertex1, V vertex2, double weight) {
        Edge<V> weightedEdge = new WeightedEdge<>(weight);
        addEdge(vertex1, vertex2, weightedEdge);
    }

    @Override
    public double weight(V vertex1, V vertex2) {
        return getEdge(vertex1, vertex2).weight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V vertex: matrix.keySet()) {
            sb.append(
                    String.format("%s connected to ", vertex)
            );
            for (V connectedVertex: matrix.get(vertex).keySet()) {
                Edge<V> currEdge = matrix.get(vertex).get(connectedVertex);
                if (currEdge != null)
                    sb.append(String.format("%s{%s} ", connectedVertex, currEdge.weight()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
