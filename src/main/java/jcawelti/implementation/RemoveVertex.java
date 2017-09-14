package jcawelti.implementation;

import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.Edge;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
import jcawelti.graphlibrary.Vertex;

import java.util.ArrayList;
import java.util.Scanner;
//********************************************************************
//  This is the implementation of removing a vertex from the graph.
//  Removing a vertex involves first removing all the edges of the graph
//  associated with that vertex.  After that, must check to see if there
//  are any 'orphaned' vertices, vertices left after the edge they were
//  a part of has been removed, but are not part of any other edges.  These
//  vertices must also be removed as they will no longer be connected to
//  the graph.
//********************************************************************

public class RemoveVertex {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String first;
        Vertex v1;
        ArrayList<Edge> connectedEdges;
        ArrayList<Vertex> orphanedVertices;

        System.out.println("Original Graph");
        System.out.println();
        graph.displayGraph();
        Scanner kb = new Scanner(System.in);
        System.out.println("Removing an Existing Vertex");
        System.out.println();
        System.out.print("Enter vertex to remove name: ");
        first = kb.nextLine();
        try {
            v1 = graph.getVertex(first);
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
            return;
        }
        // get all the edges that this vertex is part of
        connectedEdges = v1.getNeighbors();
        System.out.println("Removing the Following Edges from Graph");
        for (Edge e : connectedEdges) {
            System.out.println();
            System.out.println("Removing Edge: " + e.toString());
            graph.getEdges().remove(e.hashCode(), e); // remove all the edges associated with this vertex
            if(e.getOne().getNeighbors().size() == 0){ // vertex of this edge has no neighbors;
                graph.getVertices().remove(e.getOne().hashCode(), e.getOne()); // remove from vertices structure
            }
            if(e.getTwo().getNeighbors().size() == 0){ // vertex of this edge has no neighbors;
                graph.getVertices().remove(e.getTwo().hashCode(), e.getTwo()); // remove from vertices structure
            }
        }
        graph.getVertices().remove(v1.hashCode(),v1); // remove the selected vertex from the vertices structure
        System.out.println("New Graph with Vertex " + v1.getLabel() + " Removed");
        System.out.println();
        graph.displayGraph();
    }
}
