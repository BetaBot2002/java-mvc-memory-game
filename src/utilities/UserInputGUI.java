package utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputGUI extends JFrame {
    private int numberOfUniqueCards;
    private boolean inputSubmitted;

    public UserInputGUI() {
        setTitle("Memory Game Setup");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Enter the number of unique cards (n):");
        label.setBounds(30, 20, 220, 25);
        add(label);

        JTextField textField = new JTextField();
        textField.setBounds(30, 50, 220, 25);
        add(textField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 80, 80, 30);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int input = Integer.parseInt(textField.getText());
                    if (input > 0) {
                        numberOfUniqueCards = input;
                        inputSubmitted = true;
                        dispose(); // Close the input window
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
    }

    public int getNumberOfUniqueCards() {
        while (!inputSubmitted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return numberOfUniqueCards;
    }
}
