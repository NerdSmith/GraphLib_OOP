package ru.vsu.cs;

import ru.vsu.cs.edge.Edge;

public abstract class AbstractDirectedGraph<V> extends AbstractBaseGraph<V> implements DirectedGraph<V> {

    @Override
    public void addEdge(V vertex1, V vertex2, Edge<V> edge) {
        if (getEdge(vertex1, vertex2) == null) {
            edgeCount++;
        }
        addEdgeFromTo(vertex1, vertex2, edge);
    }

    @Override
    public void removeEdge(V vertex1, V vertex2) {
        boolean operationRes;
        operationRes = removeEdgeFromTo(vertex1, vertex2);
        if (operationRes) {
            edgeCount--;
        }
    }
}
