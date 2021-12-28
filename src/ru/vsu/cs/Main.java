package ru.vsu.cs;

import ru.vsu.cs.factory.DirectedRandomGraph;
import ru.vsu.cs.factory.UndirectedRandomGraph;
import ru.vsu.cs.factory.WeightedDirectedRandomGraph;
import ru.vsu.cs.factory.WeightedRandomGraph;
import ru.vsu.cs.util.GraphAlgorithms;

public class Main {

    public static void main(String[] args) {
//        DirectedGraph<Integer> graph = new BaseDirectedGraph<>();
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(4, 3);
//
//        System.out.println(graph);
//
//        WeightedDirectedGraph<String> graph = new BaseWeightedDirectedGraph<>();
//
//        graph.addEdge("Google", "Facebook");
//        graph.addEdge("Google", "Microsoft");
//        graph.addEdge("Facebook", "Mega");
//        graph.addEdge("Microsoft", "Google");
//
//        System.out.println(graph.adjacencies("Google"));

        Graph<Integer> graph = new WeightedDirectedRandomGraph().getRndIntGraph(10);


        System.out.println(graph);

//        System.out.println(graph.edgeCount());
//        graph.removeEdge(3, 4);
//        System.out.println(graph);
//        graph.addEdge(4, 3);
//        System.out.println(graph.edgeCount());
//        System.out.println("_____________");
//        for (Integer v: graph.adjacencies(1)) {
//            System.out.println(v);
//        }
    }
}
