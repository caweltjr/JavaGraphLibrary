package jcawelti.implementation;

import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;
//********************************************************************
//  This is the implementation of determining creating the graph.
//********************************************************************
public class CreateGraph {

    public static void main(String[] args) {
        Graph graph = null;

        System.out.println("Creating Graph From a File");
        System.out.println();
        graph = new GraphFromFile().createGraphFromFile();
        graph.displayGraph();
    }
}
