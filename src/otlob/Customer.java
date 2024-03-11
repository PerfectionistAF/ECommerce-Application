/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nasef
 */
public class Customer extends User {
    private String fullname;
    private String email;
    private String phone;

    
    
    public void regestiration(String fullname, String email, String phone, String username, String password){
        super.username=username;
        super.password=password;
        this.email=email;
        this.fullname=fullname;
        this.phone=phone;
    
    }
    
    public boolean customerLogin(String username, String password){
        String query ="SELECT * FROM `users` WHERE user_role=1 and user_username='"+username+"' and user_password='"+password+"'";
        ResultSet rs;
        try {
            rs = super.databaseLink.createStatement().executeQuery(query);
            while(rs.next()){
                return true;
            }


        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

            return false;
    }
    
    public void login(String username, String password){
    
    }
    
    public void order(int restaurant_id, int meal_id, int quantity, boolean payment, String creditcard, String cvve){
        
    }

    public Customer() {
        
        
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
