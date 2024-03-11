/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.sql.*;

/**
 *
 * @author Nasef
 */
public class databaseManager {
    
    String databaseName="otlob";
    String databaseUser="root";
    String databasePassword="";
    String url= "jdbc:mysql://localhost/"+databaseName;
    Connection databaseLink;


public Connection databaseConnect(){
    try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          databaseLink= DriverManager.getConnection(url, databaseUser, databasePassword);
          return databaseLink;
    }catch(Exception e){
        
        System.out.println("Error Connecting");
        return null;
    }
        

}
}