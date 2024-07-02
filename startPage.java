/**
 * This class creates the start page of the Tae-GymApp with two buttons:
 * "Log In" and "Sign Up". When either button is clicked, log-in or sign up is performed.
 */

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class startPage implements ActionListener {


    JButton buttonLN;
    JButton buttonSU;

    JFrame frame;


    startPage() {
         frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(null);
         frame.setTitle("Tae-GymApp");
         frame.setSize(650, 700);
         frame.getContentPane().setBackground(new Color(0x000B9A));


         buttonLN = new JButton("Log In");
         buttonLN.setBounds(200, 250, 100, 50);
         buttonLN.addActionListener(this);

         buttonSU = new JButton("Sign Up");
         buttonSU.setBounds(300, 250, 100, 50);
         buttonSU.addActionListener(this);

         JLabel title = new JLabel("Tae-Gym App ");
        title.setForeground(Color.white);
        title.setBounds(150, 2, 400, 200);
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));


         frame.add( buttonLN);
         frame.add( buttonSU);
         frame.add(title);
         frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLN) {


            new login();
            frame.dispose();
        } else if (e.getSource() == buttonSU) {

            //goes to sign-up page
            new signup();
            frame.dispose();
        }
    }
}
