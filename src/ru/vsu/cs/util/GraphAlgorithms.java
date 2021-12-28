package ru.vsu.cs.util;

import ru.vsu.cs.Graph;

import java.util.*;
import java.util.function.Consumer;

public class GraphAlgorithms {

    public static <V> boolean isConnected(Graph<V> graph){
        int vertices = graph.vertexCount();

        Set<V> visited = new HashSet<>();

        for (V currV: graph.vertices()) {
            depthFirstSearch(graph, currV, visited::add);
        }

        return visited.size() == vertices;
    }

    public static <V> void depthFirstSearch(Graph<V> graph, V from, Consumer<V> visitor) {
        Set<V> visited = new HashSet<>();
        Stack<V> stack = new Stack<>();
        stack.push(from);
        visited.add(from);
        while (!stack.empty()) {
            V curr = stack.pop();
            visitor.accept(curr);
            for (V v : graph.adjacencies(curr)) {
                if (!visited.contains(v)) {
                    stack.push(v);
                    visited.add(v);
                }
            }
        }
    }

    public static <V> void breadthFirstSearch(Graph<V> graph, V from, Consumer<V> visitor) {
        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(from);
        visited.add(from);
        while (queue.size() > 0) {
            V curr = queue.remove();
            visitor.accept(curr);
            for (V v : graph.adjacencies(curr)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }
}
