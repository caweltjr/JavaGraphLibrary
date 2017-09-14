package jcawelti.implementation;

import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.Edge;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
import jcawelti.graphlibrary.Vertex;

import java.util.ArrayList;
import java.util.Scanner;
//********************************************************************
//  This is the implementation of retrieving the edges for a given
//  vertex.
//********************************************************************

public class RetrieveEdgesForVertex {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String first;
        Vertex v1;
        ArrayList<Edge> connectedEdges;

        System.out.println("Original Graph");
        System.out.println();
        graph.displayGraph();
        Scanner kb = new Scanner(System.in);
        System.out.println("Retrieving Edges for an Existing Vertex");
        System.out.println();
        System.out.print("Enter vertex: ");
        first = kb.nextLine();
        try {
            v1 = graph.getVertex(first);
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
            return;
        }
        // get all the edges that this vertex is part of
        connectedEdges = v1.getNeighbors();
        System.out.println("The Following Edges Contain Vertex " + v1.getLabel());
        System.out.println();
        for (Edge e : connectedEdges) {
            System.out.println("Edge: " + e.toString());
        }
    }
}
