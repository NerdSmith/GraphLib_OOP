package ru.vsu.cs.factory;

import ru.vsu.cs.Graph;
import ru.vsu.cs.WeightedGraph;
import ru.vsu.cs.edge.WeightedEdge;

public abstract class RandomGraph {

    public Graph<Integer> getRndIntGraph(int maxVertexCount) {
        Graph<Integer> graph = createEmptyIntGraph(maxVertexCount);
        for (int i = 0; i < RndUtils.randInt(maxVertexCount, (int) (maxVertexCount * 1.5)); i++) {
            if (graph instanceof WeightedGraph) {
                graph.addEdge(
                        RndUtils.randInt(0, maxVertexCount),
                        RndUtils.randInt(0, maxVertexCount),
                        new WeightedEdge<>(RndUtils.getRnd().nextInt(100))
                );
            }
            else {
                graph.addEdge(
                        RndUtils.randInt(0, maxVertexCount),
                        RndUtils.randInt(0, maxVertexCount)
                );
            }
        }
        return graph;
    }

    public abstract Graph<Integer> createEmptyIntGraph(int vertexCount);
}
