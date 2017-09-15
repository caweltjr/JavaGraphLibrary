package jcawelti.graphlibrary;

import java.util.*;

public class ShortestPath extends AbstractCollection<Edge> {
    private List<Edge> pathList;
    private Vertex source;
    private Vertex destination;
    private Integer weight;

    ShortestPath(Vertex startingVertex) {
        pathList = new LinkedList<>();
        source = startingVertex;
        destination = startingVertex;
        weight = 0;
    }

    ShortestPath(ShortestPath other) {
        this.pathList = new LinkedList<>(other.pathList);
        this.source = other.source;
        this.destination = other.destination;
        this.weight = other.weight;
    }

    void addEdge(Edge edge) {
        pathList.add(edge);
    }

    @Override
    public Iterator<Edge> iterator() {
        return pathList.iterator();
    }

    @Override
    public int size() {
        return pathList.size();
    }

    @Override
    public String toString() {
        return "Shortest Path from " + source + " to " + destination + ":\n" + pathListToString() +
                "\nTotal Cost: " + weight;
    }

    private String pathListToString() {
        StringJoiner sj = new StringJoiner(" --> ");
        Vertex current = source;
        sj.add(source.getLabel());
        for (Edge e : pathList) {
            current = e.getNeighbor(current);
            sj.add("(" + e.getWeight() + ")" + current.getLabel());
        }

        return sj.toString();
    }

    void setWeight(Integer distance) {
        this.weight = distance;
    }

    void setDestination(Vertex destination) {
        this.destination = destination;
    }
}
