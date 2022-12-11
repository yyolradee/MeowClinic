/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GeneralClass.Customer;
import GeneralClass.Pet;
import GeneralClass.User;
import GeneralClass.Queue;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author pongp
 */
public class QueueModel {

    public LinkedList getQueues() {
        LinkedList<Queue> queue = new LinkedList<Queue>();
        String sql = "SELECT * FROM queues JOIN customers ON customers.id = queues.customer_id JOIN pets ON pets.id = queues.pet_id JOIN users ON users.id = queues.user_id";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                Pet pet = new Pet(rec.getInt("pets.id"), rec.getInt("pets.customer_id"), rec.getString("pets.name"), rec.getDouble("pets.weight"), rec.getString("pets.color"), rec.getString("pets.type"), rec.getString("pets.species"));
                Customer cus = new Customer(rec.getInt("customers.id"), rec.getString("customers.firstName"), rec.getString("customers.lastName"), rec.getString("customers.phone"));
                User user = new User(rec.getInt("users.id"), rec.getString("users.displayName"), rec.getString("users.username"));
                queue.add(new Queue(rec.getInt("queues.id"), rec.getString("queues.time"), cus, pet, user));
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return queue;
    }

    public Queue getQueue(int id) {
        String sql = "SELECT * FROM queues JOIN customers ON customers.id = queues.customer_id JOIN pets ON pets.id = queues.pet_id JOIN users ON users.id = queues.user_id WHERE queues.id = " + id;
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            if ((rec != null) && (rec.next())) {
                Pet pet = new Pet(rec.getInt("pets.id"), rec.getInt("pets.customer_id"), rec.getString("pets.name"), rec.getDouble("pets.weight"), rec.getString("pets.color"), rec.getString("pets.type"), rec.getString("pets.species"));
                Customer cus = new Customer(rec.getInt("customers.id"), rec.getString("customers.firstName"), rec.getString("customers.lastName"), rec.getString("customers.phone"));
                User user = new User(rec.getInt("users.id"), rec.getString("users.displayName"), rec.getString("users.username"));
                return new Queue(rec.getInt("queues.id"), rec.getString("queues.time"), cus, pet, user);
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return null;
    }

    public Queue addQueue(String time, int customer_id, int pet_id, int user_id) {
        try {
            String sql = "INSERT INTO queues (time,customer_id,pet_id,user_id) values (?, ?, ?, ?)";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, time);
            pre.setInt(2, customer_id);
            pre.setInt(3, pet_id);
            pre.setInt(4, user_id);
            pre.executeUpdate();
            ResultSet rec = pre.getGeneratedKeys();
            if ((rec != null) && (rec.next())) {
                return getQueue(rec.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("err addPet");
            ex.printStackTrace();
        }
        return null;
    }

    public void delQueue(int id) {
        try {
            String sql = "DELETE FROM queues WHERE id = ?";
            PreparedStatement pre = Database.getConnection().prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("err delPet");
            ex.printStackTrace();
        }
    }
}
