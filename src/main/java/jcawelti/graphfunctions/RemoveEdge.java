package jcawelti.graphfunctions;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
import jcawelti.graphlibrary.Vertex;

import java.util.Scanner;

public class RemoveEdge {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String first, second;
        Vertex v1, v2;
        int weight;

        System.out.println("Original Graph");
        System.out.println();
        graph.displayGraph();
        Scanner kb = new Scanner(System.in);
        System.out.println("Removing an Existing Edge");
        System.out.println();
        System.out.print("Enter vertex 1 name: ");
        first = kb.nextLine();
        try {
            v1 = graph.getVertex(first);
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
            return;
        }
        System.out.print("Enter vertex 2 name: ");
        second = kb.nextLine();
        try {
            v2 = graph.getVertex(second);
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
            return;
        }
        try {
            graph.removeEdge(v1, v2);
        } catch (EdgeException e) {
            System.out.print(e.message());
            return;
        }

        System.out.println();
        System.out.println("Graph After Removal of Edge with Nodes " + v1.getLabel() + " and " + v2.getLabel());
        System.out.println();
        graph.displayGraph();
    }
}
