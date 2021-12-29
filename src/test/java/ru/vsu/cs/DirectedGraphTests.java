package ru.vsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class DirectedGraphTests {
    @Test
    void intGraphTest() {
        Graph<Integer> directedGraphInt = new BaseDirectedGraph<>();
        directedGraphInt.addEdge(0, 1);
        directedGraphInt.addEdge(1, 2);
        directedGraphInt.addEdge(2, 0);

        Assertions.assertEquals(directedGraphInt.adjacencies(0), Set.of(1));
        Assertions.assertEquals(directedGraphInt.adjacencies(1), Set.of(2));
        Assertions.assertEquals(directedGraphInt.adjacencies(2), Set.of(0));

        Assertions.assertEquals(directedGraphInt.edgeCount(), 3);
    }

    @Test
    void strGraphTest() {
        Graph<String> directedGraphStr = new BaseDirectedGraph<>();
        directedGraphStr.addEdge("one", "two");
        directedGraphStr.addEdge("two", "three");
        directedGraphStr.addEdge("three", "one");

        Assertions.assertEquals(directedGraphStr.adjacencies("one"), Set.of("two"));
        Assertions.assertEquals(directedGraphStr.adjacencies("two"), Set.of("three"));
        Assertions.assertEquals(directedGraphStr.adjacencies("three"), Set.of("one"));

        Assertions.assertEquals(directedGraphStr.edgeCount(), 3);
    }

    @Test
    void edgeRemoveTest() {
        Graph<Integer> directedGraphInt = new BaseDirectedGraph<>();
        directedGraphInt.addEdge(0, 1);
        directedGraphInt.addEdge(1, 2);
        directedGraphInt.addEdge(2, 0);

        directedGraphInt.removeEdge(0, 1);

        Assertions.assertEquals(directedGraphInt.adjacencies(0), Set.of());
        Assertions.assertEquals(directedGraphInt.adjacencies(1), Set.of(2));
        Assertions.assertEquals(directedGraphInt.adjacencies(2), Set.of(0));

        Assertions.assertEquals(directedGraphInt.edgeCount(), 2);
    }
}
