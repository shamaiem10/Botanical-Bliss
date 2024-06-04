package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PlantCareTips {
    private static JButton searchButton;

    public static void Tips() {
        // Create the frame
        JFrame frame = new JFrame("Plain Pink Window");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Set the background color of the frame's content pane to pink
        frame.getContentPane().setBackground(new Color(0xD8B9C3));

        // Create a panel to hold the button
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xD8B9C3)); // Set panel background to the specified color


        // Create a panel to hold the button

        // Create the search button
        JButton searchButton = new JButton("Search by Name");
        searchButton.setBorder(new LineBorder(Color.BLACK));
        searchButton.setBackground(new Color(156, 77, 91)); // Set button background to brown
        searchButton.setPreferredSize(new Dimension(200, 50)); // Make the button a bit bigger

        // Add the button to the panel with GridBagConstraints to center it
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(searchButton, gbc);

        // Add the button to the panel
        panel.add(searchButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);

    searchButton.setForeground(Color.WHITE); searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a custom JPanel with a pink background
                JPanel panel = new JPanel();
                panel.setBackground(new Color(255, 182, 193)); // Light pink background

                JLabel label = new JLabel("Enter the plant name:");
                label.setForeground(Color.BLACK); // Set label text color to black
                panel.add(label);

                JTextField textField = new JTextField(10);
                panel.add(textField);

                int result = JOptionPane.showConfirmDialog(frame, panel, "Plant Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    String plantName = textField.getText();
                    if (plantName != null && !plantName.isEmpty()) {
                        searchPlantByName(plantName);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a plant name.");
                    }
                }
            }

        });
        panel.add(searchButton, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void searchPlantByName(String plantName) {
        // Implement the search functionality here
        String filePath = "C:\\Users\\shama\\Desktop\\plant_care_tips.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;
            StringBuilder tips = new StringBuilder();

            // Search for the plant name and collect the next three lines
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(plantName)) {
                    found = true;
                    // Collect the next three lines
                    for (int i = 0; i < 3; i++) {
                        line = reader.readLine();
                        if (line != null) {
                            tips.append(line).append("\n");
                        }
                    }
                    break;
                }
            }

            if (found) {
                // Create a new window to display the plant care tips

                    JFrame tipsFrame = new JFrame("Plant Care Tips for " + plantName);
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBackground(new Color(216, 185, 195)); // Light green background for JPanel

                    tipsFrame.getContentPane().setBackground(new Color(216, 185, 195)); // Light green background for JFrame
                    JTextArea tipsArea = new JTextArea(tips.toString());
                    tipsArea.setEditable(false);
                    tipsArea.setBackground(new Color(255, 182, 193)); // Light pink background for JTextArea
                    tipsArea.setForeground(Color.WHITE); // White text color for JTextArea
                    JScrollPane scrollPane = new JScrollPane(tipsArea);

                    tipsFrame.add(scrollPane);
                    tipsFrame.setSize(400, 300);
                    tipsFrame.setLocationRelativeTo(null);
                    tipsFrame.setVisible(true);
                }




        else {
                JOptionPane.showMessageDialog(null, "Plant not found.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tips();
            }
        });
    }
}
