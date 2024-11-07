package Student.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;


public class AddStudent extends JFrame implements ActionListener {

    JTextField textName, textfather, textAddress, textPhones, textEmail, textM10, textM12, textAadhar, textStu;

    JLabel empText;

    JDateChooser cdob;

    JComboBox courseBox, departmentBox;

    JButton submit, cancel;

    Random ran = new Random();

    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        getContentPane().setBackground(new Color(128, 178, 255));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel Name = new JLabel("Name");
        Name.setBounds(50, 150, 100, 30);
        Name.setFont(new Font("serif", Font.BOLD, 20));
        add(Name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        JLabel Father = new JLabel("Father");
        Father.setBounds(400, 150, 200, 30);
        Father.setFont(new Font("serif", Font.BOLD, 20));
        add(Father);

        textfather = new JTextField();
        textfather.setBounds(600, 150, 150, 30);
        add(textfather);

        JLabel StudentID = new JLabel("Student ID");
        StudentID.setBounds(50, 200, 200, 30);
        StudentID.setFont(new Font("serif", Font.BOLD, 20));
        add(StudentID);

        textStu = new JTextField();
        textStu.setBounds(200, 200, 150, 30);
        textStu.setFont(new Font("serif", Font.BOLD, 20));
        add(textStu);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50, 250, 100, 30);
        Address.setFont(new Font("serif", Font.BOLD, 20));
        add(Address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        JLabel Phones = new JLabel("Phones");
        Phones.setBounds(50, 300, 100, 30);
        Phones.setFont(new Font("serif", Font.BOLD, 20));
        add(Phones);

        textPhones = new JTextField();
        textPhones.setBounds(200, 300, 150, 30);
        add(textPhones);

        JLabel Email = new JLabel("Email");
        Email.setBounds(50, 350, 100, 30);
        Email.setFont(new Font("serif", Font.BOLD, 20));
        add(Email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 350, 150, 30);
        add(textEmail);

        JLabel M10 = new JLabel("M10");
        M10.setBounds(50, 400, 100, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(200, 400, 150, 30);
        add(textM10);

        JLabel M12 = new JLabel("M12");
        M12.setBounds(50, 450, 100, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 450, 150, 30);
        add(textM12);

        JLabel Aadhar = new JLabel("Aadhar");
        Aadhar.setBounds(50, 500, 100, 30);
        Aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(200, 600, 150, 30);
        add(textAadhar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
