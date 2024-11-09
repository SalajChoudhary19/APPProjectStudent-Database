package Student.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public abstract class UpdateStudent extends JFrame implements ActionListener {

    JTextField textAddress, textPhone, textMail, textAadhar, textCourse, textBranch;

    JLabel empText;

    JButton submit, cancel;

    Choice cEMPID;

    UpdateStudent() {
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select RollNo.: ");
        empID.setBounds(50, 100, 200, 50);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250, 100, 200, 20);
        add(cEMPID);

        try {
            Connection_Data cd = new Connection_Data();
            ResultSet rs = cd.stmt.executeQuery("select * from student");
            while (rs.next()) {
                cEMPID.addItem(rs.getString("EMPID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Select Student Name: ");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 150, 150, 30);

        add(textName);

        JLabel fname = new JLabel("Select Student's Father Name: ");
        fname.setBounds(50, 150, 100, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textFather = new JLabel();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);

        JLabel EMPID = new JLabel("Roll No.");
        EMPID.setBounds(50, 200, 200, 50);
        EMPID.setFont(new Font("serif", Font.BOLD, 20));
        add(EMPID);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        JLabel dob = new JLabel("DOB");
        dob.setBounds(400, 200, 200, 50);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600, 200, 150, 30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 50);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        JLabel phone = new JLabel("Select Student Phone: ");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);

        JLabel Email = new JLabel("Select Student Mail: ");
        Email.setBounds(50, 30, 200, 30);
        Email.setFont(new Font("serif", Font.BOLD, 20));
        add(Email);

        textMail = new JTextField();
        textMail.setBounds(200, 300, 150, 30);
        add(textMail);

        JLabel M10 = new JLabel("Select X marks: ");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        JLabel M12 = new JLabel("Select XII marks: ");
        M12.setBounds(50, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        JLabel Aadhar = new JLabel("Aadhar Number: ");
        Aadhar.setBounds(400, 350, 200, 30);
        Aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        JLabel Qualification = new JLabel("Course: ");
        Qualification.setBounds(400, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);

        textCourse = new JTextField();
        textCourse.setBounds(600, 400, 150, 30);
        add(textCourse);

        JLabel department = new JLabel("Department: ");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        add(department);

        textBranch = new JTextField();
        textBranch.setBounds(600, 400, 150, 30);
        add(textBranch);

        try{
            Connection_Data cd = new Connection_Data();
            String query = "select * from student where StudentID = '"+cEMPID.getSelectedItem()+"'";
            ResultSet resultSet = cd.stmt.executeQuery(query);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("father"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phones"));
                textMail.setText(resultSet.getString("mail"));
                textAadhar.setText(resultSet.getString("aadhar"));
                textCourse.setText(resultSet.getString("course"));
                textBranch.setText(resultSet.getString("branch"));
                textM10.setText(resultSet.getString("m10"));
                textM12.setText(resultSet.getString("m12"));
                empText.setText(resultSet.getString("empId"));
                dob.setText(resultSet.getString("dob"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Update");
        submit.setBounds(250,250,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
