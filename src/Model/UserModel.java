/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author pongp
 */
public class UserModel {

    public void getUser() {
        String sql = "select * from tbl_employee";
        ResultSet rec;
        try {
            rec = Database.getStatement().executeQuery(sql);
            while ((rec != null) && (rec.next())) {
                System.out.print(rec.getString("emp_id"));
                System.out.print(rec.getString("emp_user"));
                System.out.println(rec.getString("emp_salary"));
            }
        } catch (SQLException ex) {
            System.out.println("err");
        }
    }
}
