package ru.vsu.cs.factory;

import ru.vsu.cs.BaseWeightedDirectedGraph;
import ru.vsu.cs.Graph;

public class WeightedDirectedRandomGraph extends RandomGraph {
    @Override
    public Graph<Integer> createEmptyIntGraph(int vertexCount) {
        return new BaseWeightedDirectedGraph<>();
    }
}
