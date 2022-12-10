/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralClass;

/**
 *
 * @author pongp
 */
public class Queue {

    private int id;
    private Customer customer;
    private Pet pet;
    private User user;
    
    public Queue() {
        this(0, null, null, null);
    }

    public Queue(int id, Customer customer, Pet pet, User user) {
        this.id = id;
        this.customer = customer;
        this.pet = pet;
        this.user = user;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
