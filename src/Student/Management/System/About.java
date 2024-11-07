package Student.Management.System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Teamname.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 0, 300, 200);
        add(img);



        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(new Color(252,228,210));
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
