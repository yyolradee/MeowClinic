/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GeneralClass.Product;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author pongp
 */
public class CashierModel {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM products";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                products.add(new Product(rec.getInt("id"), rec.getString("name"), rec.getDouble("price"), rec.getString("description")));
            }
        } catch (SQLException ex) {
            System.out.println("err getUser");
            ex.printStackTrace();
        }
        return products;
    }
}
