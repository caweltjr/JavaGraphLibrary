package jcawelti.graphlibrary;

import jcawelti.exception.PathNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DijkstraAlgorithmTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void calculateShortestPath() throws Exception {
        Graph graph = new GraphFromFile().createGraphFromFile();
        Vertex v1 = graph.getVertices().computeIfAbsent("A", Vertex::new);
        Vertex v2 = graph.getVertices().computeIfAbsent("Z", Vertex::new);// no path from A to Z
        exception.expect(PathNotFoundException.class); // should pass test and throw PathNotFoundException
        ShortestPath sp = new DijkstraAlgorithm(graph).calculateShortestPath(v1, v2);
    }

}