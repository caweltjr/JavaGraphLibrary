package jcawelti.graphlibrary;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;

import java.util.HashMap;

public class ThreadSafeGraph implements GraphInterface, java.io.Serializable{
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    private ShortestPath chosenShortestPath;

    public ThreadSafeGraph() {
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    public synchronized boolean addEdge(String vertexLabel1, String vertexLabel2, int weight)throws EdgeException {
        // computeIfAbsent will only create a new vertex if there is none already in the vertices hashmap
        // otherwise use the already connected vertex and update it's new neighbor in addEdge
        Vertex one = vertices.computeIfAbsent(vertexLabel1, Vertex::new);
        Vertex two = vertices.computeIfAbsent(vertexLabel2, Vertex::new);
        if (one.equals(two)) {
            throw new EdgeException("Vertices cannot be the same in this Graph");
        }

        if(weight < 1){
            throw new EdgeException("The Edge Weight must be a positive integer greater than 0");
        }
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if (edges.containsKey(e.hashCode())) {
            throw new EdgeException("This Edge is already in the Graph");
        } else if (!(vertices.containsValue(one) || vertices.containsValue(two))) {
            throw new EdgeException("This Edge is already in the Graph");
        }
        //and that the Edge isn't already incident to one of the vertices
        else if (one.containsNeighbor(e) || two.containsNeighbor(e)) {
            throw new EdgeException("This Edge is already connected to one of the vertices in the Graph");
        }

        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);

        return true;
    }
    public synchronized void removeEdge(Vertex one, Vertex two) throws EdgeException {
        if (one.equals(two)) {
            throw new EdgeException("Vertices cannot be the same in this graph");
        }

        for (Edge e : edges.values()) {
            // update the Edges data structure, removing the desired edge
            if ((e.getOne().getLabel().equals(one.getLabel())) && (e.getTwo().getLabel().equals(two.getLabel()))){
                edges.remove(e.hashCode(), e);
                break;
            }
        }
        // removing an Edge involves removing 2 vertices;
        // but cannot remove vertex if it is part of another still existing edge;
        // update the vertices data structure

        boolean vertexIsInUse = false;
        for (Vertex v : vertices.values()){
            for (Edge e : edges.values()) {
                if ((e.getOne().getLabel().equals(v.getLabel())) || (e.getTwo().getLabel().equals(v.getLabel()))){
                    vertexIsInUse = true;
                    break;
                }
            }
            if(!vertexIsInUse){
                vertices.remove(v.hashCode(),v);
            }
        }
    }
    public synchronized boolean addVertexIfAbsent(Vertex vertex) {
        Vertex current = this.vertices.get(vertex.getLabel());
        if (current == null) {
            vertices.put(vertex.getLabel(), vertex);
            return true;
        }
        return false;
    }
    public synchronized void displayGraph() {
        for (Edge e : edges.values()) {
            System.out.println(e);
        }
    }
    public synchronized Vertex getVertex(String label) throws VertexNotFoundException {
        if (vertices.containsKey(label)) {
            return vertices.get(label);
        }
        throw new VertexNotFoundException("'" + label + "' vertex not found in graph");
    }
    public synchronized ShortestPath getChosenShortestPath() {

        return chosenShortestPath;
    }
    public synchronized void setChosenShortestPath(ShortestPath chosenShortestPath) {

        this.chosenShortestPath = chosenShortestPath;
    }
    public synchronized void resetGraph() {
        vertices.values().forEach(Vertex::reset);
        chosenShortestPath = null;
    }
    public synchronized HashMap<Integer, Edge> getEdges() {

        return edges;
    }

    public synchronized HashMap<String, Vertex> getVertices() {

        return vertices;
    }
}
