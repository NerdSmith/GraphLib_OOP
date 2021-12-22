package ru.vsu.cs.edge;

public interface Edge<V> {
    V source();
    V dest();
    double weight();
}
