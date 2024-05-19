import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;

public class Main {

    public static void main(String[] args){
        // Create main window
        JFrame window = new JFrame("Rule of Three Calculator");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(new Dimension(320, 170));
        window.setResizable(false);
        window.setLayout(new GridBagLayout());
        window.setLocationRelativeTo(null);
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception e){System.out.print(e);}


        // Define layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create text fields and labels
        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        JLabel resultLabel = new JLabel("X");
        JLabel separator1 = new JLabel("-");
        JLabel separator2 = new JLabel("-");
        JButton calculateButton = new JButton("Calculate");
        JButton copyButton = new JButton("Copy");

        // Set preferred sizes for components
        int inputHeight = 24;
        int inputWidth = 90;
        input1.setPreferredSize(new Dimension(inputWidth, inputHeight));
        input2.setPreferredSize(new Dimension(inputWidth, inputHeight));
        input3.setPreferredSize(new Dimension(inputWidth, inputHeight));

        // Add action listeners for buttons
        calculateButton.addActionListener(_ -> {
            calculate(input1, input2, input3, resultLabel); // Calculate result
        });

        copyButton.addActionListener(_ -> {
            copy(resultLabel, Toolkit.getDefaultToolkit().getSystemClipboard()); // Copy result to clipboard
        });

        // Add components to the window using grid bag layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        window.add(input1, gbc);

        gbc.gridx = 2;
        window.add(input2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        window.add(input3, gbc);

        gbc.gridx = 2;
        window.add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        window.add(separator1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        window.add(separator2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        window.add(calculateButton, gbc);

        gbc.gridx = 2;
        window.add(copyButton, gbc);

        // Make the window visible
        window.setVisible(true);
    }

    // Method to calculate result based on input values
    static void calculate(JTextField input1, JTextField input2, JTextField input3, JLabel resultLabel){
        try {
            // Calculate and display the result
            resultLabel.setText(String.valueOf((Float.parseFloat(input2.getText())*Float.parseFloat(input3.getText()))/Float.parseFloat(input1.getText())));
        } catch (Exception e){
            // If an error occurs (e.g., division by zero), display "X"
            resultLabel.setText("X");
        }
    }

    // Method to copy result to clipboard
    static void copy(JLabel d, Clipboard clipboard){
        // Check if result is not "X" before copying
        if(!Objects.equals(d.getText(), "X")){
            // Create a string selection with the result and set it to the clipboard
            StringSelection selection = new StringSelection(d.getText());
            clipboard.setContents(selection, selection);
        }
    }
}
