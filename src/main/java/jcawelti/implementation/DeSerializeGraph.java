package jcawelti.implementation;

import jcawelti.graphlibrary.Graph;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//********************************************************************
//  This is the implementation of de-serializing the graph from a file on disk
//  by making use of the java.io.Serialization mechanism.
//********************************************************************
public class DeSerializeGraph {

    public static void main(String[] args) {
        Graph graph;
        System.out.println("Deserializing Graph From a File");
        System.out.println();
        try {
            FileInputStream fileIn = new FileInputStream("graph.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            graph = (Graph) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println("Graph class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Graph from file graph.ser");
        System.out.println();
        graph.displayGraph();
    }
}
