package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;

import java.util.*;

public abstract class AbstractBaseGraph<V> implements Graph<V> {
    protected Map<V, Map<V, Edge<V>>> matrix;
    protected int edgeCount = 0;

    public AbstractBaseGraph() {
        this.matrix = new HashMap<>();
    }

    @Override
    public int vertexCount() {
        return matrix.size();
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public void addEdge(V vertex1, V vertex2, Edge<V> edge) {
        if (getEdge(vertex1, vertex2) == null) {
            edgeCount++;
        }
        addEdgeFromTo(vertex1, vertex2, edge);
        addEdgeFromTo(vertex2, vertex1, edge);
    }

    protected void addEdgeFromTo(V vertex1, V vertex2, Edge<V> edge) {
        Map<V, Edge<V>> row = matrix.get(vertex1);

//        matrix.computeIfAbsent(vertex1, newV -> new HashMap<>()).put(vertex2, edge);
        if (row == null) {
            matrix.put(vertex1, new HashMap<>(Map.of(vertex2, edge)));
        }
        else {
            row.put(vertex2, edge);
        }
    }

    @Override
    public void removeEdge(V vertex1, V vertex2) {
        boolean operationRes;
        operationRes = removeEdgeFromTo(vertex1, vertex2);
        operationRes &= removeEdgeFromTo(vertex2, vertex1);
        if (operationRes) {
            edgeCount--;
        }
    }

    protected boolean removeEdgeFromTo(V vertex1, V vertex2) {
        Map<V, Edge<V>> row = matrix.get(vertex1);
        if (row == null) {
            return false;
        }
        else {
            row.put(vertex2, null);
            return true;

        }
    }

    protected Edge<V> getEdge(V vertex1, V vertex2) {
        Map<V, Edge<V>> row = matrix.get(vertex1);
        if (row == null) {
            return null;
        }
        else {
            return row.get(vertex2);
        }
    }

    @Override
    public Set<V> vertices() {
        return matrix.keySet();
    }

    @Override
    public Iterable<V> adjacencies(V v) {
        Map<V, Edge<V>> adj = matrix.get(v);
        if (adj == null) {
            return new HashSet<>();
        }
        Set<V> currAdjV = new HashSet<>();
        for (V vertex: adj.keySet()) {
            if (adj.get(vertex) != null) {
                currAdjV.add(vertex);
            }
        }
        return currAdjV;
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
