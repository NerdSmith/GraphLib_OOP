package ru.vsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class WeightedGraphTests {
    @Test
    void intGraphTest() {
        WeightedGraph<Integer> weightedGraphInt = new BaseWeightedGraph<>();
        weightedGraphInt.addEdge(0, 1, 2);
        weightedGraphInt.addEdge(1, 2, 3);
        weightedGraphInt.addEdge(2, 0, 4);

        Assertions.assertEquals(weightedGraphInt.adjacencies(0), Set.of(1, 2));
        Assertions.assertEquals(weightedGraphInt.adjacencies(1), Set.of(0, 2));
        Assertions.assertEquals(weightedGraphInt.adjacencies(2), Set.of(0, 1));

        Assertions.assertEquals(weightedGraphInt.edgeCount(), 3);
    }

    @Test
    void strGraphTest() {
        WeightedGraph<String> graphStr = new BaseWeightedGraph<>();
        graphStr.addEdge("one", "two");
        graphStr.addEdge("two", "three");
        graphStr.addEdge("three", "one");

        Assertions.assertEquals(graphStr.adjacencies("one"), Set.of("two", "three"));
        Assertions.assertEquals(graphStr.adjacencies("two"), Set.of("one", "three"));
        Assertions.assertEquals(graphStr.adjacencies("three"), Set.of("one", "two"));

        Assertions.assertEquals(graphStr.edgeCount(), 3);
    }

    @Test
    void edgeRemoveTest() {
        WeightedGraph<Integer> graphInt = new BaseWeightedGraph<>();
        graphInt.addEdge(0, 1);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 0);

        graphInt.removeEdge(0, 1);

        Assertions.assertEquals(graphInt.adjacencies(0), Set.of(2));
        Assertions.assertEquals(graphInt.adjacencies(1), Set.of(2));
        Assertions.assertEquals(graphInt.adjacencies(2), Set.of(0, 1));

        Assertions.assertEquals(graphInt.edgeCount(), 2);
    }

    @Test
    void getWeightTest() {
        WeightedGraph<Integer> weightedGraphInt = new BaseWeightedGraph<>();

        double defaultWeight = 10;
        weightedGraphInt.setDefaultWeight(defaultWeight);

        weightedGraphInt.addEdge(0, 1, 2);
        weightedGraphInt.addEdge(1, 2, 3);
        weightedGraphInt.addEdge(2, 0);

        Assertions.assertEquals(weightedGraphInt.weight(0, 1), 2);
        Assertions.assertEquals(weightedGraphInt.weight(1, 2), 3);
        Assertions.assertEquals(weightedGraphInt.weight(2, 0), defaultWeight);

        Assertions.assertEquals(weightedGraphInt.edgeCount(), 3);
    }
}
