/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nasef
 */
public class Admin extends User {
    
    
      public void resetDatabase(){
        String q1= "truncate table users";
        String q2= "truncate table meals";
        String q3= "truncate table restaurants";
        String q4= "INSERT INTO `users` (`user_fullname`, `user_username`, `user_password`, `user_email`, `user_phone`, `user_id`, `user_role`) VALUES ('test1', 'test1', 'test1', 'test1@gmail.com', '01005365363', NULL, '1'), ('test2', 'test2', 'test2', 'test2@gmail.com', '0352352352', NULL, '1'), ('admin', 'admin', 'admin', 'admin@gmail.com', '01535352', NULL, '0')";
        String q5="INSERT INTO `restaurants` (`restaurant_id`, `restaurant_name`) VALUES (NULL, 'KFC'), (NULL, 'McDonald\\'s'), (NULL, 'Papa John\\'s')";
        String q6="INSERT INTO `meals` (`meal_id`, `resturant_id`, `meal_name`, `meal_price`) VALUES (NULL, '1', 'Family Box', '300'), (NULL, '1', 'Chicken Wrap', '50'), (NULL, '2', 'Big Mac', '60'), (NULL, '2', 'McFurry', '30'), (NULL, '3', 'Chicken Ranch', '300'), (NULL, '3', 'Peperoni', '320')";
        
          try {
              super.databaseLink.createStatement().executeUpdate(q1);
              super.databaseLink.createStatement().executeUpdate(q2);
              super.databaseLink.createStatement().executeUpdate(q3);
              super.databaseLink.createStatement().executeUpdate(q4);
              super.databaseLink.createStatement().executeUpdate(q5);
              super.databaseLink.createStatement().executeUpdate(q6);
          } catch (SQLException ex) {
              Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
          }
        

        
    }  
    public void addMeal(String meal_name,int resturant_id, double meal_price){
        String query= "INSERT INTO `meals` (`resturant_id`, `meal_name`, `meal_price`) VALUES ('"+resturant_id+"', '"+meal_name+"', '"+meal_price+"')";
        try {
            super.databaseLink.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error Adding Restaurant" +ex);
        }
        
    }
    
    public ArrayList<Resturant>  getRestaurants(){
        ArrayList<Resturant> restaurant = new ArrayList<Resturant>();
        String query ="SELECT * FROM `restaurants`";
        ResultSet rs;
        try {
            rs = super.databaseLink.createStatement().executeQuery(query);
            while(rs.next()){
                restaurant.add(new Resturant(rs.getString("restaurant_name")));
            }
            return restaurant;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }
    
    public ArrayList<Meal> getMeals(int restaurant_id){
        
        ArrayList<Meal> meal = new ArrayList<Meal>();
        String query ="SELECT * FROM `meals` WHERE resturant_id="+restaurant_id;
        ResultSet rs;
        try {
            rs = super.databaseLink.createStatement().executeQuery(query);
            while(rs.next()){
                meal.add(new Meal(rs.getInt("resturant_id"), rs.getString("meal_name"), rs.getDouble("meal_price")));
            }

            return meal;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    
    }
    
    public boolean adminLogin(String username, String password){
        String query ="SELECT * FROM `users` WHERE user_role=0 and user_username='"+username+"' and user_password='"+password+"'";
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
    
    public void deleteMeal(int meal_id,int restaurant_id){
    
    }
    
    public void addRestaurant(String resturant_name){
        String query= "INSERT INTO `restaurants` (`restaurant_name`) VALUES ('"+resturant_name+"');";
        try {
            super.databaseLink.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error Adding Restaurant" +ex);
        }

    }
    public void deleteRestaurant(int restaurant_id){
        //DELETE FROM `restaurants` WHERE `restaurants`.`restaurant_id` = 6
        
        String query= "DELETE FROM `restaurants` WHERE `restaurants`.`restaurant_id` = "+restaurant_id;
        try {
            super.databaseLink.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error Deleting Restaurant" +ex);
        }

    
    }
    
    public void regestiration(String fullname, String email, String phone, String username, String password){
    String query="INSERT INTO `users` (`user_fullname`, `user_username`, `user_password`, `user_email`, `user_phone`, `user_role`) VALUES ('"+fullname+"', '"+username+"', '"+password+"', '"+email+"', '"+phone+"', '1')";
      try {
            super.databaseLink.createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Regestiration Error" +ex);
        }
    }

    public Admin() {
        

        
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
