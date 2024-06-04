package org.example;



public class Plant {
    // Protected Attributes
    protected String name;
    protected String species;
    protected String soilType;
    protected double price;

    // Constructor
    public Plant(String name, String species, String soilType, double price) {
        this.name = name;
        this.species = species;
        this.soilType = soilType;
        this.price = price;
    }
    @Override
    public String toString() {
        return "PLANT NAME: " + name + "\nPLANT SPECIES: " + species + "\nSOIL TYPE: " + soilType
                + "\nPRICE: " + price + "\n";
    }

}