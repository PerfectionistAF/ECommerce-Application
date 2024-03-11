/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.sql.Connection;

/**
 *
 * @author Nasef
 */
public class User {
    protected String username;
    protected String password;
    protected Connection databaseLink;

    public User() {
        
        databaseManager db = new databaseManager();
        databaseLink=db.databaseConnect();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
