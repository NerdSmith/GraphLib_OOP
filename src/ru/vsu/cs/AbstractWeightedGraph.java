package ru.vsu.cs;


import ru.vsu.cs.edge.Edge;

public abstract class AbstractWeightedGraph<V> extends AbstractBaseGraph<V> implements WeightedGraph<V> {
    protected double DEFAULT_EDGE_WEIGHT = 1.0;


    @Override
    public int edgeCount() {
        return edgeCount;
    }

    public void setDefaultWeight(double weight) {
        this.DEFAULT_EDGE_WEIGHT = weight;
    }

    @Override
    public void addEdge(V vertex1, V vertex2) {
        this.addEdge(vertex1, vertex2, DEFAULT_EDGE_WEIGHT);
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
