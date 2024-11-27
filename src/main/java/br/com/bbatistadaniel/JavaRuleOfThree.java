package br.com.bbatistadaniel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class JavaRuleOfThree extends JFrame {

    private GridBagConstraints gbc = new GridBagConstraints();

    public static void main(String[] args) {

        new JavaRuleOfThree();

    }

    private JavaRuleOfThree() {

        ArrayList<JTextArea> textAreas = new ArrayList<JTextArea>();
        for (int i = 0; i < 4; i++) {

            textAreas.add(new JTextArea());

        }

        setTitle("Java Rule of Three Calculator");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JavaRuleOfThree.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUIManager();
        pack();
        setVisible(true);

    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        add(component, gbc);

    }

    private void setUIManager() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception f) {
                f.printStackTrace();
                System.exit(1);
            }
        }
    }

}