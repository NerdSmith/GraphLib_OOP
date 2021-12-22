package ru.vsu.cs;

import ru.vsu.cs.edge.BaseEdge;

import java.util.HashMap;

public class UndirectedGraph<V> extends AbstractBaseGraph<V> {
    public UndirectedGraph() {
        this.matrix = new HashMap<>();
    }

    @Override
    public void addEdge(V vertex1, V vertex2) {
        BaseEdge<V> baseEdge = new BaseEdge<>();
        addEdge(vertex1, vertex2, baseEdge);
    }

    @Override
    public Iterable<V> adjacencies(V o) {
        return super.adjacencies(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V vertex: matrix.keySet()) {
            sb.append(
                    String.format("%s connected to ", vertex)
            );
            for (V connectedVertex: matrix.get(vertex).keySet()) {
                if (matrix.get(vertex).get(connectedVertex) != null)
                    sb.append(String.format("%s ", connectedVertex));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
