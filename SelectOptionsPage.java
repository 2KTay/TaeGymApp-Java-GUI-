/**
 * This class displays a window with options for the user to select actions like adding a workout.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectOptionsPage extends JFrame implements ActionListener {
    JFrame frame;
    JButton addButton;

    JLabel title;

    JButton exitButton,clear;



    SelectOptionsPage(String date) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(714, 700);
        frame.getContentPane().setBackground(new Color(0x000B9A));

        addButton = new JButton("Add Workout");
        addButton.setBounds(0, 250, 200, 50);
        addButton.addActionListener(this);

        clear = new JButton("Clear the day");
        clear.setBounds(250, 250, 200, 50);
        clear.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(500, 250, 200, 50);
        exitButton.addActionListener(this);

        title = new JLabel("Tae-Gym App ");
        title.setForeground(Color.white);
        title.setBounds(150, 2, 400, 200);
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));

        frame.add(addButton);
        frame.add(title);
        frame.add(clear);
        frame.add(exitButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            int clearDay = JOptionPane.showConfirmDialog(null,
                    "Do you want to clear this day? (Erasing entire day", "Erasing the day", JOptionPane.YES_NO_OPTION);
            if(clearDay == JOptionPane.YES_OPTION){
                String fileName = User.username + ".csv";
                FileHandler.clearWeekDay(fileName,GymAppPage.dayChoice);
                frame.dispose();
                new GymAppPage();
            }
        }
        if (e.getSource() == addButton) {


            new GymTypeChoice(GymAppPage.dayChoice);
            frame.dispose();


        } else if (e.getSource() == exitButton) {

            frame.dispose();
            new GymAppPage();
        }
    }
}