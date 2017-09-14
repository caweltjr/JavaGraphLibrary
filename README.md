Graph Library Project

A java maven command-line project that creates a weighted, connected graph data structure. The graph stucture is created
using hashmaps for the edges and the vertices. 

The following graph functions are implemented:

    1. create (add edges and vertices) the graph from data in a csv file
    2. add/remove edges 
    3. add/remove vertices
    4. retrieve edges for vertex
    5. given a vertex, determine it's connectivity to edges
    
A set of starter Junit tests are included.   

The edges have labels and a positive integer weight is assigned to each edge.
The graph can be stored on disk or transmitted across a network through the java.io.Serializeable
    mechanism.
The Dijkstra shortest-path algorithm has been implemented to find the shortest path between 
    2 vertices using weighted edges.
