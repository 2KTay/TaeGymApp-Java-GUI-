/**
 * This class shows the information on how to do the exercise
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showExerciseInfo extends JFrame implements ActionListener {


    JFrame frame;
    JLabel listExers;

    JButton exit;


    showExerciseInfo(String exerChoice){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Tae-GymApp");
        frame.setSize(714, 700);
        frame.getContentPane().setBackground(new Color(0x000B9A));
        String fileChoiceCSV=GymTypeChoice.typeChoice+".csv";

        String getExerInfoST=FileHandler.showExerInfo(exerChoice, fileChoiceCSV, ",", 1);


        listExers = new JLabel();
        listExers.setBounds(50, 50, 600, 350);
        listExers.setForeground(Color.WHITE);

        
        if (getExerInfoST != null) {

            listExers.setText("<html>" + getExerInfoST.replaceAll("\n", "<br>") + "</html>");

        } else {
            listExers.setText("No workout data available.");
        }

        exit=new JButton("Exit");
        exit.setBounds(400, 450, 100, 50);
        exit.addActionListener(this);




        frame.add(exit);
        frame.setVisible(true);
        frame.add(listExers);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();

        }

        }

}


