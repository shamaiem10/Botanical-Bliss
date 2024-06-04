# Botanical-Bliss
Plant Nursery Management System
# Overview
Botanical Bliss is a Java-based graphical application designed to simulate a plant nursery system. The application allows users to purchase plants, view plant care tips, and manage their cart of selected plants. The interface is built using Java Swing, and it features a visually appealing design with custom graphics.

# Features

1. Purchase Plants: Browse and add plants to the cart.
2. Plant Care Tips: View useful tips for taking care of plants.
3. Add Plants: Add new plants to the system.
4. Custom Graphics: Includes a custom background with randomly drawn flowers.
# Classes
PlantNurserySystem
This is the main class that extends JFrame and sets up the initial user interface.

PlantCareTips
Class that handles the display of plant care tips.

AddPlant
Class that handles adding plants to the system.

Plant
A simple class representing a plant with attributes such as name, species, soil type, and price.

# How to Run
Ensure you have JDK installed on your machine.
Clone or download the project to your local machine.
Navigate to the project directory.
Compile the Java files and run.

# File Structure
src/org/example/PlantNurserySystem.java: Main application class.
src/org/example/PlantCareTips.java: Handles plant care tips.
src/org/example/AddPlant.java: Handles adding plants to the system.
src/org/example/Plant.java: Represents a plant entity.
resources/plants.txt: Sample file containing plant information.
resources/plant_care_tips.txt: Sample file containing plant care tips.

# Class Information
1. PlantNurserySystem
This class sets up the main window and initial user interface. It features a custom panel with a background that includes randomly drawn flowers. When the user clicks on the main window, a new window opens with options to purchase plants, view plant care tips, and add plants.

2. PlantCareTips
This class provides functionality to view plant care tips. Users can search for a plant by name and see the corresponding care tips. The care tips are read from a text file and displayed in a new window.

3. AddPlant
This class allows users to add new plants to the system. Users can enter the name, species, soil type, and price of a plant. The plant information is then saved to a file.

4. Plant
This class represents a plant entity with attributes such as name, species, soil type, and price. It includes a constructor to initialize these attributes and a toString method to provide a string representation of the plant.


# Author
1. Shamaiem Shabbir
2. Maryam Sheraz
3. Maryam Tariq
