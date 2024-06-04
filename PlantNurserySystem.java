package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class PlantNurserySystem extends JFrame {

    private List<String> cart = new ArrayList<>();
    private DefaultListModel<String> plantListModel = new DefaultListModel<>();
    public PlantNurserySystem() {
        setTitle("BOTANICAL BLISS");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel with dark green background color
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(216, 185, 195));
                g.fillRect(0, 0, getWidth(), getHeight());
                drawFlowers(g, getWidth(), getHeight());

            }

            // Method to draw tiny flowers
            private void drawFlowers(Graphics g, int panelWidth, int panelHeight) {
                // Define flower colors
                Color[] flowerColors = {Color.RED, Color.YELLOW, Color.PINK, Color.ORANGE};

                // Set transparency for flowers
                Graphics2D g2d = (Graphics2D) g;
                AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
                g2d.setComposite(alphaComposite);

                // Draw flowers
                Random random = new Random();
                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(panelWidth);
                    int y = random.nextInt(panelHeight);
                    int flowerSize = random.nextInt(20) + 10; // Random size between 10 and 30

                    // Randomly choose a flower color
                    Color flowerColor = flowerColors[random.nextInt(flowerColors.length)];
                    g2d.setColor(flowerColor);

                    // Draw flower shape
                    g2d.fillOval(x, y, flowerSize, flowerSize);
                    g2d.fillOval(x - flowerSize / 2, y - flowerSize / 2, flowerSize, flowerSize);
                    g2d.fillOval(x + flowerSize / 2, y - flowerSize / 2, flowerSize, flowerSize);
                    g2d.fillOval(x - flowerSize / 2, y + flowerSize / 2, flowerSize, flowerSize);
                    g2d.fillOval(x + flowerSize / 2, y + flowerSize / 2, flowerSize, flowerSize);
                }
            }
        };
        // Set layout to center components vertically and horizontally
        panel.setLayout(new GridBagLayout());
        JLabel label = new JLabel("BOTANICAL BLISS");
        label.setForeground(Color.WHITE); // Set text color to white
        label.setFont(new Font("Arial", Font.BOLD, 50)); // Set font and size
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center align text

        // Create a border for the label
        label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 20)); // Black border with thickness 2 pixels

           // Add label to the panel
        panel.add(label);

        // Add mouse listener to the panel
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewWindow();
            }
        });

        // Add panel to the frame
        add(panel);
    }

    // Method to open a new window with dark green color
    private void openNewWindow() {
        JFrame newFrame = new JFrame();
        newFrame.setTitle("New Window");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);

        // Create a panel with dark green background color
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(216, 185, 195)); // Dark green color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Set layout to center components vertically and horizontally
        panel.setLayout(new GridBagLayout());

        // Create buttons for "Purchase Plants", "Plant Care Tips", and "Add Plants"
        JButton btnPurchasePlants = new JButton("Purchase Plants");
        JButton btnPlantCareTips = new JButton("Plant Care Tips");
        JButton btnAddPlants = new JButton("Add Plants");
        Font buttonFont = new Font(btnPurchasePlants.getFont().getName(), Font.CENTER_BASELINE, 20); // Adjust the font size as needed
        btnPurchasePlants.setFont(buttonFont);
        btnPlantCareTips.setFont(buttonFont);
        btnAddPlants.setFont(buttonFont);
        Color contentColor = Color.WHITE; // Change the color as needed
        btnPurchasePlants.setForeground(contentColor);
        btnPlantCareTips.setForeground(contentColor);
        btnAddPlants.setForeground(contentColor);
// Set background color of buttons to light green
        Color lightGreen = new Color(156, 77, 91);
        btnPurchasePlants.setBackground(lightGreen);
        btnPlantCareTips.setBackground(lightGreen);
        btnAddPlants.setBackground(lightGreen);

