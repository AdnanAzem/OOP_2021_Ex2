package GUI.label;

import GUI.Jframe;
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// It's a class of button ConnectNode
public class Label_ConnectNode  extends JFrame implements ActionListener {
    JTextField tf; JLabel l; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public  Label_ConnectNode( DirectedWeightedGraphAlgorithms algo){
        this.algo=algo;
        this.graph=this.algo.getGraph();
        tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        l=new JLabel();
        l.setBounds(30,100, 350,40);
        b=new JButton("Connect");
        b.setBounds(50,150,95,30);
        b.addActionListener(this);
        l.setText("Insert 2 keys and Weight. Type: Src,Dest,Weig. e.g: 5,3,3.4");
        add(b);add(tf);add(l);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String host=tf.getText();
            String[] temp = host.split(",");
            this.graph.connect(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
            l.setText("Edge Number: "+host+" Connect");
            this.algo.init(this.graph);
            Jframe k=new Jframe(this.algo);
            k.setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }



}