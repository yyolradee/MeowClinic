package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pongp
 */
public class Database {

    private String hostName;
    private String username;
    private String password;

    private static Connection connect = null;
    private static Statement statement = null;

    public Database() {
        if (statement == null) {
            hostName = "jdbc:mysql://remotemysql.com/9fslco4p28";
            username = "9fslco4p28";
            password = "w0OBdIk9SV";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(this.hostName, this.username, this.password);
                statement = connect.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("You can only connect once.");
        }
    }

    public void closeConnection() {
        try {
            if (connect != null) {
                statement.close();
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void noInjection(String sql) {
//        try {
//            PreparedStatement pre = Database.connect.prepareStatement(sql);
//            for (int i = 1; i <= count(sql, '?'); i++) {
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static int count(String someString, char someChar) {
//        int count = 0;
//        for (int i = 0; i < someString.length(); i++) {
//            if (someString.charAt(i) == someChar) {
//                count++;
//            }
//        }
//        return count;
//    }

    public static Connection getConnection() {
        return Database.connect;
    }

    public static Statement getStatement() {
        return Database.statement;
    }
}
