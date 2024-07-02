/**
 * This class creates a window to display the user's workout schedule.
 * The schedule is read from a CSV file named after the user's username.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showSchedulePlan extends JFrame implements ActionListener {
    JFrame showInfo;
    JLabel title,name;
    JButton exitButton;

    showSchedulePlan() {
        String fileName = User.username + ".csv";
        String fileStuff = FileHandler.printFileContents(fileName);

        showInfo = new JFrame("showInfo");
        showInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showInfo.setLayout(null);
        showInfo.setTitle("showInfo");
        showInfo.setSize(700, 500);
        showInfo.getContentPane().setBackground(new Color(0x000B9A));

        title = new JLabel("<html>" + fileStuff.replaceAll("\n", "<br>") + "</html>");
        title.setForeground(Color.white);
        title.setBounds(50, 100, 700, 200);
        title.setFont(new Font("Comic Sans", Font.BOLD, 17));

        name= new JLabel("Tae-Gym App ");
        name.setForeground(Color.white);
        name.setBounds(150, -65, 400, 200);
        name.setFont(new Font("Comic Sans", Font.BOLD, 50));

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 350, 100, 50);
        exitButton.addActionListener(this);

        showInfo.setVisible(true);
        showInfo.add(title);
        showInfo.add(name);
        showInfo.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            showInfo.dispose();
        }
    }
}
