package api;

import java.util.Collection;
import java.util.HashMap;

public class NodeDataAlgo implements NodeData{

    private  double weight;
    private String info;
    private int tag,key;
    private GeoLocation location;
    private HashMap<Integer,NodeData> hmp;//this hash map are for the neighbors
    private HashMap<Integer,Double> weighth;//this hashmap use between two nodes or more that have the weighte between .

    public NodeDataAlgo(int key) {
        this.key = key;
        this.tag = 0;
        this.info = "";
        this.weight=0;
        this.hmp = new HashMap<Integer, NodeData>();
        this.weighth=new HashMap<Integer, Double>();
    }

    public NodeDataAlgo(GeoLocation pos, int id){
        this.key = id;
        this.location = new GeoLocationAlgo(pos);
        this.weight = 0;      //default
        this.info = "";      //default
        this.tag = 0;       //default
        this.hmp = new HashMap<Integer, NodeData>();
        this.weighth=new HashMap<Integer, Double>();
    }

    public void setKey(int k) { this.key = k; }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) { this.location = p; }

    @Override
    public double getWeight() { return this.weight; }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }

    public void removeNode(NodeData node) {
        if(node !=null) this.hmp.remove(node.getKey(),node);
    }

    //this method i added that she tell me all the nodes in collection (the neighbors).
    public Collection<NodeData> getNi() {
        return this.hmp.values();
    }
    //this method ask if have a neighbors to specific key that i have + i put the key in the node and ask .
    public boolean hasNi(int key) {
        if(this.hmp.containsKey(key)) return true ;
        return false;
    }
    //this method add the node to the neighbors in tha hash mao neighbors.
    public void addNi(NodeData t) {
        if(t!=null)
            this.hmp.put(t.getKey(),t);
    }

    public HashMap<Integer, Double> getWeighth() {
        return this.weighth;
    }

}
