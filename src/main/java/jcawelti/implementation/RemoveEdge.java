package jcawelti.implementation;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
import jcawelti.graphlibrary.Vertex;

import java.util.Scanner;
//********************************************************************
//  This is the implementation of removing an edge from the graph.
//  After removing an edge, must check the 2 vertices that made up that edge
//  to see if either still in use by other edges.  If they aren't, they
//  are 'orphaned' and must be removed from the vertices graph structure.
//  This is done in the Graph class.
//********************************************************************

public class RemoveEdge {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String first, second;
        Vertex v1, v2;

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
