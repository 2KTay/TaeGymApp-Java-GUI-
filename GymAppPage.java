/**
 * This class creates the main menu page for the Tae-GymApp.
 * It allows users to select a day of the week
 * to view or set their workout schedule, view their workouts, get information, or log out.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GymAppPage extends JFrame implements ActionListener{


    static String dayChoice;

    JFrame frame;
    JLabel title;
    JLabel text;
    JLabel welcome;



    JButton monbutton;
    JButton tuesbutton;
    JButton wedbutton;
    JButton thursbutton;
    JButton fributton;
    JButton satbutton;
    JButton sunbutton;

    JButton viewButton;
    JButton infoButton,exit;
    public GymAppPage() {


        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(714, 700);
        frame.getContentPane().setBackground(new Color(0x000B9A));


        title = new JLabel("<html>Welcome, " + User.username + " <br/>to the Tae-Gym App</html>");
        title.setForeground(Color.white);
        title.setBounds(200, -50, 400, 200);
        title.setFont(new Font("Comic Sans", Font.BOLD, 40));

        text = new JLabel("<html>(CANNOT SKIP CARDIO DO AT LEAST 15-25 MIN PER DAY)<br/>");
        text.setForeground(Color.white);
        text.setBounds(175, 450, 400, 200);
        text.setFont(new Font("Comic Sans", Font.BOLD, 14));


        welcome = new JLabel("Welcome, " + User.username + " to the Tae-Gym App");
        welcome.setForeground(Color.green);
        welcome.setBounds(5, -75, 400, 200);
        welcome.setFont(new Font("Comic Sans", Font.BOLD, 13));

        viewButton = new JButton("View your workouts");
        viewButton.setBounds(0, 565, 200, 50);
        viewButton.addActionListener(this);

        infoButton = new JButton("infomation");
        infoButton.setBounds(250, 565, 200, 50);
        infoButton.addActionListener(this);

        exit=new JButton("Log-Out");
        exit.setBounds(525, 565, 200, 50);
        exit.addActionListener(this);


        monbutton = new JButton("Monday");
        monbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        monbutton.setVerticalAlignment(SwingConstants.TOP);
        monbutton.setHorizontalAlignment(SwingConstants.CENTER);
        monbutton.setForeground(Color.white);
        monbutton.setBounds(0, 125, 100, 400);
        monbutton.addActionListener(this);
        monbutton.setBackground(new Color(0xFF9C716B, true));


        tuesbutton = new JButton("Tuesday");
        tuesbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        tuesbutton.setVerticalAlignment(SwingConstants.TOP);
        tuesbutton.setHorizontalAlignment(SwingConstants.CENTER);
        tuesbutton.setForeground(Color.white);
        tuesbutton.setBounds(100, 125, 100, 400);
        tuesbutton.addActionListener(this);
        tuesbutton.setBackground(new Color(0xFF9C716B, true));

        wedbutton = new JButton("Wednesday");
        wedbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        wedbutton.setVerticalAlignment(SwingConstants.TOP);
        wedbutton.setHorizontalAlignment(SwingConstants.CENTER);
        wedbutton.setForeground(Color.white);
        wedbutton.setBounds(200, 125, 100, 400);
        wedbutton.addActionListener(this);
        wedbutton.setBackground(new Color(0xFF9C716B, true));

        thursbutton = new JButton("Thursday");
        thursbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        thursbutton.setVerticalAlignment(SwingConstants.TOP);
        thursbutton.setHorizontalAlignment(SwingConstants.CENTER);
        thursbutton.setForeground(Color.white);
        thursbutton.setBounds(300, 125, 100, 400);
        thursbutton.addActionListener(this);
        thursbutton.setBackground(new Color(0xFF9C716B, true));

        fributton = new JButton("Friday");
        fributton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        fributton.setVerticalAlignment(SwingConstants.TOP);
        fributton.setHorizontalAlignment(SwingConstants.CENTER);
        fributton.setForeground(Color.white);
        fributton.setBounds(400, 125, 100, 400);
        fributton.addActionListener(this);
        fributton.setBackground(new Color(0xFF9C716B, true));

        satbutton = new JButton("Saturday");
        satbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        satbutton.setVerticalAlignment(SwingConstants.TOP);
        satbutton.setHorizontalAlignment(SwingConstants.CENTER);
        satbutton.setForeground(Color.white);
        satbutton.setBounds(500, 125, 100, 400);
        satbutton.addActionListener(this);
        satbutton.setBackground(new Color(0xFF9C716B, true));

        sunbutton = new JButton("Sunday");
        sunbutton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        sunbutton.setVerticalAlignment(SwingConstants.TOP);
        sunbutton.setHorizontalAlignment(SwingConstants.CENTER);
        sunbutton.setForeground(Color.white);
        sunbutton.setBounds(600, 125, 100, 400);
        sunbutton.addActionListener(this);
        sunbutton.setBackground(new Color(0xFF9C716B, true));


        frame.setVisible(true);
        frame.add(title);
        frame.add(text);
        frame.add(viewButton);
        frame.add(infoButton);
        frame.add(exit);

        frame.add(monbutton);
        frame.add(tuesbutton);
        frame.add(wedbutton);
        frame.add(thursbutton);
        frame.add(fributton);
        frame.add(satbutton);
        frame.add(sunbutton);

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            new startPage ();
            frame.dispose();

        }
        if (e.getSource() == viewButton) {
            new showSchedulePlan();
        }
        if(e.getSource()==infoButton){
            dayChoice="select";
            new GymTypeChoice(dayChoice);
            frame.dispose();
        }

        if (e.getSource() == monbutton) {
            dayChoice = "monday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == tuesbutton) {
            dayChoice = "tuesday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == wedbutton) {
            dayChoice = "wednesday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == thursbutton) {
            dayChoice = "thursday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == fributton) {
            dayChoice = "friday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == satbutton) {
            dayChoice = "saturday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        } else if (e.getSource() == sunbutton) {
            dayChoice = "sunday";
            new SelectOptionsPage(dayChoice);
            frame.dispose();
        }

    }


}
