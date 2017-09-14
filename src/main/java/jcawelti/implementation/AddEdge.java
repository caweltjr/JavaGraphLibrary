package jcawelti.implementation;

import jcawelti.exception.EdgeException;
import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;

import java.util.Scanner;

public class AddEdge {

    public static void main(String[] args) {
        String first, second;
        int weight;

        Scanner kb = new Scanner(System.in);
        System.out.println("Adding a New Edge");
        System.out.println();
        System.out.print("Enter vertex 1 name: ");
        first = kb.nextLine();
        System.out.print("Enter vertex 2 name: ");
        second = kb.nextLine();
        System.out.print("Enter weight as an Integer: ");
        weight = Integer.parseInt(kb.nextLine());

        Graph graph = new GraphFromFile().createGraphFromFile();
        try {
            graph.addEdge(first, second, weight);
        } catch (EdgeException e) {
            System.out.println(e.message());
        }
        graph.displayGraph();
    }
}
