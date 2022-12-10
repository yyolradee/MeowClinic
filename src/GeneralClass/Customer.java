/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralClass;

import java.util.LinkedList;

/**
 *
 * @author pongp
 */
public class Customer {

    private int id;
    private String fname, lname, phone;
    private LinkedList<Pet> pets;

    public Customer() {
        this(0, "", "", "", null);
    }
    
    public Customer(int id, String fname, String lname, String phone) {
        this(id, fname, lname, phone, null);
    }

    public Customer(int id, String fname, String lname, String phone, LinkedList pets) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.pets = pets;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setFirstName(String fname) {
        this.fname = fname;
    }

    public String getFirstName() {
        return this.fname;
    }

    public void setLastName(String lname) {
        this.lname = lname;
    }

    public String getLastName() {
        return this.lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPets(LinkedList pets) {
        this.pets = pets;
    }
    
    public LinkedList getPets() {
        return this.pets;
    }
}
