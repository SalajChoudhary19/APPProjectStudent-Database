package Student.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails extends JFrame implements ActionListener {

    Choice choice;

    JTable table;
    JButton search,print,update,add,cancel;

    StudentDetails(){
        getContentPane().setBackground(new Color(210,252,218));

        JLabel heading = new JLabel("Search by  Roll No.");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try{
        try {
                Connection_Data Connection = new Connection_Data();
                ResultSet resultSet = Connection.stmt.executeQuery("select * from student");
                while (resultSet.next()) {
                    choice.add(resultSet.getString("StudentID"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }catch (Exception E){
            E.printStackTrace();
        }

        table = new JTable();
        try{
            Connection_Data Connection = new Connection_Data();
            ResultSet resultSet = Connection.stmt.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(220,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(320,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(420,70,80,20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(520,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(620,70,80,20);
        cancel.addActionListener(this);
        add(cancel);




        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from student where StudentID='"+choice.getSelectedItem()+"'";
            try{
                Connection_Data Connection = new Connection_Data();
                ResultSet resultSet = Connection.stmt.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource() == print){
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource() == update){
            //need to add
        }else if(e.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
