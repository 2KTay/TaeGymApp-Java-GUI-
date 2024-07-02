/**
 * This class shows the information of the exercises available
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseTypeChoice extends JFrame implements ActionListener {

    JButton submitButton, infoButton,backButton;
    JFrame frame;
    JLabel title, instruction, listExers;
    JTextField textField;

    ExerciseTypeChoice(String textFieldChoice) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(650, 700);
        frame.getContentPane().setBackground(new Color(0x000B9A));

        // Title with application name and message
        title = new JLabel("<html><div style='text-align:center;'>Tae-Gym App<br>Please add an exercise</div></html>");
        title.setForeground(Color.white);
        title.setBounds(50, 20, 550, 100);
        title.setFont(new Font("Comic Sans", Font.BOLD, 30));

        // Instruction label for additional message
        instruction = new JLabel("Please enter your exercise choice below:");
        instruction.setForeground(new Color(0xFFFFFF));
        instruction.setBounds(50, 120, 600, 30);
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));

        textField = new JTextField();
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setForeground(new Color(0xEDFFFFFF, true));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setBounds(50, 160, 550, 40);  // Adjusted textField position

        String fileTypeChoice = GymTypeChoice.typeChoice + ".csv";
        String exer = Exercise.showExer(textFieldChoice, fileTypeChoice, ",", 1);

        listExers = new JLabel();
        if (exer != null) {
            listExers.setText("<html>" + exer.replaceAll("\n", "<br>") + "</html>");
        } else {
            listExers.setText("No workout data available.");
        }
        listExers.setBounds(50, 210, 600, 300);
        listExers.setForeground(new Color(0xFFFFFF));
        listExers.setFont(new Font("Arial", Font.BOLD, 16));

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 600, 100, 30);
        submitButton.addActionListener(this);

        infoButton = new JButton("View");
        infoButton.setBounds(500, 600, 100, 30);
        infoButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(200, 600, 100, 30);
        backButton.addActionListener(this);

        frame.add(title);         // Add the title to the frame
        frame.add(instruction);   // Add the instruction to the frame
        frame.add(infoButton);
        frame.add(listExers);
        frame.add(submitButton);
        frame.add(backButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton){
            frame.dispose();
            String fileTypeChoice = GymTypeChoice.typeChoice + ".csv";
            new WorkoutTypeChoice(fileTypeChoice);
        }
        if (e.getSource() == infoButton) {
            String exerChoice = textField.getText();
            new showExerciseInfo(exerChoice);

        }
        if (e.getSource() == submitButton) {
            String exerChoice = textField.getText();
            String fileTypeChoice = GymTypeChoice.typeChoice + ".csv";
            String fileName = User.username + ".csv";

            String[] exercisesForWorkout = Exercise.findExercisesForWorkout(WorkoutTypeChoice.workChoice, fileTypeChoice, ",");
            if (Exercise.isWorkoutValid(WorkoutTypeChoice.workChoice, exerChoice, exercisesForWorkout, ",")) {
                Exercise.addExercise(GymAppPage.dayChoice, exerChoice, fileName);
                boolean validInput = false;

                while (!validInput) {
                    int anotherWork = JOptionPane.showConfirmDialog(null,
                            "Do you want to add another workout?", "Adding another workout", JOptionPane.YES_NO_OPTION);

                    if (anotherWork == JOptionPane.NO_OPTION) {
                        if (!Schedule.checkSchedule(fileName)) {
                            JOptionPane.showMessageDialog(new JFrame(), "Need to get rid of entries or add entries", "Dialog",
                                    JOptionPane.WARNING_MESSAGE);
                        }

                        new GymAppPage();
                        frame.dispose();
                        validInput = true;
                    } else if (anotherWork == JOptionPane.YES_OPTION) {
                        new WorkoutTypeChoice(fileTypeChoice);
                        frame.dispose();
                        validInput = true;
                    }
                }
            }
        }
    }
}
