package jcawelti.graphlibrary;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;

import java.util.HashMap;

public interface GraphInterface {
    public boolean addEdge(String vertexLabel1, String vertexLabel2, int weight)throws EdgeException  ;
    public void removeEdge(Vertex one, Vertex two) throws EdgeException;
    public boolean addVertexIfAbsent(Vertex vertex);
    public void displayGraph();
    public Vertex getVertex(String label) throws VertexNotFoundException;
    public ShortestPath getChosenShortestPath();
    public void setChosenShortestPath(ShortestPath chosenShortestPath);
    public void resetGraph();
    public HashMap<Integer, Edge> getEdges();
    public HashMap<String, Vertex> getVertices();
    }
