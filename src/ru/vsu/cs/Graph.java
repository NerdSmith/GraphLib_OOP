package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;

public interface Graph<V> {
    int vertexCount();

    int edgeCount();

    void addEdge(V vertex1, V vertex2, Edge<V> edge);

    void addEdge(V vertex1, V vertex2);

    void removeEdge(V vertex1, V vertex2);

    Iterable<V> adjacencies(V v);

    default boolean isAdj(V v1, V v2) {
        for (V adj : adjacencies(v1)) {
            if (adj == v2) {
                return true;
            }
        }
        return false;
    }
}
