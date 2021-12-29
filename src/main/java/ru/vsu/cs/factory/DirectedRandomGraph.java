package ru.vsu.cs.factory;

import ru.vsu.cs.BaseDirectedGraph;
import ru.vsu.cs.Graph;

public class DirectedRandomGraph extends RandomGraph {
    @Override
    public Graph<Integer> createEmptyIntGraph(int vertexCount) {
        return new BaseDirectedGraph<>();
    }
}
