/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GeneralClass.Customer;
import GeneralClass.Pet;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author pongp
 */
public class RecordModel {

    // --------------------------------------------- Start  Cutomer ---------------------------------------------
    public LinkedList<Customer> getCustomers() {
        // get all customer
        LinkedList<Customer> customers = new LinkedList<Customer>();
        String sql = "SELECT * FROM customers";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                customers.add(new Customer(rec.getInt("id"), rec.getString("firstName"), rec.getString("lastName"), rec.getString("phone"), getPets(rec.getInt("id"))));
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomer(int id) {
        //  find customer by id
        try {
            String sql = "SELECT * FROM customers WHERE id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rec = pre.executeQuery();
            if ((rec != null) && (rec.next())) {
                return new Customer(rec.getInt("id"), rec.getString("firstName"), rec.getString("lastName"), rec.getString("phone"), getPets(rec.getInt("id")));
            }
        } catch (SQLException ex) {
            System.out.println("err getCustomer");
            ex.printStackTrace();
        }
        return null;
    }

    public Customer addCustomer(String fname, String lname, String phone) {
        // add customer to db
        try {
            String sql = "INSERT INTO customers (firstName,lastName,phone) values (?, ?, ?)";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, fname);
            pre.setString(2, lname);
            pre.setString(3, phone);
            pre.executeUpdate();
            ResultSet rec = pre.getGeneratedKeys();
            if ((rec != null) && (rec.next())) {
                return new Customer(rec.getInt(1), fname, lname, phone, getPets(rec.getInt(1)));
            }
        } catch (SQLException ex) {
            System.out.println("err addCustomer");
            ex.printStackTrace();
        }
        return null;
    }

    public void delCustomer(int id) {
        // delete customer by id
        try {
            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err delCustomer");
            ex.printStackTrace();
        }
    }

    public Customer updateCustomer(int id, String fname, String lname, String phone) {
        // update customer by id
        try {
            String sql = "UPDATE customers SET firstName = ?, lastName = ?, phone = ? WHERE id = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setString(1, fname);
            pre.setString(2, lname);
            pre.setString(3, phone);
            pre.setInt(4, id);
            int exe = pre.executeUpdate();
            if (exe == 1) {
                return new Customer(id, fname, lname, phone);
            }
        } catch (SQLException ex) {
            System.out.println("err updateCustomer");
            ex.printStackTrace();
        }
        return null;
    }
    // --------------------------------------------- End  Cutomer ---------------------------------------------

    // --------------------------------------------- Start  Pet ---------------------------------------------
    public LinkedList<Pet> getPets(int id) {
        // get all pets of customer (use id to find)
        LinkedList<Pet> pets = new LinkedList<Pet>();
        try {
            String sql = "SELECT * FROM pets WHERE customer_id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rec = pre.executeQuery();
            while ((rec != null) && (rec.next())) {
                pets.add(new Pet(rec.getInt("id"), rec.getInt("customer_id"), rec.getString("name"), rec.getDouble("weight"), rec.getString("color"), rec.getString("type"), rec.getString("species")));
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return pets;
    }

    public Pet getPet(int id) {
        //  get one pet by id
        try {
            String sql = "SELECT * FROM pets WHERE id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rec = pre.executeQuery();
            if ((rec != null) && (rec.next())) {
                return new Pet(rec.getInt("id"), rec.getInt("customer_id"), rec.getString("name"), rec.getInt("weight"), rec.getString("color"), rec.getString("type"), rec.getString("species"));
            }
        } catch (SQLException ex) {
            System.out.println("err customer");
            ex.printStackTrace();
        }
        return null;
    }

    public Pet addPet(int customer_id, String name, double weight, String color, String type, String species) {
        // add customer pet (use customer id to add)
        try {
            String sql = "INSERT INTO pets (customer_id,name,weight,color,type,species) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, customer_id);
            pre.setString(2, name);
            pre.setDouble(3, weight);
            pre.setString(4, color);
            pre.setString(5, type);
            pre.setString(6, species);
            pre.executeUpdate();
            ResultSet rec = pre.getGeneratedKeys();
            if ((rec != null) && (rec.next())) {
                return new Pet(rec.getInt(1), customer_id, name, weight, color, type, species);
            }
        } catch (SQLException ex) {
            System.out.println("err addPet");
            ex.printStackTrace();
        }
        return null;
    }

    public void delPet(int id) {
        // del pet by pet id
        try {
            String sql = "DELETE FROM pets WHERE id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err delPet");
            ex.printStackTrace();
        }
    }

    public Pet updatePet(int id, int customer_id, String name, double weight, String color, String type, String species) {
        // update pet data by pet id
        try {
            String sql = "UPDATE pets SET customer_id = ?, name = ?, weight = ?, color = ?, type = ?, species = ? WHERE id = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, customer_id);
            pre.setString(2, name);
            pre.setDouble(3, weight);
            pre.setString(4, color);
            pre.setString(5, type);
            pre.setString(6, species);
            pre.setInt(7, id);
            int exe = pre.executeUpdate();
            if (exe == 1) {
                return new Pet(id, customer_id, name, weight, color, type, species);
            }
        } catch (SQLException ex) {
            System.out.println("err updatePet");
            ex.printStackTrace();
        }
        return null;
    }

    // --------------------------------------------- End  Pet ---------------------------------------------
}
