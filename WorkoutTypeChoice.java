/**
*this class shows the information of the workouts available
*
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutTypeChoice extends JFrame implements ActionListener {
    JButton submitButton, backButton;

    JFrame frame;

    JLabel title;
    JLabel listWorkouts;
    JLabel instruction;
    JTextField textField;

    static String workChoice;

    WorkoutTypeChoice(String fileTypeChoice) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(650, 700);
        frame.getContentPane().setBackground(new Color(0x000B9A));


        title = new JLabel("<html><div style='text-align:center;'>Tae-Gym App<br>Please add a workout</div></html>");
        title.setForeground(Color.white);
        title.setBounds(50, 20, 550, 100);
        title.setFont(new Font("Comic Sans", Font.BOLD, 30));
        
        instruction = new JLabel("Please enter your workout choice below:");
        instruction.setForeground(new Color(0xFFFFFF));
        instruction.setBounds(50, 120, 600, 30);
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));

        textField = new JTextField();
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setForeground(new Color(0xEDFFFFFF, true));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setBounds(300, 150, 250, 40);

        String workout = Workout.showWorkout(fileTypeChoice);

        listWorkouts = new JLabel();
        if (workout != null) {
            listWorkouts.setText("<html>" + workout.replaceAll("\n", "<br>") + "</html>");
        } else {
            listWorkouts.setText("No workout data available.");
        }
        listWorkouts.setBounds(50, 200, 600, 300);
        listWorkouts.setForeground(new Color(0xFFFFFF));
        listWorkouts.setFont(new Font("Arial", Font.BOLD, 16));

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 600, 100, 30);
        submitButton.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setBounds(200, 600, 100, 30);
        backButton.addActionListener(this);


        frame.add(submitButton);
        frame.add(listWorkouts);
        frame.add(backButton);
        frame.add(textField);
        frame.add(title);
        frame.add(instruction);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton){
            frame.dispose();
            new GymTypeChoice(GymAppPage.dayChoice);
        }
        if (e.getSource() == submitButton) {
            String fileTypeChoice = GymTypeChoice.typeChoice + ".csv";
            String fileName = User.username + ".csv";

            workChoice = textField.getText();

            if (Workout.checkWorkout(fileTypeChoice, workChoice)) {
                Workout.addWorkout(GymAppPage.dayChoice, workChoice, fileName);
                new ExerciseTypeChoice(workChoice);
                frame.dispose();
            }
        }
    }
}
