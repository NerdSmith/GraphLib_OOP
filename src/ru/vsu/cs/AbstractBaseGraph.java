package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBaseGraph<V> implements Graph<V> {
    protected Map<V, Map<V, Edge<V>>> matrix;
    protected int edgeCount = 0;

    @Override
    public int vertexCount() {
        return matrix.size();
    }

    @Override
    public int edgeCount() {
        throw new UnsupportedOperationException();
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

        if (row != null) {
            row.put(vertex2, edge);
        }
        else {
            matrix.put(vertex1, new HashMap<>(Map.of(vertex2, edge)));
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
        if (row != null) {
            row.put(vertex2, null);
            return true;
        }
        else {
            return false;
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
    public Iterable<V> adjacencies(V o) {
        throw new UnsupportedOperationException();
    }

}
