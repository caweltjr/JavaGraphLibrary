package jcawelti.graphfunctions;

import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;

public class CreateGraph {

    public static void main(String[] args) {
        Graph graph = null;

        System.out.println("Creating Graph From a File");
        System.out.println();
        graph = new GraphFromFile().createGraphFromFile();
        graph.displayGraph();
    }
}
