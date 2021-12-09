package GUI;

import api.*;
import GUI.util.Range;
import GUI.util.Range2D;
import GUI.util.Range2Range;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 *This is a department that implements JPanel.
 * She draws the graph on the board
 * She uses a class that Boaz wrote.
 * These classes help to change the pixels between the dot and the board
 */
public class Graphs extends JPanel {
    private DirectedWeightedGraph graph;
    private Range2Range range;//
    private DirectedWeightedGraphAlgorithms algo;

    public Graphs(DirectedWeightedGraphAlgorithms algo) {
        super();
        this.setBackground(new Color(0, 0, 0));
        this.algo=algo;
        this.graph = this.algo.getGraph();

    }
    void reset(){
        int w = this.getWidth();
        int h = this.getHeight();
        //  this.clearRect(0, 0, w, h);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        gd.setStroke(new BasicStroke(2.8f));
        g.setFont(new Font("",Font.BOLD,20));
        //main title
        try {
            if (this.algo.isConnected()) {
                gd.drawString("Number of vertices: " + this.graph.nodeSize() + " ,  " + "Number of edges: " + this.graph.edgeSize() + " ,  " + "Is Connected: " + this.algo.isConnected() + "  , " + "The center: " + this.algo.center().getKey(), this.getWidth() / 2 - 400, this.getHeight() / 15);
            }
            else
                gd.drawString("Number of vertices: "+this.graph.nodeSize()+" ,  "+"Number of edges: "+this.graph.edgeSize() +" ,  "+"Is Connected: "+this.algo.isConnected() +"  , "+"The center: "+this.algo.center() , this.getWidth() / 2-400, this.getHeight() / 15);
        }
        catch (Exception e){
            gd.drawString("Number of vertices: "+this.graph.nodeSize()+" ,  "+"Number of edges: "+this.graph.edgeSize()  , this.getWidth() / 2-400, this.getHeight() / 15);
        }

        this.setBorder(BorderFactory.createTitledBorder("Directed graph"));
        double j = ((this.getHeight() * this.getWidth())/4000 );/// 4000
        double k = ((this.getHeight() * this.getWidth())/100000);/// 100000
        Range2D paint = new Range2D(new Range(k, this.getWidth() - 100 ), new Range(this.getHeight() - 100, j));
        this.range = this.range(this.graph, paint);
        Iterator<NodeData> iter_node =this.graph.nodeIter();
        while (iter_node.hasNext()){
            NodeData node =iter_node.next();
            Node(node, g);
            try {
                Iterator<EdgeData> iterator =this.graph.edgeIter(node.getKey());
                while (iterator.hasNext()){
                    EdgeData e =iterator.next();
                    Edge(e, g);
                }
            }
            catch (Exception e){
                continue;
            }
        }

    }
    //Draws a vertex
    public void Node(NodeData node, Graphics graphics) {
        graphics.setColor(Color.BLUE);
        GeoLocation p = node.getLocation();
        GeoLocation f = this.range.world2frame(p);
        graphics.fillOval((int) f.x() -5, (int) f.y() -5, 15, 15);
       // graphics.setFont(new Font("",Font.BOLD,15));
       // graphics.setColor(new Color(4, 5, 5));
        graphics.setColor(new Color(46, 239, 239));
        graphics.drawString("" + node.getKey(), (int) f.x(), (int) f.y() - 20);
    }

    //Draws a Edge
    public void Edge(EdgeData edge, Graphics graphics) {
      //  graphics.setColor(Color.GREEN);
        graphics.setColor(new Color(255, 0, 0));
        GeoLocation node_src = this.graph.getNode(edge.getSrc()).getLocation();
        GeoLocation node_dest = this.graph.getNode(edge.getDest()).getLocation();
        GeoLocation v1 = this.range.world2frame(node_src);
        GeoLocation v2 = this.range.world2frame(node_dest);
        graphics.drawLine((int) v1.x(), (int) v1.y(), (int) v2.x(), (int) v2.y());

       // graphics.setFont(new Font("",Font.TRUETYPE_FONT,10));
      //  graphics.setColor(Color.green);
       // graphics.drawString("(Src:"+this.graph.getNode(edge.getSrc()).getKey()+", Dest:"+graph.getNode(edge.getDest()).getKey()+",Wei:"+(""+edge.getWeight()).subSequence(0,4)+")",(int)((v1.x()+v2.x())/2),(int)((v1.y()+v2.y())/2));
    }

    // @author boaz_benmoshe
    private Range2D GraphRange(DirectedWeightedGraph g) {
        Iterator<NodeData> itr = g.nodeIter();
        double x0 = 0, x1 = 0, y0 = 0, y1 = 0;
        boolean first = true;
        while (itr.hasNext()) {
            GeoLocation p = itr.next().getLocation();
            if (first) {
                x0 = p.x();
                x1 = x0;
                y0 = p.y();
                y1 = y0;
                first = false;
            } else {

                if (p.x() < x0) x0 = p.x();
                if (p.x() > x1) x1 = p.x();
                if (p.y() < y0) y0 = p.y();
                if (p.y() > y1) y1 = p.y();
            }
        }
        Range xr = new Range(x0, x1);
        Range yr = new Range(y0, y1);
        return new Range2D(xr, yr);
    }

    // @author boaz_benmoshe
    public  Range2Range range(DirectedWeightedGraph g, Range2D frame) {
        Range2D world = GraphRange(g);
        Range2Range ans = new Range2Range(world, frame);
        return ans;
    }
}