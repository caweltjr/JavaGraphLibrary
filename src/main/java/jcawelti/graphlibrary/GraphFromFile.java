package jcawelti.graphlibrary;

import jcawelti.exception.EdgeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class GraphFromFile {
    public Graph graph;
    public GraphFromFile() {
    }
    public Graph createGraphFromFile(){
        graph = new Graph();

        String fileName;
        BufferedReader br;
//        Scanner kb = new Scanner(System.in);
        try {

            /* Get an file name from the user */
//            System.out.print("Enter file name: ");
//            fileName = kb.nextLine();
            fileName = "advancedGraph.csv";

            /* Open file */
            br = new BufferedReader(new FileReader(fileName));

            String line;
            String[] tokens;
            String first, second;
            int weight;

            /* Process the file */
            while ((line = br.readLine()) != null) {
                tokens = line.split(",");
                if (tokens.length != 3) {
                    System.out.println("Invalid file format");
                    br.close();
                    break;
                }
                first = tokens[0];
                second = tokens[1];
                weight = Integer.parseInt(tokens[2]);

                try {
                    graph.addEdge(first, second, weight);
                } catch (EdgeException e) {
                    System.out.println(e.message());
                }
            }
            br.close();
//            kb.close();
        } catch (NoSuchElementException e) {
            System.out.println("Invalid file format");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

}

