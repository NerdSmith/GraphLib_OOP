package ru.vsu.cs;

import ru.vsu.cs.edge.BaseEdge;

public class UndirectedGraph<V> extends AbstractBaseGraph<V> {

    @Override
    public void addEdge(V vertex1, V vertex2) {
        BaseEdge<V> baseEdge = new BaseEdge<>();
        addEdge(vertex1, vertex2, baseEdge);
    }
}
