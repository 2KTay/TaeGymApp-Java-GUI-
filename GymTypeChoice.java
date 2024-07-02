/**
 * This class displays a window for the user to display exercise information like what type of workout you want.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymTypeChoice implements ActionListener {

    JFrame frame;
    JLabel questionLabel;

    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;

    JButton submitButton,exit;

    static String typeChoice;
    String date;

    public GymTypeChoice(String date) {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(714, 350);
        frame.getContentPane().setBackground(new Color(0x000B9A));

        questionLabel = new JLabel("Which type of Gym workout do you prefer?");
        questionLabel.setBounds(50, 20, 600, 30);
        questionLabel.setForeground(new Color(0xFFFFFF));
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel);

        choice1 = new JRadioButton("Power: 1-5 reps, explosive movement to create athleticism");
        choice1.setBounds(50, 60, 600, 30);
        choice1.setBackground(new Color(0x000B9A));
        choice1.setForeground(Color.WHITE);

        choice2 = new JRadioButton("Strength: 5-8 reps, strong, secure lifts to create strength");
        choice2.setBounds(50, 100, 600, 30);
        choice2.setBackground(new Color(0x000B9A));
        choice2.setForeground(Color.WHITE);

        choice3 = new JRadioButton("Hypertrophy: 8-12 reps, slow lifts to create maximum muscle growth");
        choice3.setBounds(50, 140, 600, 30);
        choice3.setBackground(new Color(0x000B9A));
        choice3.setForeground(Color.WHITE);

        exit=new JButton("Exit");
        exit.setBounds(400, 200, 100, 30);
        exit.addActionListener(this);

        ButtonGroup choicesGroup = new ButtonGroup();
        choicesGroup.add(choice1);
        choicesGroup.add(choice2);
        choicesGroup.add(choice3);

        frame.add(choice1);
        frame.add(choice2);
        frame.add(choice3);
        frame.add(exit);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(this);
        frame.add(submitButton);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            new GymAppPage ();
            frame.dispose();

        }
        if (e.getSource() == submitButton) {
            if (choice1.isSelected()) {
                typeChoice ="power";


            } else if (choice2.isSelected()) {
                typeChoice ="strength";

            } else if (choice3.isSelected()) {
                typeChoice="hyper";

            } else {
                JOptionPane.showMessageDialog(frame, "Please select an option.");
            }
            String fileName = User.username + ".csv";
            Schedule.addType(GymAppPage.dayChoice, typeChoice, fileName);
            String fileTypeChoice = typeChoice + ".csv";
            new WorkoutTypeChoice(fileTypeChoice);
            frame.dispose();


        }
    }
}