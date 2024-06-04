package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

class AddPlant extends JFrame implements ActionListener {
    private static final String PLANTS_FILE_PATH = "C:\\Users\\DELL\\OneDrive\\Desktop\\plants.txt";

    private JTextField nameField, speciesField, soilTypeField, priceField;
    private JButton submitButton;

    public AddPlant() {
        setTitle("Add Plant");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400); // Set the size of the dialog box
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(216, 185, 195)); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(createLabel("Name:"), gbc);
        gbc.gridx = 1;
        nameField = createTextField();
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(createLabel("Species:"), gbc);
        gbc.gridx = 1;
        speciesField = createTextField();
        add(speciesField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(createLabel("Soil Type:"), gbc);
        gbc.gridx = 1;
        soilTypeField = createTextField();
        add(soilTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(createLabel("Price:"), gbc);
        gbc.gridx = 1;
        priceField = createTextField();
        add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        submitButton = createButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.WHITE); // Set text color to white
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setForeground(Color.BLACK);
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(156, 77, 91)); // Set button background color
        button.setPreferredSize(new Dimension(200, 50)); // Set preferred size
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String species = speciesField.getText();
            String soilType = soilTypeField.getText();
            double price = Double.parseDouble(priceField.getText());

            Plant plant = new Plant(name, species, soilType, price);
            savePlantToFile(plant);

            showMessageDialog("Plant added to nursery successfully!");
            clearFields();
        }
    }

    private void clearFields() {
        nameField.setText("");
        speciesField.setText("");
        soilTypeField.setText("");
        priceField.setText("");
    }

    private void showMessageDialog(String message) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(216, 185, 195)); // Set background color
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.WHITE); // Set text color to white
        panel.add(label);
        JOptionPane.showMessageDialog(this, panel, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    public static void savePlantToFile(Plant plant) {
        try (FileWriter writer = new FileWriter(PLANTS_FILE_PATH, true)) {
            writer.write(plant.name + " (" + plant.species + ") \n" +
                    "Soil Type: " + plant.soilType + "\n" +
                    "Price Range: $" + plant.price + "\n\n---------------------------------\n\n");
        } catch (IOException e) {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(216, 185, 195)); // Set background color
            JLabel label = new JLabel("Failed to add plant to nursery: " + e.getMessage());
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(Color.WHITE); // Set text color to white
            panel.add(label);
            JOptionPane.showMessageDialog(null, panel, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}