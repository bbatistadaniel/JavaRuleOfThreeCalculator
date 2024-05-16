import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;

public class Main {

    // Define font and clipboard objects
    public static Font font = new Font("Roboto", Font.BOLD, 17);
    public static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static void main(String[] args){
        // Create main window
        JFrame window = new JFrame("Rule of Three Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(320, 170));
        window.setResizable(false);
        window.setLayout(new GridBagLayout());

        // Define layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create text fields and labels
        JTextField a = new JTextField();
        JTextField b = new JTextField();
        JTextField c = new JTextField();
        JLabel d = new JLabel("X"); // Result label
        JLabel e = new JLabel("-"); // Separator label
        JLabel f = new JLabel("-"); // Separator label
        JButton g = new JButton("Calculate"); // Calculate button
        JButton h = new JButton("Copy"); // Copy button

        // Set preferred sizes and font for components
        a.setPreferredSize(new Dimension(100, 30));
        b.setPreferredSize(new Dimension(100, 30));
        c.setPreferredSize(new Dimension(100, 30));
        d.setFont(font);
        e.setFont(font);
        f.setFont(font);
        g.setPreferredSize(new Dimension(100, 30));
        h.setPreferredSize(new Dimension(100, 30));

        // Add action listeners for buttons
        g.addActionListener(_ -> {
            calculate(a, b, c, d); // Calculate result
        });

        h.addActionListener(_ -> {
            copy(d, clipboard); // Copy result to clipboard
        });

        // Add components to the window using grid bag layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        window.add(a, gbc);

        gbc.gridx = 2;
        window.add(b, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        window.add(c, gbc);

        gbc.gridx = 2;
        window.add(d, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        window.add(e, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        window.add(f, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        window.add(g, gbc);

        gbc.gridx = 2;
        window.add(h, gbc);

        // Make the window visible
        window.setVisible(true);
    }

    // Method to calculate result based on input values
    static void calculate(JTextField a, JTextField b, JTextField c, JLabel d){
        try {
            // Calculate and display the result
            d.setText(String.valueOf((Float.parseFloat(b.getText())*Float.parseFloat(c.getText()))/Float.parseFloat(a.getText())));
        } catch (Exception e){
            // If an error occurs (e.g., division by zero), display "X"
            d.setText("X");
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
