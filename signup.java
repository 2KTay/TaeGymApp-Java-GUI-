/**
 * This class creates the signup page for the Tae-GymApp. It allows users to
 * enter a username and password to create an account. If the account creation
 * is successful, the user goes to the start page.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class signup extends JFrame implements ActionListener {

    JButton button;
    JButton exit;
    JTextField textFieldUN;

    JTextField textFieldPW;

    JLabel title;
    JLabel sign;
    JLabel labelUN;
    JLabel labelPW;

    signup() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Tae-GymApp");
        this.setSize(650, 700);
        this.getContentPane().setBackground(new Color(0x000B9A));

        button = new JButton("Submit");
        button.setBounds(250, 450, 100, 50);
        button.addActionListener(this);

        exit=new JButton("Exit");
        exit.setBounds(400, 450, 100, 50);
        exit.addActionListener(this);


        title = new JLabel("Tae-Gym App ");
        title.setForeground(Color.white);
        title.setBounds(150, 2, 400, 200);
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));

        sign = new JLabel("Sign-Up");
        sign.setForeground(Color.white);
        sign.setBounds(225, 100, 400, 200);
        sign.setFont(new Font("Comic Sans", Font.PLAIN, 40));


        labelUN = new JLabel("Username: ");
        labelUN.setForeground(Color.white);
        labelUN.setBounds(150, 300, 100, 50);

        labelPW = new JLabel("Password: ");
        labelPW.setForeground(Color.white);
        labelPW.setBounds(150, 350, 100, 50);


        textFieldUN = new JTextField();
        textFieldUN.setFont(new Font("Consolas", Font.PLAIN, 20));
        textFieldUN.setForeground(new Color(0xEDFFFFFF, true));
        textFieldUN.setBackground(Color.black);
        textFieldUN.setCaretColor(Color.white);
        textFieldUN.setBounds(250, 300, 250, 40);


        textFieldPW = new JTextField();
        textFieldPW.setFont(new Font("Consolas", Font.PLAIN, 20));
        textFieldPW.setForeground(new Color(0xFFFFFF));
        textFieldPW.setBackground(Color.black);
        textFieldPW.setCaretColor(Color.white);
        textFieldPW.setBounds(250, 350, 250, 40);

        this.add(button);
        this.add(title);
        this.add(exit);
        this.add(sign);
        this.add(labelUN);
        this.add(labelPW);
        this.add(textFieldUN);
        this.add(textFieldPW);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String logUN = textFieldUN.getText();
            String logPW = textFieldPW.getText();

            //checks if the username is acceptable
            if (User.makeAccount(logUN, logPW)) {

                //goes to the main Page
               new startPage();
               this.dispose();
                User.username = logUN;
                User.password = logPW;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Please try again. Username not accepted", "Dialog",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        if(e.getSource() == exit){
            new startPage ();
            this.dispose();

        }


    }

}