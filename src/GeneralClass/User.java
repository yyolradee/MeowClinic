/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneralClass;

import java.io.Serializable;

/**
 *
 * @author pongp
 */
public class User implements Serializable {

    private int id;
    private String displayName;
    private String userName;
    private String password;
    
    public User(int id, String displayName, String userName) {
        this(id, displayName, userName, "");
    }

    public User(int id, String displayName, String userName, String password) {
        this.id = id;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}
