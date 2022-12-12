/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GeneralClass.Customer;
import GeneralClass.User;
import java.sql.*;
import java.util.*;
/**
 *
 * @author supakit
 */
public class SettingModel {

    // Updating displayName in Database
    public void updateDisplayName(int id, String displayName){
        try {
            String sql = "UPDATE users SET displayName = ? WHERE id = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setString(1, displayName);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err updateDisplayName");
            ex.printStackTrace();
        }
    }
        
    
    // Changing password by receiving new password input 
    public void changePassword(int id, String password){
        try {
            String sql = "UPDATE users SET password = ? WHERE id = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setString(1, password);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err changePassword");
            ex.printStackTrace();
        }
    }
    
    // Deleting Account through ID
    public void deleteAccount(int id){
        try {
            String sql = "DELETE FROM users WHERE id = ?;";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex){
            System.out.println("err delAccount");
            ex.printStackTrace();
        }
    }
    
    public LinkedList<User> getUsers() {
        // get all User info
        LinkedList<User> users = new LinkedList<User>();
        String sql = "SELECT * FROM users";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                users.add(new User(rec.getInt("id"), rec.getString("username"), rec.getString("displayName"), rec.getString("password")));
                System.out.println(rec.getInt("id") + " " + rec.getString("username") + " " + rec.getString("displayName") + " " + rec.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return users;
    }
    
    public LinkedList<Customer> getCustomers() {
        // get all customer info
        LinkedList<Customer> customers = new LinkedList<Customer>();
        String sql = "SELECT * FROM customers";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                customers.add(new Customer(rec.getInt("id"), rec.getString("firstName"), rec.getString("lastName"), rec.getString("phone")));
            }
        } catch (SQLException ex) {
            System.out.println("err getCustomer");
            ex.printStackTrace();
        }
        return customers;
    }
}
