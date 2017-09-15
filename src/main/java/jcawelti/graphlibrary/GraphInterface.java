package jcawelti.graphlibrary;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;

import java.util.HashMap;

public interface GraphInterface {
    boolean addEdge(String vertexLabel1, String vertexLabel2, int weight)throws EdgeException  ;
    void removeEdge(Vertex one, Vertex two) throws EdgeException;
    boolean addVertexIfAbsent(Vertex vertex);
    void removeVertex(Vertex one);
    void displayGraph();
    Vertex getVertex(String label) throws VertexNotFoundException;
    ShortestPath getChosenShortestPath();
    void setChosenShortestPath(ShortestPath chosenShortestPath);
    void resetGraph();
    HashMap<Integer, Edge> getEdges();
    HashMap<String, Vertex> getVertices();
    }
