package ru.vsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.factory.DirectedRandomGraph;
import ru.vsu.cs.factory.UndirectedRandomGraph;
import ru.vsu.cs.factory.WeightedDirectedRandomGraph;
import ru.vsu.cs.factory.WeightedRandomGraph;

public class RandomGraphTests {
    @Test
    void createRndUndirectedGraphTest() {
        int maxVCount = 10;

        Graph<Integer> graph = new UndirectedRandomGraph().getRndIntGraph(maxVCount);
        Assertions.assertTrue(graph.vertexCount() < maxVCount * 1.5);
    }

    @Test
    void createRndDirectedGraphTest() {
        int maxVCount = 10;

        Graph<Integer> graph = new DirectedRandomGraph().getRndIntGraph(maxVCount);
        Assertions.assertTrue(graph.vertexCount() < maxVCount * 1.5);
    }

    @Test
    void createRndWeightedGraphTest() {
        int maxVCount = 10;

        Graph<Integer> graph = new WeightedRandomGraph().getRndIntGraph(maxVCount);
        Assertions.assertTrue(graph.vertexCount() < maxVCount * 1.5);
    }

    @Test
    void createRndWeightedDirectedGraphTest() {
        int maxVCount = 10;

        Graph<Integer> graph = new WeightedDirectedRandomGraph().getRndIntGraph(maxVCount);
        Assertions.assertTrue(graph.vertexCount() < maxVCount * 1.5);
    }
}
