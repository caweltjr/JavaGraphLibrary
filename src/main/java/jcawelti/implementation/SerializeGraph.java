package jcawelti.implementation;

import jcawelti.graphlibrary.Graph;
import jcawelti.graphlibrary.GraphFromFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeGraph {

    public static void main(String[] args) {
        System.out.println("Serializing Graph To a File");
        System.out.println();
        Graph graph = new GraphFromFile().createGraphFromFile();
        graph.displayGraph();
        try {
            System.out.println(System.getProperty("user.dir"));
            FileOutputStream fileOut =
                    new FileOutputStream("graph.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(graph);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in graph.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
}
