package jcawelti.implementation;

import jcawelti.exception.VertexNotFoundException;
import jcawelti.graphlibrary.Edge;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
import jcawelti.graphlibrary.Vertex;

import java.util.ArrayList;
import java.util.Scanner;

public class DetermineVertexConnectivity {

    public static void main(String[] args) {
        Graph graph = new GraphFromFile().createGraphFromFile();
        String vertex;
        Vertex vertex1;
        ArrayList<Edge> connectedEdges;


        System.out.println("Display Vertex Edge Connectivity");
        System.out.println();
        System.out.println("Original Graph");
        System.out.println();
        graph.displayGraph();
        System.out.println();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter vertex name: ");
        vertex = kb.nextLine();
        try {
            vertex1 = graph.getVertex(vertex);
            connectedEdges = vertex1.getNeighbors();
            for (Edge e : connectedEdges) {
                System.out.println(e.toString());
            }
        } catch (VertexNotFoundException e) {
            System.out.print(e.message());
        }
     }
}
