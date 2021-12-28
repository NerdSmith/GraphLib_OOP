package ru.vsu.cs.factory;

import ru.vsu.cs.BaseWeightedGraph;
import ru.vsu.cs.Graph;

public class WeightedRandomGraph extends RandomGraph {
    @Override
    public Graph<Integer> createEmptyIntGraph(int vertexCount) {
        return new BaseWeightedGraph<>();
    }
}
