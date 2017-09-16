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

To meet these requirements, I developed this project, a java 8 maven command-line project that creates a weighted, connected graph data structure. The graph stucture is created
by reading in a .csv file in the form of edges defined as 'vertex 1, vertex 2, weight'. For example, one
edge would be 'A,B,300' which represents an edge with a weighted value of 300. Two csv files are included. The
advanced.csv file was used in this project.  An image of this graph is included as graph.png. The graph data structure is 
composed of 2 hashmaps, one for the edges and one for the vertices. 

The following graph functions are implemented:

    1. create (add edges and vertices) the graph from data in a csv file
    2. add/remove single edges 
    3. add/remove single vertices
    4. given a vertex, retrieve it's edges and determine it's connectivity to edges
    5. edges have labels and have weights
    6. the Dijkstra shortest path algorithm has been implemented to find the shortest path between 2 vertices
    7. The graph can be stored on disk or transmitted across a network through the java.io.Serializeable
           mechanism
    8. A separate wrapper class called ThreadSafeGraph with synchronized methods was created to
        meet the requirement that it could be manipulated and queried safely from multiple threads.
    9. A set of starter Junit tests are included. 
    
