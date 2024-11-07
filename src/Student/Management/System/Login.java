package Student.Management.System;

import Student.Management.System.Connection_Data;
import Student.Management.System.Main_Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField usernameFieldName;
    JPasswordField passwordField;
    JButton loginButton;

    Login() {

        JLabel lable3 = new JLabel("LOGIN");
        lable3.setBounds(260, 1, 100, 50);
        lable3.setForeground(Color.BLACK);
        lable3.setFont(new Font("Arial", Font.BOLD, 25));
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

        loginButton = new JButton("Login");
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
        setLocation(700, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameFieldName.getText();
            String password = new String(passwordField.getPassword()); // Get password as String

            // Use a PreparedStatement to prevent SQL injection
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";

            try {
                Connection_Data connData = new Connection_Data();
                Connection conn = connData.getConnection(); // Get the connection object
                PreparedStatement stmt = conn.prepareStatement(query); // Create PreparedStatement
                stmt.setString(1, username); // Set the username parameter
                stmt.setString(2, password); // Set the password parameter

                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_Window();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false); // Hide the login window when "Back" button is clicked
        }
    }

    public static void main(String[] args) {
        new Login(); // Start the Login GUI
    }
}
