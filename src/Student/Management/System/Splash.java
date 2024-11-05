package Student.Management.System;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/educational-background-32fehu59qh64u5rc.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        // Set the size and location of the splash screen once without animation
        setSize(1000, 1000);
        setLocationRelativeTo(null); // Centers the window on the screen

        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            Thread.sleep(3000); // Keep the splash screen visible for 3 seconds
            setVisible(false);
            // Proceed to the next class or functionality here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
