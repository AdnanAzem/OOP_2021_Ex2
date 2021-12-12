package Tests;

import api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_100000_Nodes {
    private DirectedWeightedGraph grapa;
    private LinkedList<NodeData> link_node;
    private LinkedList<EdgeData> link_edge;
    private DirectedWeightedGraphAlgorithms algo;

    //This class presents the times
    public  Test_100000_Nodes(){
        algo=new DirectedWeightedGraphAlgorithmsAlgo();
        Random random=new Random();
        grapa =new DirectedWeightedGraphAlgo();
        link_node=new LinkedList<>();
        link_edge=new LinkedList<>();
        for (int i = 0; i <100000 ; i++) {
            NodeData node =new NodeDataAlgo(i,random.nextDouble(35,36),random.nextDouble(32,33));
            grapa.addNode(node);
            link_node.add(node);
        }

        int src=0,dest=0;
        double w=0;
        for (int i = 0; i <100000-10 ; i++) {
            //1
            src=i;
            dest=i+1;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+1;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //2
            src=i;
            dest=i+2;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+2;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //3
            src=i;
            dest=i+3;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+3;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //4
            src=i;
            dest=i+4;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+4;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //5
            src=i;
            dest=i+5;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+5;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //6
            src=i;
            dest=i+6;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+6;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //7
            src=i;
            dest=i+7;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+7;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //8
            src=i;
            dest=i+8;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+8;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //9
            src=i;
            dest=i+9;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+9;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //10
            src=i;
            dest=i+10;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=i+10;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

        }


        for (int i=99000, j=0;  i<100000 ; i++ ,j++) {
            //1
            src=i;
            dest=j+1;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+1;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //2
            src=i;
            dest=j+2;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+2;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //3
            src=i;
            dest=j+3;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+3;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //4
            src=i;
            dest=j+4;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+4;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //5
            src=i;
            dest=j+5;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+5;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //6
            src=i;
            dest=j+6;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+6;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //7
            src=i;
            dest=j+7;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+7;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //8
            src=i;
            dest=j+8;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+8;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //9
            src=i;
            dest=j+9;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+9;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));

            //10
            src=i;
            dest=j+10;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));
            src=j+10;
            dest=i;
            w=random.nextDouble(1,2);
            grapa.connect(src,dest,w);
            link_edge.add(new EdgeDataAlgo(src,dest,w));


        }
        algo.init(grapa);

    }


    @Test
    void init() {
        algo.init(grapa);
        assertNotNull(algo.getGraph());

    }

    @Test
    void getGraph() {
        assertNotNull(algo.getGraph());

    }

    @Test
    void copy() {
        assertNotEquals(algo.getGraph(),algo.copy());
    }

    @Test
    void isConnected() {
        algo.init(grapa);
        assertEquals(true,algo.isConnected());
    }

    @Test
    void shortestPathDist() {
        System.out.println(" shortestPathDist is:");
        System.out.println(algo.shortestPathDist( 250,978));
    }

    @Test
    void shortestPath() {
        System.out.println("shortestPath is:");
        System.out.println(algo.shortestPath(250,978));

    }

    @Test
    void center() {
        // System.out.println("enter is:");
        // System.out.println(algo.center());

    }

    @Test
    void tsp() {
        /*
        List<NodeData> node =new LinkedList<>();
        node.add(grapa.getNode(20));
        node.add(grapa.getNode(50));
        node.add(grapa.getNode(100));
        node.add(grapa.getNode(700));
        node.add(grapa.getNode(900));
        node.add(grapa.getNode(0));
        node.add(grapa.getNode(400));
        System.out.println("tsp is:");
        System.out.println(algo.tsp(node));

         */
    }

    @Test
    void save() {
        assertEquals(true,algo.save("100000NodesTest.json"));
    }

    @Test
    void load() throws FileNotFoundException {

        assertEquals(true,algo.load("C:\\Users\\ROG Strix\\IdeaProjects\\Ex2\\100000NodesTest.json"));

    }

}