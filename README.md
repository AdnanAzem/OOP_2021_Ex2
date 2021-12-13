# OOP_2021_Ex2

Directed Wieghted Graph:
![DWG](https://user-images.githubusercontent.com/88532380/145715653-ba32db47-5d88-4293-a449-5cc6a5711977.png)

<hr></hr>

Project:

this project represents an directional and weighted graph that support a large number of nodes,
based on afficient cimpact representation. The project contains 1 part: api - the data struct
and the algorithms methods.

<hr></hr>

Classes:

GeoLocaionAlgo: implemants GeoLocaion interface represent an 3D point

EdgeDataAlgo: implemants EdgeData interface 
	
	methods:
	constructor
	getters & setters - soure node , dest node, edge weight , info , tag	

NodeDataAlgo: implemants NodeData interface represents the set of operations applicable
on a node (vertex) in an directional and weighted graph.
	
	methods:
		constructor
		getters & setters - key , Geolocation , weight , tag, info
		compareto - compere nodes weight used in Dijkstra method (algorithms)
	
DirectedWeightedGraphAlgo: implemants DirectedWeightedGraph interface
	
	methods: 
		constructor
		getNode: returns the node data by the node id
		getEdge: returns the data of the edge (src,dest)
		addNode: adds a new node to the graph with the given node data
		connect: connects an edge with weight w between node src to node dest
		getV: returns a pointer (shallow copy) for the collection representing
		all the nodes in the graph.
		getE: returns a pointer (shallow copy) for the collection representing
		all the edges getting out of the given node
		removeNode: deletes the node from the graph and removes
		all edges which starts or ends at this node. 
		removeEdge: deletes the edge from the graph
		nodeSize: returns the number of vertices (nodes) in the graph
		edgeSize: returns the number of edges
		getMC: returns the Mode Count - for testing changes in the graph.

DirectedWeightedGraphAlgorithms: This interface represents a Directed (positive) Weighted Graph Theory Algorithms.

	methods: 
		init: init the graph on which this set of algorithms operates on.
		getGraph: return the underlying graph of which this class works. 
		copy: compute a deep copy of this weighted graph.
		isConnected: returns true if and only if there is a valid path from
		each node to each other node by using bfs algorithm.
		shortestPath: returns the the shortest path between src to dest
		as an ordered List of nodes by using dijkstra algorithm
		shortestPathDist: returns the length of the shortest path between src to dest
		save: save the graph to the given file name in JSON format
		load: load a graph to this graph algorithm by JSON format
	
<hr></hr>

Results:

<table>
  <tr>
    <th>DirectedWeightedGraphAlgorethms</th>
    <th>1000 Nodes</th>
    <th>10000 Nodes</th>
    <th>100000 Nodes</th>
    <th>1000000 Nodes</th>
  </tr>
  <tr>
    <th>init</th>
    <th>20 ms</th>
    <th>1 ms </th>
    <th>1 ms </th>
    <th>1 ms </th>
  </tr>
  <tr>
    <th>isConnected</th>
    <th>25 ms</th>
    <th>39 ms</th>
    <th>314 ms</th>
    <th>1 sec 552 ms</th>
  </tr>
  <tr>
    <th>copy</th>
    <th>46 ms</th>
    <th>74 ms</th>
    <th>628 ms</th>
    <th>1 ms</th>
  </tr>
  <tr>
    <th>geGraph</th>
    <th>18 ms</th>
    <th>1 ms</th>
    <th>1 ms</th>
    <th>1 ms</th>
  </tr>
  <tr>
    <th>center</th>
    <th>15 min 37 sec</th>
    <th>OutOfMemoryError</th>
    <th>OutOfMemoryError</th>
    <th>OutOfMemoryError</th>
  </tr>
  <tr>
    <th>shortestPath</th>
    <th>193 ms</th>
    <th>104 ms</th>
    <th>972 ms</th>
    <th>1 min 25 sec</th>
  </tr>
  <tr>
    <th>shortestPathDist</th>
    <th>22 ms</th>
    <th>32 ms</th>
    <th>1 sec 15 ms</th>
    <th>2 min 8 sec</th>
  </tr>
  <tr>
    <th>tsp</th>
    <th>431 ms</th>
    <th>3 sec 842 ms</th>
    <th>OutOfMemoryError</th>
    <th>OutOfMemoryError</th>
  </tr>
  <tr>
    <th>save</th>
    <th>110 ms</th>
    <th>435 ms</th>
    <th>4 sec 859 ms</th>
    <th>OutOfMemoryError</th>
  </tr>
  <tr>
    <th>load</th>
    <th>155 ms</th>
    <th>371 ms</th>
    <th>3 sec 298 ms</th>
    <th>OutOfMemoryError</th>
  </tr>
</table>

<hr></hr>

Notice:

To run the jar file you must to have java 17.0.1 in your computer




