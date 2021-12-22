package ru.vsu.cs;

public interface WeightedGraph<V> extends Graph<V> {

    double weight(V vertex1, V vertex2);

    void addEdge(V vertex1, V vertex2, double weight);
}
