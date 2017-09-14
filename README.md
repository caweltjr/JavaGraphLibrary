Graph Library Project

Requirements

Write a small graph library to create (add edges and vertices), manipulate (add/remove edges and
vertices) and query (retrieve edges for vertex, determine connectivity) a graph data structure. Include
automated tests for your code.

Some or all of the following features can also be implemented. If you choose not to, be prepared to
describe how you would do so during the interview.
- Allow edges to have a direction.
- Allow edges to have labels.
- Allow edges to have weights.
- Allow the graph to be stored on disk or transmitted across a network.
- Allow the graph to be manipulated and queried safely from multiple threads.
- Find the shortest path between 2 vertices (bonus points if this uses weighted edges).

Implementation

To meet these requirements, I developed a java maven command-line project that creates a weighted, connected graph data structure. The graph stucture is created
by reading in a .csv file in the form of edges defined as 'vertex 1, vertex 2, weight'. For example, one
edge would be 'A,B,300' which represents an edge with a weighted value of 300. The graph structure is 
composed of 2 hashmaps, one for the edges and one for the vertices. 

The following graph functions are implemented:

    1. create (add edges and vertices) the graph from data in a csv file
    2. add/remove edges 
    3. remove vertices
    4. retrieve edges for vertex
    5. given a vertex, determine it's connectivity to edges
    6. edges have labels and have weights
    7. the Dijkstra shortest path algorithm has been implemented to find the shortest path between 2 vertices
    8. The graph can be stored on disk or transmitted across a network through the java.io.Serializeable
           mechanism
    9. A separate wrapper class called ThreadSafeGraph with synchronized methods was created to
        meet the requirement that it could be manipulated and queried safely from multiple threads.
    10. A set of starter Junit tests are included. 
    
