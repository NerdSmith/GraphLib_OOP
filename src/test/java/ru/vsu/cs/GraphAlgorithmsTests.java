package ru.vsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.util.GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class GraphAlgorithmsTests {
    @Test
    void dfsTest() {
        Graph<Integer> graphInt = new UndirectedGraph<>();
        graphInt.addEdge(0, 1);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 0);

        List<Integer> storage = new ArrayList<>();

        GraphAlgorithms.depthFirstSearch(graphInt, 0, storage::add);

        assertThat(storage, contains(0, 2, 1));
    }

    @Test
    void bfsTest() {
        Graph<Integer> graphInt = new UndirectedGraph<>();
        graphInt.addEdge(0, 1);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 0);

        List<Integer> storage = new ArrayList<>();

        GraphAlgorithms.breadthFirstSearch(graphInt, 0, storage::add);

        assertThat(storage, contains(0, 1, 2));
    }

    @Test
    void isConnectedTest() {
        Graph<Integer> connectedGraphInt = new UndirectedGraph<>();
        connectedGraphInt.addEdge(0, 1);
        connectedGraphInt.addEdge(1, 2);
        connectedGraphInt.addEdge(2, 0);

        Assertions.assertTrue(GraphAlgorithms.isConnected(connectedGraphInt));
    }

    @Test
    void isNotConnectedTest() {
        Graph<Integer> notConnectedGraphInt = new UndirectedGraph<>();
        notConnectedGraphInt.addEdge(0, 1);
        notConnectedGraphInt.addEdge(1, 2);
        notConnectedGraphInt.addEdge(2, 0);

        notConnectedGraphInt.removeEdge(0, 1);
        notConnectedGraphInt.removeEdge(0, 2);

        Assertions.assertFalse(GraphAlgorithms.isConnected(notConnectedGraphInt));
    }
}
