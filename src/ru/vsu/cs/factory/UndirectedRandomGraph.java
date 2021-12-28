package ru.vsu.cs.factory;

import ru.vsu.cs.Graph;
import ru.vsu.cs.UndirectedGraph;

public class UndirectedRandomGraph extends RandomGraph {
    @Override
    public Graph<Integer> createEmptyIntGraph(int vertexCount) {
        return new UndirectedGraph<>();
    }
}
