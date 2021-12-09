package GUI;

import GUI.label.Label_ConnectNode;
import api.DirectedWeightedGraphAlgorithms;
//import GUI.label.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *This is a class that draws the graph.
 * It has a lot of buttons that each button has a class.
 * What implements the ActionListener interface
 */
public class Jframe extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu,editMenu,helpMenu;
    JMenuItem loadItem,saveItem,exitItem,RemoveNodeItem,RemoveEdgeItem,ConnectNodeItem,AddNodeItem,helptItem,ShortestPathDistItem,
            ExplanationverticesItem,ShortestPathItem,TspItem;
    Graphs g;
    private DirectedWeightedGraphAlgorithms Algo;
    public Jframe(DirectedWeightedGraphAlgorithms graph){
        this.Algo=graph;
        initFrame();
        addMenu();
        initPanel();

    }

    private void initPanel() {
        this.g=new Graphs(this.Algo);
        this.add(g);
    }

    private void addMenu() {
        //A button that contains them all
        menuBar = new JMenuBar();

        //Add a name to item label
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        //Add a name to item label
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        RemoveNodeItem = new JMenuItem("Remove Node");
        RemoveEdgeItem = new JMenuItem("Remove Edge");
        ConnectNodeItem=new JMenuItem("Connect 2 Nodes");
        AddNodeItem=new JMenuItem("Add Node");
        ShortestPathItem=new JMenuItem("Shortest Path List");
        TspItem=new JMenuItem("Tsp List");
        ShortestPathDistItem=new JMenuItem("Shortest path sum");
        ExplanationverticesItem=new JMenuItem("Vertex information");
        helptItem=new JMenuItem("explanation");

        //Add secondary buttons to file
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        //Add secondary buttons to edit
        editMenu.add(RemoveNodeItem);
        editMenu.add( RemoveEdgeItem);
        editMenu.add(ConnectNodeItem);
        editMenu.add(AddNodeItem);
        editMenu.add(TspItem);
        editMenu.add(ShortestPathDistItem);
        editMenu.add(ShortestPathItem);

        //Add secondary buttons to help
        helpMenu.add(ExplanationverticesItem);
        helpMenu.add( helptItem);

        //Add main buttons
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Listen to the buttons
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        RemoveNodeItem.addActionListener(this);
        RemoveEdgeItem.addActionListener(this);
        ConnectNodeItem.addActionListener(this);
        AddNodeItem.addActionListener(this);
        helptItem.addActionListener(this);
        ShortestPathDistItem.addActionListener(this);
        ExplanationverticesItem.addActionListener(this);
        TspItem.addActionListener(this);
        ShortestPathItem.addActionListener(this);

        //Insert the button
        this.setJMenuBar(menuBar);
    }

    //Large screen
    private void initFrame() {
        //  Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
      //  this.setSize(1000,400);
        this.setSize(1000,800);
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     *This method implements the ActionListener interface
     * Which listens to every button
     * @param e listen
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem) {
            JFileChooser fc=new JFileChooser();
            int i=fc.showOpenDialog(this);

            //load
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                try{
                    this.Algo.load(filepath);
                    Jframe k=new Jframe(this.Algo);
                    k.setVisible(true);
                }catch (Exception ex) {ex.printStackTrace();  }
            }
        }


        // sava
        if(e.getSource()==saveItem) {
            JFileChooser fc=new JFileChooser();
            int i=fc.showSaveDialog(this);
            if(i!=JFileChooser.SAVE_DIALOG){
                File f=fc.getSelectedFile();
                String filepath=f.getPath()+".json";
                try{
                    this.Algo.save(filepath);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        // exit
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
/*

        //Remove Node
        if(e.getSource()== RemoveNodeItem){
            new Label_RemoveNode(this.Algo);
        }

        //Remove Edge
        if(e.getSource()==  RemoveEdgeItem){
            new Label_RemoveEdge(this.Algo);

        }

 */

        //Connect Node
        if(e.getSource()==ConnectNodeItem){
            new Label_ConnectNode(this.Algo);
        }
/*
        //Add Node
        if(e.getSource()== AddNodeItem){
            new Label_AddNode(this.Algo);
        }

        //help - explanation
        if( e.getSource()== helptItem){
            new Label_help().explanation();
        }

        //Shortest Path Dist
        if(e.getSource()==ShortestPathDistItem){
            new Label_ShortestPathDist(this.Algo);

        }

        //Explanationvertices
        if(e.getSource()==ExplanationverticesItem){
            new Label_help().Explanationvertices(this.Algo);
        }

        //tsp
        if(e.getSource()==TspItem){
            new Label_Tsp(this.Algo);
        }

        //Shortest Path
        if(e.getSource()==ShortestPathItem){
            new Label_ShortestPath(this.Algo);
        }

 */


    }





}