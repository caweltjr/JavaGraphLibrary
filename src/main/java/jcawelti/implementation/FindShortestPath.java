package jcawelti.implementation;

import jcawelti.exception.PathNotFoundException;
import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.*;

import java.util.Scanner;

public class FindShortestPath {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String first, second;
        Vertex from;
        Vertex to;
        ShortestPath sp = null;

        System.out.println("Original Graph");
        System.out.println();
        graph.displayGraph();
        Scanner kb = new Scanner(System.in);
        System.out.println("Finding Shortest Path");
        System.out.println();
        System.out.print("Enter From vertex name: ");
        first = kb.nextLine();
        try {
            from = graph.getVertex(first.toUpperCase());
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
            return;
        }
        System.out.print("Enter To vertex name: ");
        second = kb.nextLine();
        try {
            to = graph.getVertex(second.toUpperCase());
        } catch (VertexNotFoundException e) {
            System.out.println(e.message());
            return;
        }
         try {
            sp = new DijkstraAlgorithm(graph).calculateShortestPath(from, to);
        } catch (PathNotFoundException e) {
             System.out.println(e.message());
            return;
        }
        System.out.println(sp.toString());
    }

}
