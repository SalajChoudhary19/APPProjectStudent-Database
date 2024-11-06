package Student.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField usernameFieldName;
    JTextField HeadingField;
    JPasswordField passwordField;
    JButton loginButton;

    Login() {

        JLabel lable3 = new JLabel("LOGIN");
        lable3.setBounds(260,1,100,50);
        lable3.setForeground(Color.BLACK);
        lable3.setFont(new Font("Arial",Font.BOLD,25));
        add(lable3);

        JLabel label1 = new JLabel("Enter Username");
        label1.setBounds(210, 53, 100, 40);
        add(label1);

        JLabel label2 = new JLabel("Enter Password");
        label2.setBounds(210, 100, 150, 40);
        add(label2);

        usernameFieldName = new JTextField();
        usernameFieldName.setBounds(370, 55, 180, 40);
        add(usernameFieldName);

        passwordField = new JPasswordField();
        passwordField.setBounds(370, 100, 180, 40);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(310, 200, 150, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        JButton BackButton = new JButton("Back");
        BackButton.setBounds(130, 200, 150, 40);
        BackButton.addActionListener(this);
        add(BackButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/images.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(30, 25, 150, 150);
        add(img);


        setSize(600, 300);
        setLocation(700,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
