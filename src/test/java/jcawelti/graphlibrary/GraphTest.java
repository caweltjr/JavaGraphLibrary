package jcawelti.graphlibrary;

import jcawelti.exception.EdgeException;
import jcawelti.exception.VertexNotFoundException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GraphTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void addEdge1() throws Exception {
        // start with an empty graph structure
        Graph graph = new Graph();
//        Assert.assertTrue(graph.addEdge("A","B", 100)); // should pass
//        Assert.assertTrue(graph.addEdge("A","A", 100)); // should fail
        Assert.assertTrue(graph.addEdge("A","B", 10)); // should pass

    }

    @Test
    public void removeEdge1() throws Exception {
        Graph graph = new GraphFromFile().createGraphFromFile();
        Vertex v1 = graph.getVertex("A");
        Vertex v2 = graph.getVertex("A");
        exception.expect(EdgeException.class);
        graph.removeEdge(v1,v2); // should throw exception
    }

    @Test
    public void addVertexIfAbsent() throws Exception {
        Graph graph = new GraphFromFile().createGraphFromFile();
//        Vertex v1 = new Vertex("A"); // should fail test
        Vertex v1 = new Vertex("Z"); // should pass test
        Assert.assertTrue(graph.addVertexIfAbsent(v1));
    }

    @Test
    public void getVertex() throws Exception {
        Graph graph = new GraphFromFile().createGraphFromFile();
        Vertex v1 = graph.getVertex("Z");
        exception.expect(VertexNotFoundException.class);
        graph.getVertex(v1.getLabel()); // should throw exception
    }

}