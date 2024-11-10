package Student.Management.System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Teamname.png"));
//        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(350,0,300,200);
//        add(img);

        JLabel heading = new JLabel("<html>Student Database Management</html>");
        heading.setBounds(120,20,750,70);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Salaj Choudhary(RA2311008050023)");
        name.setBounds(60,150,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD,20));
        add(name);

        JLabel contact = new JLabel("R.Vamshi(RA2311008050005)");
        contact.setBounds(60,200,550,40);
        contact.setFont(new Font("Tahoma", Font.BOLD,20));
        add(contact);

        JLabel name2 = new JLabel("Joel(RA2311008050006)");
        name2.setBounds(60,250,550,40);
        name2.setFont(new Font("Tahoma", Font.BOLD,20));
        add(name2);

        JLabel name3 = new JLabel("Kadir(RA2311008050043)");
        name3.setBounds(60,300,550,40);
        name3.setFont(new Font("Tahoma", Font.BOLD,20));
        add(name3);

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