package api;

import java.util.*;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

public class DirectedWeightedGraphAlgorithmsAlgo implements DirectedWeightedGraphAlgorithms{

    private DirectedWeightedGraph graph;
    private int key;

    @Override
    public void init(DirectedWeightedGraph g) { this.graph = g; }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.graph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph g = new DirectedWeightedGraphAlgo();
        Collection<NodeData> b = ((DirectedWeightedGraphAlgo)graph).getV();
        Iterator<NodeData> i = b.iterator();
        while (i.hasNext()) {
            NodeDataAlgo v = new NodeDataAlgo(0);
            NodeData n = i.next();
            v.setTag(n.getTag());
            v.setKey(n.getKey());
            v.setInfo(n.getInfo());
            g.addNode(v);
            Iterator<NodeData> j = b.iterator();
            while (j.hasNext()) {
                NodeDataAlgo z = new NodeDataAlgo(0);
                NodeData l = j.next();
                z.setTag(n.getTag());
                z.setInfo(n.getInfo());
                z.setKey(n.getKey());
                if (graph.getNode(l.getKey()) == null) {
                    graph.connect(n.getKey(), l.getKey(), graph.getNode(l.getKey()).getTag());
                }
            }
        }
        return null;
    }

    @Override
    public boolean isConnected() {
        if (graph.nodeSize() == 1) return true;
        if (graph.nodeSize() == 0) return true;
        Collection<NodeData> c1 = ((DirectedWeightedGraphAlgo)graph).getV();
        Iterator<NodeData> i1 = c1.iterator();
        while (i1.hasNext()) {

            NodeData mj = i1.next();
            if (mj != null) {
                BFS(mj);
                break;
            }
        }

        boolean flag = true;
        Collection<NodeData> c = ((DirectedWeightedGraphAlgo)graph).getV();
        Iterator<NodeData> i = c.iterator();
        while (i.hasNext()) {
            NodeData n = i.next();
            if (n.getTag() == 0) flag = false;
        }
        if (flag == false) return false;
        return true;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        int max = maxnode(graph);
        double dist[] = new double[max + 1];
        double priv[] = new double[max+1];
        return Dijkstra(graph, src, dest, dist, priv,max+1);
    }

    public double Dijkstra(DirectedWeightedGraph g, int src, int dest, double dist[], double priv[],int max) {
        Queue<NodeData> q = new LinkedList<NodeData>();
        double sum = 0;
        for (int i = 0; i < max; i++) {
            dist[i] = Integer.MAX_VALUE;
            priv[i] = -1;
        }

        for (NodeData v : ((DirectedWeightedGraphAlgo)this.graph).getV()) {
            q.add(v);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            int var = compare(dist, q);
            NodeData v = graph.getNode(var);
            q.remove(v);
            for (NodeData v1 : ((DirectedWeightedGraphAlgo)this.graph).getV(var)) {
                if (q.contains(v1)) {
                    sum = (graph.getEdge(var, v1.getKey())).getWeight() + dist[var];
                    if (sum < dist[v1.getKey()]) {
                        dist[v1.getKey()] = sum;
                        priv[v1.getKey()] = var;

                    }
                }
            }
        }
        return dist[dest];
    }

    public int compare(double dist[], Queue<NodeData> q) {
        int min=0 ;
        double v=Double.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i]<v && q.contains(graph.getNode(i))) {
                v=dist[i];
                min=i;
            }
        }
        return min;
    }

    public int maxnode(DirectedWeightedGraph g) {
        int maxindex = 0;
        for (NodeData n : ((DirectedWeightedGraphAlgo)this.graph).getV()) {
            if (n.getKey() > maxindex) {
                maxindex = n.getKey();
            }
        }
        return maxindex;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        int max = maxnode(graph);
        double dist[] = new double[max + 1];
        double priv[] = new double[max+1];
        return Dijkstra2(graph, src, dest, dist, priv,max+1);
    }

    public List<NodeData> Dijkstra2(DirectedWeightedGraph g, int src, int dest, double dist[], double priv[],int max) {
        List<NodeData> lis=new ArrayList<NodeData>();
        Queue<NodeData> q = new LinkedList<NodeData>();
        double sum = 0;
        for (int i = 0; i < max; i++) {
            dist[i] = Integer.MAX_VALUE;
            priv[i] = -1;
        }

        for (NodeData v : ((DirectedWeightedGraphAlgo)this.graph).getV()) {
            q.add(v);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            int var = compare(dist, q);
            NodeData v = graph.getNode(var);
            q.remove(v);
            for (NodeData v1 : ((DirectedWeightedGraphAlgo)this.graph).getV(var)) {
                if (q.contains(v1)) {
                    sum = (graph.getEdge(var, v1.getKey())).getWeight() + dist[var];
                    if (sum < dist[v1.getKey()]) {
                        dist[v1.getKey()] = sum;
                        priv[v1.getKey()] = var;

                    }
                }
            }
        }
        NodeDataAlgo n= (NodeDataAlgo) this.graph.getNode(dest);
        if(priv[n.getKey()]!=-1 && n.getKey()==src){
            while(n!=null){
                lis.add(n);
                n= (NodeDataAlgo) this.graph.getNode((int)priv[n.getKey()]);
            }
        }
        return lis;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }

    public void BFS (NodeData n ){
        Collection<NodeData> c = ((DirectedWeightedGraphAlgo)graph).getV();
        Iterator<NodeData> i = c.iterator();
        while (i.hasNext()) {
            NodeData node = i.next();
            node.setTag(0);
        }
        Queue<NodeData> q = new LinkedList<NodeData>();
        q.add(n);
        while (!q.isEmpty()) {
            NodeData v = q.remove();
            Collection<NodeData> cv = ((DirectedWeightedGraphAlgo)graph).getV(v.getKey());
            Iterator<NodeData> rc = cv.iterator();

            while (rc.hasNext()) {
                NodeData a = rc.next();
                if (a.getTag() == 0) {
                    q.add(a);
                    a.setTag(1);
                }
            }
        }
    }
}
