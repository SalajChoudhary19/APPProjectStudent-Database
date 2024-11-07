package Student.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice choiceEmpID;

    JTable table;

    JButton search, cancel, print;

    StudentLeaveDetails(){
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel heading = new JLabel("Search by Student ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180,20,150,20);
        add(choiceEmpID);

        try{
            Connection_Data c = new Connection_Data();
            ResultSet resultSet = c.stmt.executeQuery("select * from studentleave");
            while(resultSet.next()){
                choiceEmpID.addItem(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Connection_Data c = new Connection_Data();
            ResultSet resultSet = c.stmt.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        cancel = new JButton("Cancel");
        cancel.setBounds(120,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);

        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from studentleave where rollno='"+choiceEmpID.getSelectedItem()+"'";
            try{
                Connection_Data c = new Connection_Data();
                ResultSet resultSet = c.stmt.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource() == print){
            try{
                table.print();
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
