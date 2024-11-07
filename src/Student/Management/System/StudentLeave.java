package Student.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice choiceRollNo,choiseTime;

    JDateChooser dateChoos;

    JButton submit,cancel;

    StudentLeave(){

        getContentPane().setBackground(new Color(210,232,252));
        JLabel heading = new JLabel("Apply for Leave");
        heading.setBounds(110,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel RollNoSe = new JLabel("Search by Roll No");
        RollNoSe.setBounds(130,100,200,20);
        RollNoSe.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(RollNoSe);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(130,130,200,20);
        add(choiceRollNo);

        try{
            Connection_Data cd = new Connection_Data();
            ResultSet resultSet = cd.stmt.executeQuery("select * from student");
            while(resultSet.next()){
                choiceRollNo.add(resultSet.getString("StudentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel date = new JLabel("Date");
        date.setBounds(130,180,200,20);
        date.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(date);

        dateChoos = new JDateChooser();
        dateChoos.setBounds(130,210,200,25);
        add(dateChoos);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(130,260,200,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);

        choiseTime = new Choice();
        choiseTime.setBounds(130,290,200,20);
        choiseTime.add("Full Day");
        choiseTime.add("Half Day");
        add(choiseTime);

        submit = new JButton("Submit");
        submit.setBounds(130,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(270,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,500);
        setLocation(500,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String RollNo = choiceRollNo.getSelectedItem();
            String date = ((JTextField) dateChoos.getDateEditor().getUiComponent()).getText();
            String time = choiseTime.getSelectedItem();

            String Q = "insert into studentleave values('"+RollNo+"','"+date+"','"+time+"')";
            try{
                Connection_Data cd = new Connection_Data();
                cd.stmt.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
