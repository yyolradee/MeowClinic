/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralClass;

/**
 *
 * @author pongp
 */
public class Pet {

    private int id, customer_id;
    private String name, color, type, species;
    private double weight;

    public Pet() {
        this(0, 0, "", 0.0, "", "", "");
    }

    public Pet(int id, int customer_id, String name, double weight, String color, String type, String species) {
        this.id = id;
        this.customer_id = customer_id;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.type = type;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
