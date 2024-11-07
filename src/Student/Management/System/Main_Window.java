package Student.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window extends JFrame implements ActionListener {

    public Main_Window() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/educational-background-32fehu59qh64u5rc.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1800, 940, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //new info

        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        JMenuItem studentInfo = new JMenuItem("Student Info");
        studentInfo.setForeground(Color.black);
        newInfo.add(studentInfo);

        //details

        JMenu newDetails = new JMenu("View Details");
        newInfo.setForeground(Color.black);
        mb.add(newDetails);

        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentInfo.setForeground(Color.black);
        newDetails.add(studentDetails);

        //leave

        JMenu newLeave = new JMenu("Apply for Leave");
        newLeave.setForeground(Color.black);
        mb.add(newLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave Form");
        studentLeave.setForeground(Color.black);
        newLeave.add(studentLeave);

        //Exams

        JMenu newExams = new JMenu("Exam Details");
        newExams.setForeground(Color.black);
        mb.add(newExams);

        JMenuItem TimetableExams = new JMenuItem("Exam TimeTable");
        TimetableExams.setForeground(Color.black);
        newExams.add(TimetableExams);

        JMenuItem SyllabusExams = new JMenuItem("Exam Syllabus");
        SyllabusExams.setForeground(Color.black);
        newExams.add(SyllabusExams);

        //Results

        JMenu newResult = new JMenu("Result");
        newResult.setForeground(Color.black);
        mb.add(newResult);

        JMenuItem studentResult = new JMenuItem("Student Results");
        studentResult.setForeground(Color.black);
        newResult.add(studentResult);

        //Fee

        JMenu newFee = new JMenu("Fee Details");
        newFee.setForeground(Color.black);
        mb.add(newFee);

        JMenuItem studentFee = new JMenuItem("Student Fee Form");
        studentFee.setForeground(Color.black);
        newFee.add(studentFee);

        //Utilities

        JMenu newCalculator = new JMenu("Utilities");
        newCalculator.setForeground(Color.black);
        mb.add(newCalculator);

        JMenuItem studentCalculator = new JMenuItem("Calculator");
        studentCalculator.setForeground(Color.black);
        newCalculator.add(studentCalculator);
        studentCalculator.addActionListener(this);

        //About

        JMenu About = new JMenu("About");
        About.setForeground(Color.black);
        mb.add(About);

        JMenuItem Teamdetails = new JMenuItem("Team Details");
        Teamdetails.setForeground(Color.black);
        Teamdetails.addActionListener(this);
        About.add(Teamdetails);

        //Exit

//        JMenu exit = new JMenu("Exit");
//        exit.setForeground(Color.black);
//        mb.add(exit);
//
//        JMenuItem Exitpage = new JMenuItem("Exit");
//        Exitpage.setForeground(Color.black);
//        exit.addActionListener(this);
//        exit.add(Exitpage);

        setJMenuBar(mb);

        setSize(1800, 940);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Exit")){
            System.exit(0);
        }else if(command.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc");
            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Main_Window();
    }
}