package ru.vsu.cs;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new BaseWeightedGraph<>();
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        System.out.println(graph.edgeCount());
        graph.removeEdge(3, 4);
        System.out.println(graph);
        graph.addEdge(4, 3);
        System.out.println(graph.edgeCount());
    }
}
