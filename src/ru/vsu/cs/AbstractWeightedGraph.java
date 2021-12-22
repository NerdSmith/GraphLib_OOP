package ru.vsu.cs;


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
}
