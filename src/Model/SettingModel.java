/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GeneralClass.Customer;
import GeneralClass.Pet;
import java.sql.*;
import java.util.*;
/**
 *
 * @author supakit
 */
public class SettingModel {
    
    // Changing password by receiving new password input 
    public void changePassword(String username, String password){
        try {
            String sql = "UPDATE users SET password = ? WHERE username = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setString(1, password);
            pre.setString(2, username);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err changePassword");
            ex.printStackTrace();
        }
    }
    
    // Deleting Account
    public void deleteAccount(String username){
        try {
            String sql = "DELETE FROM users WHERE username = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setString(1, username);
            pre.executeUpdate();
        } catch (SQLException ex){
            System.out.println("err delAccount");
            ex.printStackTrace();
        }
    }
    
    
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
}
