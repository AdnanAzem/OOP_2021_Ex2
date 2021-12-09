package GUI;

import api.*;

import javax.swing.*;
import java.awt.*;

public class draw extends JFrame {

    public draw(){
        super();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screensize.height / 2;
        int screenWidth = screensize.width / 2;
        this.setTitle("Adnan and Yousef");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(screenWidth,screenHeight);
        this.setVisible(true);
       // ImageIcon image= new ImageIcon("green fade.png");
       // this.setIconImage(image.getImage());
       // this.getContentPane().setBackground(new Color(196, 144, 65));
    }

    public class MyPanel extends JPanel{

        public MyPanel(){

        }

    }



    public static void main(String[] args) {
        draw d = new draw();
    }
}