// Set preferred size for the buttons
        Dimension buttonSize = new Dimension(200, 50); // Adjust the width and height as needed
        btnPurchasePlants.setPreferredSize(buttonSize);
        btnPlantCareTips.setPreferredSize(buttonSize);
        btnAddPlants.setPreferredSize(buttonSize);

        // Add action listeners to buttons
        btnPurchasePlants.addActionListener(e -> {
            // Add functionality to purchase plants
            createPlantsFile("C:\\Users\\shama\\Desktop\\plants.txt"); // Call method to create plants file
           showPurchasePlantsWindow();
        });

        btnPlantCareTips.addActionListener(e -> {
            // Add functionality to display plant care tips
             createPlantCareTipsFile("C:\\Users\\shama\\Desktop\\plant_care_tips.txt");
            PlantCareTips.Tips();// Call method to create plant care tips file
        });


        btnAddPlants.addActionListener(e -> {
            // Add functionality to add plants to the cart
             addToCart("C:\\Users\\shama\\Desktop\\cart.txt"); // Call method to add plants to the cart
           new AddPlant();
        });


        // Add buttons to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(btnPurchasePlants, gbc);

        gbc.gridy = 1;
        panel.add(btnPlantCareTips, gbc);

        gbc.gridy = 3; // Increment the gridy to move to the next row
        panel.add(btnAddPlants, gbc);

        newFrame.add(panel);
        newFrame.setVisible(true);
    }
    private void showPurchasePlantsWindow() {
        JFrame purchaseFrame = new JFrame("Purchase Plants");
        purchaseFrame.setSize(400, 300);
        purchaseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        purchaseFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JList<String> plantList = new JList<>(plantListModel);
        JScrollPane scrollPane = new JScrollPane(plantList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setBackground(new Color(156, 77, 91)); // Pink color
        Color contentColor = Color.WHITE; // Change the color as needed
        btnAddToCart.setForeground(contentColor);

        btnAddToCart.addActionListener(e -> {
            String selectedPlant = plantList.getSelectedValue();
            if (selectedPlant != null) {
                cart.add(selectedPlant);
                JOptionPane.showMessageDialog(purchaseFrame, selectedPlant + " added to cart!");
            }
        });

        JButton btnShowBill = new JButton("Show Bill");
        contentColor = Color.WHITE;
        btnShowBill.setForeground(contentColor);

        btnShowBill.setBackground(new Color(156, 77, 91)); // Pink color

        btnShowBill.addActionListener(e -> showBill());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddToCart);
        buttonPanel.add(btnShowBill);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        purchaseFrame.add(panel);
        purchaseFrame.setVisible(true);

        loadPlantsFromFile("C:\\Users\\shama\\Desktop\\plants.txt");
    }
    private void loadPlantsFromFile(String filePath) {
        plantListModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                plantListModel.addElement(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading plants file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void showBill() {
        JFrame billFrame = new JFrame("Bill");
        billFrame.setSize(400, 300);
        billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        billFrame.setLocationRelativeTo(null);

        JTextArea billText = new JTextArea();
        billText.setEditable(false);

        // Set the background color of the JTextArea
        billText.setBackground(new Color(216, 185, 195)); // Pink color

        // Set the font size and text color
        Font textFont = new Font(billText.getFont().getName(), Font.PLAIN, 20); // Increase font size to 16
        billText.setFont(textFont);
        billText.setForeground(Color.WHITE); // Set text color to black

        double total = 0;
        StringBuilder billContent = new StringBuilder("Your Purchases:\n\n");
        for (String item : cart) {
            billContent.append(item).append("\n");
            total += extractPrice(item);
        }
        billContent.append("\nTotal Price: $").append(total);

        billText.setText(billContent.toString());

        JScrollPane scrollPane = new JScrollPane(billText);

        // Set the background color of the JScrollPane's viewport
        scrollPane.getViewport().setBackground(new Color(216, 185, 195)); // Pink color

        billFrame.add(scrollPane);
        billFrame.setVisible(true);
    }


    private double extractPrice(String plant) {
        // This assumes the price is the last word in the plant description.
        String[] parts = plant.split(" ");
        for (String part : parts) {
            if (part.startsWith("$")) {
                try {
                    return Double.parseDouble(part.substring(1));
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        }
        return 0;
    }
    // Method to create a file for plants
    private void createPlantsFile(String filePath) {
        File plantsFile = new File(filePath);
        try {
            if (plantsFile.createNewFile()) {
                System.out.println("File created: " + plantsFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Method to create a file for plant care tips
    private void createPlantCareTipsFile(String filePath) {
        File plantCareTipsFile = new File(filePath);
        try {
            if (plantCareTipsFile.createNewFile()) {
                System.out.println("File created: " + plantCareTipsFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void addToCart(String filePath) {
        File plantCareTipsFile = new File(filePath);
        try {
            if (plantCareTipsFile.createNewFile()) {
                System.out.println("File created: " + plantCareTipsFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PlantNurserySystem().setVisible(true);
        });
    }
}
