package Student.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

        JLabel DOB = new JLabel("DOB");
        DOB.setBounds(400, 200, 200, 30);
        DOB.setFont(new Font("serif", Font.BOLD, 20));
        add(DOB);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50, 250, 150, 30);
        Address.setFont(new Font("serif", Font.BOLD, 20));
        add(Address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        JLabel Phones = new JLabel("Phones");
        Phones.setBounds(400, 250, 200, 30);
        Phones.setFont(new Font("serif", Font.BOLD, 20));
        add(Phones);

        textPhones = new JTextField();
        textPhones.setBounds(600, 250, 150, 30);
        add(textPhones);

        JLabel Email = new JLabel("Email");
        Email.setBounds(50, 300, 200, 30);
        Email.setFont(new Font("serif", Font.BOLD, 20));
        add(Email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 300, 200, 30);
        add(textEmail);

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(400, 350, 200, 30);
        Aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        JLabel Qualification = new JLabel("Course");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);

        String Course[] = {"B.Tech","BBA","BCA","BSC","MSC","MBA","MCA","MCom","BA","MA"};
        courseBox = new JComboBox(Course);
        courseBox.setBounds(200, 400, 150, 30);
        courseBox.setBackground(Color.WHITE);
        courseBox.setFont(new Font("serif", Font.BOLD, 20));
        add(courseBox);

        JLabel Department = new JLabel("Branch");
        Department.setBounds(400, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);

        String department[] = {"CS","IT","Electronics","Mechanical","Civil"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(600, 400, 150, 30);
        departmentBox.setBackground(Color.WHITE);
        departmentBox.setFont(new Font("serif", Font.BOLD, 20));
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String father = textfather.getText();
            String StudentID = textStu.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phones = textPhones.getText();
            String email = textEmail.getText();
            String m10 = textM10.getText();
            String m12 = textM12.getText();
            String aadhar = textAadhar.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try{
                String q = "INSERT INTO student values('"+name+"','"+father+"','"+StudentID+"','"+dob+"','"+address+"','"+phones+"','"+email+"','"+m10+"','"+m12+"','"+aadhar+"','"+course+"','"+department+"')";
                Connection_Data connData = new Connection_Data();
                Connection conn = connData.getConnection();
                conn.createStatement().executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data Inserted");
                setVisible(false);
            }catch (Exception E) {
                E.printStackTrace();
            }

            }else{
            setVisible(false);
        }
        }

    public static void main(String[] args) {
        new AddStudent();
    }
}
