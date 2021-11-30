package api;

import java.util.*;

public class DirectedWeightedGraphAlgo implements DirectedWeightedGraph{

    private HashMap<Integer, NodeData> mygraph;// this variable collection tell me the collection node in my graph
    // i put it in hashmap to enable to catch al the nodes in the collection that have integer key and node info val
    private int MC=0;// this variable count the changes in my graph like add nodes and remove nodes in the graph .
    private int edgenum=0;// this variable tell me number of the edges between all the nodes in my graph (collection).

    public DirectedWeightedGraphAlgo()
    {
        //this method are constructor to initialization all the variable in my graph.
        this.mygraph = new HashMap<Integer, NodeData>();// i have an empty hashmap now .
        this.MC=0;// no changes in my graph now
        this.edgenum=0;//no egdes between the nodes now.
    }

    @Override
    public NodeData getNode(int key) {
        return this.mygraph.get(key);
    }

    public boolean hasEdge(int src, int dest) {
        if(mygraph.get(src)!=null && mygraph.get(dest)!=null) {
            NodeDataAlgo n1=(NodeDataAlgo) this.mygraph.get(src);
            NodeDataAlgo n2=(NodeDataAlgo) this.mygraph.get(dest);
            if(n1.hasNi(dest)) return true;
        }
        return false;
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        if (src == dest) return null;
        if (!hasEdge(src, dest)) return null;
        return new EdgeDataAlgo(src,dest,0);
    }

    @Override
    public void addNode(NodeData n) {
        this.mygraph.put(n.getKey(),n);
        ++this.MC;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if (src != dest && this.mygraph.containsKey(src) && this.mygraph.containsKey(dest)) {
            NodeDataAlgo node1 = (NodeDataAlgo) this.mygraph.get(src);
            NodeDataAlgo node2 = (NodeDataAlgo)this.mygraph.get(dest);
            if (node1 != null && node2 != null) {
                if (hasEdge(src, dest) == false) {
                    node1.addNi(node2);
                    node2.addNi(node1);
                    ++edgenum;
                }
                node2.getWeighth().put(src,w);
                node1.getWeighth().put(dest,w);
            }
            ++MC;
        }
    }


    @Override
    public Iterator<NodeData> nodeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        List<Integer> lis=new ArrayList<>();
        NodeDataAlgo n = (NodeDataAlgo) getNode(key);
        if (n!=null) {
            Collection<NodeData> mo = ((NodeDataAlgo)this.mygraph.get(key)).getNi();
            Iterator<NodeData> i= mo.iterator();
            while(i.hasNext()) {
                NodeDataAlgo m = (NodeDataAlgo)i.next();
                lis.add(m.getKey());
            }
            for(int x=0 ; x< lis.size();x++){
                removeEdge(lis.get(x),key);
            }
            this.mygraph.remove(key);
            edgenum-=n.getNi().size();
        }
        return n;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(src == dest)
            return null;
        EdgeData ans = getEdge(src,dest);
        NodeDataAlgo n1= (NodeDataAlgo)this.mygraph.get(src);
        NodeDataAlgo n2= (NodeDataAlgo)this.mygraph.get(dest);
        n1.removeNode(n2);
        n2.removeNode(n1);
        edgenum--;
        return ans;
    }

    @Override
    public int nodeSize() {
        return this.mygraph.size();
    }

    @Override
    public int edgeSize() {
        return this.edgenum;
    }

    @Override
    public int getMC() {
        return this.MC;
    }

    public Collection<NodeData> getV() {
        return this.mygraph.values();
    }

    public Collection<NodeData> getV(int node_id) {
        return (((NodeDataAlgo)this.mygraph.get(node_id)).getNi());
    }
}
