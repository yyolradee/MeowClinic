package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;

/**
 *
 * @author pongp
 */
public class Database {

    private String hostName;
    private String username;
    private String password;

    private Connection connect = null;
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

    public static Statement getStatement() {
        return Database.statement;
    }
}
