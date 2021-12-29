package ru.vsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class UndirectedGraphTests {
    @Test
    void intGraphTest() {
        Graph<Integer> graphInt = new UndirectedGraph<>();
        graphInt.addEdge(0, 1);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 0);

        Assertions.assertEquals(graphInt.adjacencies(0), Set.of(1, 2));
        Assertions.assertEquals(graphInt.adjacencies(1), Set.of(0, 2));
        Assertions.assertEquals(graphInt.adjacencies(2), Set.of(0, 1));

        Assertions.assertEquals(graphInt.edgeCount(), 3);
    }

    @Test
    void strGraphTest() {
        Graph<String> graphStr = new UndirectedGraph<>();
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
        Graph<Integer> graphInt = new UndirectedGraph<>();
        graphInt.addEdge(0, 1);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 0);

        graphInt.removeEdge(0, 1);

        Assertions.assertEquals(graphInt.adjacencies(0), Set.of(2));
        Assertions.assertEquals(graphInt.adjacencies(1), Set.of(2));
        Assertions.assertEquals(graphInt.adjacencies(2), Set.of(0, 1));

        Assertions.assertEquals(graphInt.edgeCount(), 2);
    }
}
